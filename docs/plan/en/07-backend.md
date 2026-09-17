# Phase 7 — Backend (NestJS + Supabase/PostgreSQL)

**Goal:** Comes only after everything works locally — not before.

## Tasks
- NestJS API that receives only aggregated data
  (Risk Score, scanner version, device integrity summary) — never raw sensitive data.
- Supabase/PostgreSQL for:
  - user accounts (Supabase Auth)
  - scan history (optional, with user consent)
  - a threat-intelligence database that can be updated server-side and pushed to the app
    (instead of being hardcoded in the app)
- An endpoint to periodically push updated `malware_hashes` / `suspicious_packages` to devices.
- HTTPS + Certificate Pinning between Flutter and NestJS.
