# Project Vigentra — Overview

## Name
**Vigentra** — a tool that watches and assesses, never claims to detect "hacking" with absolute certainty.
Alternatives: SentraScan, GuardLens, RiskLens, ShieldSense.

## Philosophy
A Security Scanner + Risk Assessment + Privacy Monitor that aggregates multiple system-level signals into an explained risk score.

## Architectural Decision
Native (Kotlin) first → Risk Engine → Bridge (MethodChannel) → Flutter UI → Threat Intelligence → Network/Privacy → Backend → Research Layer.

## Phase Order
| File | Phase |
|---|---|
| 01-native-engine.md | Native scanning engine setup (Kotlin only) |
| 02-risk-engine.md | Risk Engine |
| 03-bridge-flutter-scaffold.md | Bridge + Flutter scaffold |
| 04-flutter-ui.md | Full UI build |
| 05-threat-intelligence.md | Threat Intelligence |
| 06-network-privacy.md | Network Security + Privacy Center |
| 07-backend.md | Backend |
| 08-research-layer.md | Security Research Layer |
| 09-stack-and-principles.md | Final stack + governing principles |

## Stack Summary
Flutter + Kotlin + MethodChannel + Riverpod + SQLite/Drift + NestJS + PostgreSQL/Supabase.
Feature-First architecture, minimum Android 10+.
