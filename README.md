# Vigentra — Android Security & Privacy Scanner

A Security Scanner + Risk Assessment + Privacy Monitor for Android that aggregates
multiple system-level signals into an explained risk score.

- Full project plan: [docs/plan/en](docs/plan/en/00-overview.md) | [docs/plan/ar](docs/plan/ar/00-overview.md)
- Approach: native engine first (Kotlin) → risk engine → Flutter bridge → UI → threat intel → network/privacy → backend → research layer.

## Structure
```
android/       # Kotlin security engine (Phase 1-2)
flutter_app/   # Flutter app (added from Phase 3 onward)
docs/plan/     # Full phased project plan (AR + EN)
```

## Status
Phase 1: native scanning engine — in progress.
- [x] Gradle Android project scaffolded (`android/`, module `vigentra-security-engine`, applicationId `com.vigentra.security`, minSdk 29).
- [ ] AppScanner, PermissionAnalyzer, AccessibilityMonitor, OverlayDetector, DeviceAdminChecker implementations.
