# Phase 2 — Risk Engine (local, Kotlin)

**Goal:** Turn raw findings into an explainable risk score.

## Tasks
- Design `RiskEngine` as a separate unit that ingests all module outputs and returns
  `RiskScore` + `List<RiskReason>`.
- **Configurable** scoring system (JSON/config, not hardcoded):

| Signal | Points |
|---|---|
| Unknown source | +20 |
| Accessibility capability | +25 |
| Overlay capability | +15 |
| SMS permissions | +15 |
| Device admin | +20 |
| Microphone + background | +10 |
| Camera + background | +10 |
| Known malicious signature | +100 |

- Classification:
  - SAFE: 0-20
  - LOW: 21-40
  - MEDIUM: 41-60
  - HIGH: 61-80
  - CRITICAL: 81+

- **Core rule:** every score must always come with a "why" (explainability) — no verdict without reasoning.
- Build `IntegrityChecker` (root indicators: su binary, Magisk indicators, root management apps).
- Build `BootloaderChecker` (LOCKED / UNLOCKED / UNKNOWN).
- Both feed the Risk Engine as additional signals, never as final verdicts.
- Test the Risk Engine against mock scenarios for every severity level.

## Exit Criteria for Phase 3
The full engine (Scanner + Risk Engine) runs and produces valid, explained JSON reports,
manually verified with zero UI involved.
