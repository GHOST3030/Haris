package security.risk

/**
 * Phase 2 — Aggregates all module findings into an explainable RiskScore.
 * Scoring weights must be externally configurable (JSON/config), never hardcoded.
 */
data class RiskReason(val signal: String, val points: Int, val explanation: String)

data class RiskScore(val total: Int, val level: String, val reasons: List<RiskReason>)

class RiskEngine {
    // TODO: implement scoring + SAFE/LOW/MEDIUM/HIGH/CRITICAL classification
}
