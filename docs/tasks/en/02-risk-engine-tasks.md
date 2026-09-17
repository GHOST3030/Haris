# Phase 2 Tasks — Risk Engine

## Config Structure
- [ ] Design an external JSON/YAML file for scoring weights (not hardcoded).
- [ ] Define fields: `signal`, `points`, `description`.
- [ ] Write a function to load and parse the config at runtime.
- [ ] Set the agreed default values (Unknown source +20, Accessibility +25, etc.).

## RiskEngine — Structure
- [ ] Define `data class RiskReason(signal, points, explanation)`.
- [ ] Define `data class RiskScore(total, level, reasons: List<RiskReason>)`.
- [ ] Write `calculateScore(rawResult: ScanRawResult): RiskScore`.
- [ ] Implement aggregation logic across all signals (unknown source, accessibility, overlay, SMS, device admin, background camera/mic...).
- [ ] Write the level-classification logic: SAFE/LOW/MEDIUM/HIGH/CRITICAL based on the total.
- [ ] Ensure every point added to the total carries a clear `RiskReason`.

## IntegrityChecker (Root)
- [ ] Check for a `su` binary in common paths (`/system/bin/su`, `/system/xbin/su`...).
- [ ] Check for known root-management apps via PackageManager.
- [ ] Check suspicious system properties (`ro.debuggable`, `ro.secure`).
- [ ] Aggregate results into `data class IntegritySignal(indicator, detected)`.
- [ ] Feed results into the Risk Engine as an additional signal (never a final "device is hacked" verdict).

## BootloaderChecker
- [ ] Read bootloader state via available properties (`ro.boot.verifiedbootstate` or equivalent).
- [ ] Classify state: LOCKED / UNLOCKED / UNKNOWN.
- [ ] Handle cases where the state can't be read (system permission restrictions).

## Testing
- [ ] Create mock data representing: a clean device, a device with a suspicious app, a rooted device.
- [ ] Verify each scenario classifies at the correct level (SAFE/LOW/MEDIUM/HIGH/CRITICAL).
- [ ] Verify every result carries a clear, non-redundant explanation (explainability).
- [ ] Test weight sensitivity (change config, re-test, confirm the change is actually reflected).

## Exit Criteria
- [ ] RiskEngine merged with Phase 1 output produces a complete JSON report (raw + score + reasons), manually verified.
