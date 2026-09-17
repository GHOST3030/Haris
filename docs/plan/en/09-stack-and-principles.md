# Final Stack + Governing Principles

## Final Stack

| Layer | Technology |
|---|---|
| UI | Flutter |
| Language | Dart |
| Security Engine | Kotlin |
| Communication | MethodChannel / EventChannel |
| State Management | Riverpod |
| Local DB | SQLite / Drift |
| Backend | NestJS |
| Database | PostgreSQL / Supabase |
| Auth | Supabase Auth |
| Threat Intelligence | Hash-based APIs |
| Cryptography | Android Keystore |
| Networking | HTTPS + Certificate Pinning where relevant |
| Architecture | Feature-First |
| Min Android | Android 10+ |

## Governing Principles Throughout the Project
1. **No absolute claims**: "Security Risk Detected — Risk Level: HIGH", never "Your device is hacked."
2. **Root/Unlocked Bootloader ≠ Malware** — a risk signal only.
3. **Accessibility/Overlay/SMS permission alone ≠ Malware** — risk comes from the combination of signals.
4. **Never upload full user data** (Contacts/SMS/Photos) to any server without explicit need and consent.
5. **Every risk score must be explained** — explainability first.
6. **Scoring must be externally configurable** (config file), never hardcoded.
7. **No UI before the engine actually works** — no fake "Scan animation" backed by `Future.delayed`.

## Suggested Next Step
Start immediately with **Phase 1**: set up a standalone Kotlin/Android project and build the first
module (`AppScanner`), testing it on a real device before writing a single line of Flutter.
