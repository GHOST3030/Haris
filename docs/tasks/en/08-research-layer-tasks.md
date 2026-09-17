# Phase 8 Tasks — Security Research Layer (advanced, optional)

## Behavioral Indicators
- [ ] Define an initial list of behavioral patterns worth watching (e.g. a new app suddenly requesting many permissions).
- [ ] Build a mechanism comparing an app's current behavior against its past behavior (via Scan History).
- [ ] Design a new `BehavioralAnomaly` signal feeding into the Risk Engine.

## Application Reputation
- [ ] Design a mechanism to aggregate anonymized data from multiple users (via the backend) about a given app.
- [ ] Compute an initial "reputation score" based on how many users flagged issues with a given app.
- [ ] Merge the reputation score as an additional Risk Engine signal.

## Certificate Analysis
- [ ] Extract the signing certificate for each installed app.
- [ ] Compare the certificate against a database of known certificates (trusted/untrusted).
- [ ] Detect "same app name, different certificate" cases (potential impersonation indicator).

## Component Analysis
- [ ] Extract the list of exported Services per app.
- [ ] Extract the list of exported Broadcast Receivers.
- [ ] Extract the list of exported Content Providers.
- [ ] Extract the list of exported Activities with no permission protection.
- [ ] Define initial criteria for flagging these components as risky (exported + no defined permission).

## Anomaly Detection (simple rules first)
- [ ] Define a set of simple rule-based checks for unusual behavior, with no ML at this stage.
- [ ] Test the rules against real data and manually verify the results.
- [ ] Document each rule and its rationale clearly.

## Exit Criteria
- [ ] The four sections above are merged into the final scan report incrementally (one at a time), each independently toggleable.
