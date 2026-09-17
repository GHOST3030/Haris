# Phase 6 — Network Security + Privacy Center

**Goal:** Extend scanning to network posture and user privacy.

## Network Security Module
- Wi-Fi status
- VPN
- Private DNS
- Proxy
- Network Security Config
- Cleartext traffic
- Without claiming to detect every MITM attack.

## Privacy Center
- Show which apps hold:
  - Camera
  - Microphone
  - Location
  - Contacts
  - SMS
  - Accessibility
  - Notifications
- Flag "recent usage" where possible via `AppOpsManager`.

## Guiding Principle
Send nothing externally beyond what's necessary
(e.g. only `{device_integrity, risk_level, scanner_version}`,
never contact lists or message contents).
