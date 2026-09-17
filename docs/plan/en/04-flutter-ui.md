# Phase 4 — Building the Full UI (Flutter)

**Goal:** Turn raw data into a polished user experience.

## Tasks
- Feature-First structure:
```
lib/
├── core/ (constants, theme, routing, security, utils)
└── features/
    ├── dashboard/
    ├── device_scan/
    ├── applications/
    ├── permissions/
    ├── network_security/
    └── scan_history/
```

- **Dashboard:** overall security score (e.g. 82/100), "SECURE/AT RISK" status, Scan button, checklist (✓/⚠).
- **Scan Screen:** clear distinction between:
  - Quick Scan (~10-30s)
  - Deep Scan
  - Privacy Scan
- **Applications Screen:** list of installed apps with a per-app risk score and details
  (Source, Permissions, Accessibility, Overlay...).
- **Security Report Screen:** a "why" explanation for every finding
  (e.g. "Unknown application installed", "Accessibility access enabled") —
  never alarmist language like "your device is hacked."
- **Scan History:** persist scan results locally (SQLite/Drift) to show trends over time.
- Localization (Arabic/English) starts in this phase.
