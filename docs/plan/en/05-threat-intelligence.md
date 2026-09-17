# Phase 5 — Threat Intelligence (Hash-based)

**Goal:** Identify known-risky apps without uploading the user's full data.

## Tasks
- Compute `SHA-256` for each APK locally.
- Compare the hash against an external threat-intelligence source
  (e.g. VirusTotal API via hash lookup only, never uploading the file).
- Design an initial local database (malware_hashes, suspicious_packages),
  updatable later from the backend.
- Feed the result (Known / Unknown / Suspicious) into the Risk Engine as an additional signal.

## Guiding Principle
The full APK is never uploaded by default — only the hash is sent for lookup.
