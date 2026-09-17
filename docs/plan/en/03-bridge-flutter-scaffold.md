# Phase 3 — The Bridge (MethodChannel) + Flutter Scaffold

**Goal:** Connect the working engine to a bare-bones Flutter app (no final design yet).

## Tasks
- Create a Flutter project and wire the Kotlin module in as native Android code/plugin.
- Define one MethodChannel (`com.vigentra/security_engine`) with methods:
  - `quickScan()`
  - `deepScan()`
  - `privacyScan()`
- Pass scan results as JSON from Kotlin to Dart, with simple parsing
  (via `json_serializable` or manual models).
- A single temporary Flutter debug screen that just dumps the raw JSON as text,
  to confirm the bridge works end-to-end.
- Set up Riverpod as state management from this point forward.

## Exit Criteria for Phase 4
Tapping "Scan" in a real Flutter app returns a correct result from the native engine.
