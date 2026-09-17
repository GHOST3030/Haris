# Phase 1 — Core Engine Setup (Kotlin only, no Flutter)

**Goal:** A standalone Kotlin environment (plain Android project or Gradle module) to build and test scanners with zero UI.

## Tasks
- Set up an Android project (or a separate Gradle module), reusable later as a plugin.
- Build `AppScanner`: enumerate installed apps via `PackageManager`
  (packageName, versionName, installerPackage, targetSdk, minSdk, debuggable flag, isSystemApp).
- Build `PermissionAnalyzer`: extract each app's requested permissions and classify them
  (dangerous / normal / signature).
- Build `AccessibilityMonitor`: read enabled services via `AccessibilityManager`.
- Build `OverlayDetector`: check for apps holding `SYSTEM_ALERT_WINDOW`.
- Build `DeviceAdminChecker`: enumerate Device Administrators via `DevicePolicyManager`.
- Test each module via Logcat or simple unit tests on a real device/emulator.

## Code Structure
```
android/app/src/main/kotlin/security/
├── scanner/
├── apps/
├── permissions/
├── integrity/
├── network/
└── risk/
```

## Phase Output
Every module returns a structured, JSON-serializable `data class` — raw findings only, no risk judgment yet.

## Exit Criteria
Every module works independently and produces correct raw data, verified on a real device.
