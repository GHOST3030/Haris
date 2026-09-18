package security.apps

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder

private const val TAG = "Vigentra.AppScannerDebug"

/**
 * Manual debug entry point for Phase 1 verification.
 * Call [dumpToLogcat] from any Context (e.g. MainActivity in Phase 3) to
 * confirm AppScanner produces valid JSON output on a real device.
 */
object AppScannerDebug {
    fun dumpToLogcat(context: Context) {
        val scanner = AppScanner(context)
        val apps = scanner.scanInstalledApps()
        val json = GsonBuilder().setPrettyPrinting().create().toJson(apps)
        Log.d(TAG, "Scanned ${apps.size} installed apps")
        Log.d(TAG, json)
    }
}
