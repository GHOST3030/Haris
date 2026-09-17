# Phase 3 Tasks — The Bridge (MethodChannel) + Flutter Scaffold

## Flutter Project Setup
- [ ] Create a new Flutter project inside `flutter_app/`.
- [ ] Enable Android support only for this phase (ignore iOS for now).
- [ ] Wire the existing Kotlin module in `android/` into the Flutter project (as a source set or local plugin).
- [ ] Confirm the Flutter project's Gradle build succeeds with the merged native code.

## MethodChannel
- [ ] Define a channel named `com.vigentra/security_engine` on both the native (Kotlin) and Dart sides.
- [ ] Implement a `MethodCallHandler` in `MainActivity.kt` to receive calls.
- [ ] Implement `quickScan()` running a subset of checks and returning JSON.
- [ ] Implement `deepScan()` running every check available from Phase 1-2.
- [ ] Implement `privacyScan()` (initial placeholder — full details land in Phase 6).
- [ ] Handle exceptions and surface them as clear `PlatformException`s to Dart.

## Dart Side
- [ ] Create a `SecurityEngineBridge` class wrapping MethodChannel calls.
- [ ] Write async Dart functions: `Future<Map> quickScan()`, `deepScan()`, `privacyScan()`.
- [ ] Create Dart models (`ScanResult`, `RiskScore`, `RiskReason`) matching the incoming Kotlin JSON shape.
- [ ] Write parsing (manual or via `json_serializable`) converting JSON into models.
- [ ] Handle error states in Dart (clear messaging on call failure).

## Temporary Debug Screen
- [ ] Build a simple Flutter screen with a "Run Scan" button.
- [ ] Display the raw JSON (or the parsed model) as text after tapping the button.
- [ ] Add a basic loading indicator while awaiting the result.

## Riverpod Setup
- [ ] Add the Riverpod package to the project.
- [ ] Create a first simple provider (`securityEngineProvider`) wrapping `SecurityEngineBridge`.
- [ ] Wire the debug screen to the provider instead of calling the bridge directly.

## Exit Criteria
- [ ] Tapping "Scan" in a real Flutter app (device/emulator) returns a correct result matching what the native engine produces.
