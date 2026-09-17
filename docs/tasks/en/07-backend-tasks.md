# Phase 7 Tasks — Backend (NestJS + Supabase/PostgreSQL)

## Project Setup
- [ ] Create a new NestJS project (`backend/`).
- [ ] Configure the Supabase/PostgreSQL connection.
- [ ] Set up environment variables (`.env`) for keys/connections (excluded from Git).
- [ ] Set up Supabase Auth integration with NestJS (JWT verification).

## Database
- [ ] Design `users` table (typically managed directly by Supabase Auth).
- [ ] Design `scan_summaries` table (user_id, risk_score, risk_level, scanner_version, created_at) — aggregated data only.
- [ ] Design `malware_hashes` table (hash, status, source, updated_at).
- [ ] Design `suspicious_packages` table (package_name, reason, severity, updated_at).
- [ ] Write migrations for all tables above.

## Endpoints
- [ ] `POST /scan-summary` — receive an aggregated scan summary from the app and store it.
- [ ] `GET /threat-intel/hashes` — return the updated hash list (with pagination/last-updated support).
- [ ] `GET /threat-intel/packages` — return the updated suspicious-packages list.
- [ ] `POST /threat-intel/report` (optional) — allow users to report a suspicious app.
- [ ] Protect all endpoints with JWT auth via Supabase Auth.
- [ ] Validate all inputs (DTO validation) on every endpoint.

## Connecting to Flutter
- [ ] Add an HTTP client in Flutter (Dio or http) configured with the backend's base URL.
- [ ] Enable Certificate Pinning between the app and the backend.
- [ ] Build a periodic sync mechanism to refresh `malware_hashes`/`suspicious_packages` locally from the backend.
- [ ] Send the scan summary to the backend only with explicit user consent (a settings toggle).

## Testing & Deployment
- [ ] Write basic e2e tests for the main endpoints.
- [ ] Set up a Staging environment separate from Production.
- [ ] Document the API (Swagger/OpenAPI via NestJS).

## Exit Criteria
- [ ] A real Flutter app successfully sends a scan summary and receives an updated Threat Intelligence list from a live backend.
