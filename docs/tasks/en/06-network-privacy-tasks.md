# Phase 6 Tasks — Network Security + Privacy Center

## Network Security Module
- [ ] Read current Wi-Fi state (SSID, encryption type where possible) via `WifiManager`.
- [ ] Check for an active VPN connection via `ConnectivityManager` / `NetworkCapabilities`.
- [ ] Read the current Private DNS setting.
- [ ] Attempt to detect a system-level configured proxy.
- [ ] Read/evaluate the app's own Network Security Config (if present).
- [ ] Check for potential cleartext (unencrypted HTTP) connections at the app config level.
- [ ] Aggregate results into `data class NetworkSecuritySignal`.
- [ ] Write neutral explanatory copy (never claiming full MITM detection).

## Privacy Center — Data Collection
- [ ] Build a list of all apps holding the Camera permission.
- [ ] Build a list of all apps holding the Microphone permission.
- [ ] Build a list of all apps holding the Location permission.
- [ ] Build a list of all apps holding the Contacts permission.
- [ ] Build a list of all apps holding the SMS permission.
- [ ] Build a list of all apps holding the Accessibility permission.
- [ ] Build a list of all apps holding the Notifications permission.

## Privacy Center — Recent Usage
- [ ] Use `AppOpsManager` to determine the last time a sensitive permission was used (on supported Android versions).
- [ ] Display "last used" next to each app in the list (where data is available).
- [ ] Handle devices/versions that don't support this feature gracefully (fallback with no crashes).

## Flutter UI for Privacy Center
- [ ] Build the Privacy Center screen with tabs per permission category.
- [ ] Show a per-category app count at the top (quick summary).
- [ ] Allow direct navigation to the app's system permission settings.

## Data Protection Principle
- [ ] Review every data-transmission point (if any) and confirm it never carries actual content (messages/contacts), only summaries.
- [ ] Explicitly document (code comments) any network call that exports data, stating exactly what is sent.

## Exit Criteria
- [ ] Both the Network Security and Privacy Center screens work fully on real device data without sending any sensitive data externally.
