package security.apps

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log

private const val TAG = "Vigentra.AppScanner"

/**
 * Raw, JSON-serializable metadata for a single installed application.
 * No risk judgment is made here — that is the Risk Engine's job (Phase 2).
 */
data class AppInfo(
    val packageName: String,
    val appName: String,
    val versionName: String?,
    val versionCode: Long,
    val installerPackageName: String?,
    val targetSdkVersion: Int,
    val minSdkVersion: Int,
    val isDebuggable: Boolean,
    val isSystemApp: Boolean,
    val firstInstallTime: Long,
    val lastUpdateTime: Long
)

/**
 * Phase 1 — Installed Applications Scanner.
 * Reads installed app metadata via PackageManager and returns raw,
 * JSON-serializable findings only.
 */
class AppScanner(private val context: Context) {

    private val packageManager: PackageManager = context.packageManager

    /**
     * Enumerates every installed application on the device and extracts
     * the metadata fields needed by the Risk Engine and downstream UI.
     */
    fun scanInstalledApps(): List<AppInfo> {
        val flags = PackageManager.GET_META_DATA
        val packages: List<PackageInfo> = try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                packageManager.getInstalledPackages(
                    PackageManager.PackageInfoFlags.of(flags.toLong())
                )
            } else {
                @Suppress("DEPRECATION")
                packageManager.getInstalledPackages(flags)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to enumerate installed packages", e)
            emptyList()
        }

        return packages.mapNotNull { pkg -> toAppInfoOrNull(pkg) }
    }

    private fun toAppInfoOrNull(pkg: PackageInfo): AppInfo? {
        val appInfo: ApplicationInfo = pkg.applicationInfo ?: return null

        return try {
            AppInfo(
                packageName = pkg.packageName,
                appName = packageManager.getApplicationLabel(appInfo).toString(),
                versionName = pkg.versionName,
                versionCode = getVersionCodeCompat(pkg),
                installerPackageName = getInstallerPackageNameCompat(pkg.packageName),
                targetSdkVersion = appInfo.targetSdkVersion,
                minSdkVersion = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    appInfo.minSdkVersion
                } else {
                    -1 // Not available before API 24
                },
                isDebuggable = (appInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0,
                isSystemApp = (appInfo.flags and ApplicationInfo.FLAG_SYSTEM) != 0,
                firstInstallTime = pkg.firstInstallTime,
                lastUpdateTime = pkg.lastUpdateTime
            )
        } catch (e: Exception) {
            Log.w(TAG, "Skipping package ${pkg.packageName}: ${e.message}")
            null
        }
    }

    @Suppress("DEPRECATION")
    private fun getVersionCodeCompat(pkg: PackageInfo): Long {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            pkg.longVersionCode
        } else {
            pkg.versionCode.toLong()
        }
    }

    private fun getInstallerPackageNameCompat(packageName: String): String? {
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                packageManager.getInstallSourceInfo(packageName).installingPackageName
            } else {
                @Suppress("DEPRECATION")
                packageManager.getInstallerPackageName(packageName)
            }
        } catch (e: Exception) {
            null // Unknown source — the Risk Engine treats null as "unknown source"
        }
    }
}
