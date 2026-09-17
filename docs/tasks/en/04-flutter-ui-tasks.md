# Phase 4 Tasks — Building the Full UI (Flutter)

## Overall Structure (Feature-First)
- [ ] Create `core/` with: `constants`, `theme`, `routing`, `security`, `utils`.
- [ ] Create `features/` folders: `dashboard`, `device_scan`, `applications`, `permissions`, `network_security`, `scan_history`.
- [ ] Set up routing between screens (go_router or equivalent).
- [ ] Set up the base theme (colors, typography) fitting a serious security tool — not visual scare tactics.

## Dashboard
- [ ] Build the overall score display (e.g. 82/100) as a circular indicator or card.
- [ ] Show a general text status: SECURE / AT RISK with an appropriate color (not always alarm red).
- [ ] "Scan Device" button triggering Quick Scan by default.
- [ ] Quick checklist (✓/⚠) per main category (Integrity, Applications, Permissions, Network, Accessibility).
- [ ] Wire the screen to a Riverpod provider reading the last saved scan result.

## Scan Screen
- [ ] UI to choose scan type: Quick / Deep / Privacy.
- [ ] Progress indicator/animation during the actual scan (tied to real engine state, never a fake `Future.delayed`).
- [ ] Live count of items scanned where feasible (optionally via EventChannel streaming).
- [ ] Auto-navigate to the Security Report screen when the scan completes.

## Applications Screen
- [ ] A list (ListView) of all installed apps with icon, name, and a short risk indicator.
- [ ] A detail screen per app: Source, Permissions, Accessibility, Overlay, Device Admin.
- [ ] Filter/sort by risk level (highest risk first).
- [ ] Search by name within the list.

## Security Report Screen
- [ ] List detected issues as cards.
- [ ] Each issue shows: title + "why" explanation + risk level.
- [ ] All copy written in neutral language ("Security Risk Detected") — never "your device is hacked."
- [ ] A link/button per issue opening the relevant app's detail screen where applicable.

## Scan History
- [ ] Set up a local database (SQLite via Drift).
- [ ] Design a table storing each scan's result (timestamp, score, level, summary).
- [ ] A screen listing past scans.
- [ ] A simple chart of score over time (optional at this stage).

## Localization
- [ ] Set up a translation system (intl / easy_localization).
- [ ] Extract all fixed strings into translation files (ar.json, en.json).
- [ ] Add a language switcher in Settings (if a settings screen exists).

## Exit Criteria
- [ ] A full flow — Open app → Scan → Report → History — works smoothly with no mock data.
