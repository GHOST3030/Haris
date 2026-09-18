# Phase 1 Tasks — Core Engine Setup (Kotlin)

## Project Setup
- [x] Create a new Android project (or a separate Gradle module named `security-engine`).
- [ ] Set up package structure: `security.scanner`, `security.apps`, `security.permissions`, `security.integrity`, `security.network`, `security.risk`.
- [ ] Configure base Gradle settings (minSdk 29, Kotlin version, dependencies).
- [ ] Set up Git repo/branching for the engine (if separate) or the `android/` folder in the current repo.

## AppScanner
- [ ] Write a function to enumerate all installed apps via `PackageManager.getInstalledPackages()`.
- [ ] Extract `packageName`, `versionName`, `versionCode`.
- [ ] Extract `installerPackageName` (install source).
- [ ] Extract `targetSdkVersion` and `minSdkVersion`.
- [ ] Extract `applicationInfo.flags` to determine `debuggable` and `isSystemApp`.
- [ ] Aggregate all of the above into a `data class AppInfo`.
- [ ] Write a function returning the full `List<AppInfo>`.
- [ ] Test the function on a real device and print results to Logcat.

## PermissionAnalyzer
- [ ] Write a function to fetch a given app's permissions via `PackageManager.getPackageInfo(pkg, GET_PERMISSIONS)`.
- [ ] Build a reference list of known Android "dangerous" permissions.
- [ ] Classify each permission: dangerous / normal / signature.
- [ ] Build `data class PermissionInfo(name, protectionLevel, isGranted)`.
- [ ] Link the result to each `AppInfo` (a permission list per app).
- [ ] Test the function against known apps (e.g. WhatsApp) and verify correctness.

## AccessibilityMonitor
- [ ] Obtain `AccessibilityManager` via `Context.getSystemService`.
- [ ] Fetch `getEnabledAccessibilityServiceList()`.
- [ ] Extract package name and service name for each enabled accessibility service.
- [ ] Build `data class AccessibilityServiceInfo(packageName, serviceName)`.
- [ ] Test by manually toggling an accessibility service and verifying the result.

## OverlayDetector
- [ ] Write a function to check apps holding `SYSTEM_ALERT_WINDOW`.
- [ ] Verify the actual granted state (not just requested).
- [ ] Build `data class OverlayInfo(packageName, isGranted)`.
- [ ] Test against an app that genuinely uses overlays (e.g. a chat-bubble app).

## DeviceAdminChecker
- [ ] Obtain `DevicePolicyManager` via `Context.getSystemService`.
- [ ] Fetch `getActiveAdmins()`.
- [ ] Extract package name for each active Device Admin.
- [ ] Build `data class DeviceAdminInfo(packageName, componentName)`.
- [ ] Test after enabling a test Device Admin (e.g. Find My Device).

## Integration & Testing
- [ ] Build `data class ScanRawResult` aggregating all module outputs above.
- [ ] Write a simple orchestrator function that runs all scans and returns one `ScanRawResult`.
- [ ] Serialize `ScanRawResult` to JSON (Gson or kotlinx.serialization) and verify its shape.
- [ ] Write basic unit tests for each module (using mock data where needed).
- [ ] Document each module with brief KDoc comments.

## Exit Criteria
- [ ] Running the full scan on a real device prints valid JSON to Logcat with no errors.
