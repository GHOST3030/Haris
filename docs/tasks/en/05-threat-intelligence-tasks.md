# Phase 5 Tasks — Threat Intelligence (Hash-based)

## Hash Computation
- [ ] Write a Kotlin function to compute SHA-256 for a given app's APK (via `sourceDir`).
- [ ] Handle errors (large files, restricted read permissions on some devices).
- [ ] Cache the computed hash to avoid recomputation on every scan.

## External Source Integration
- [ ] Choose a Threat Intelligence provider (e.g. VirusTotal API — hash lookup endpoint only).
- [ ] Implement the HTTP call to verify a hash (without uploading any file).
- [ ] Handle responses: Known-clean / Known-malicious / Unknown.
- [ ] Manage API keys securely (never hardcoded as plain text in source).
- [ ] Set a rate limit to avoid exceeding the API quota.

## Initial Local Database
- [ ] Design local tables (SQLite) for `malware_hashes` and `suspicious_packages`.
- [ ] Write a function checking the local database first before calling the external API.
- [ ] Manual update mechanism for the local list at this stage (automatic sync from the backend arrives in Phase 7).

## Integration with the Risk Engine
- [ ] Add a new `ThreatIntelSignal(hash, status)` signal to the Risk Engine.
- [ ] Assign extra points for a "Known malicious" result (matching the agreed +100).
- [ ] Test the full scenario: an app with a hash flagged as malicious (mock test data) results in a CRITICAL rating.

## Exit Criteria
- [ ] Scanning a real app, computing its hash, verifying it against the external API, and merging the result into the final report all succeed.
