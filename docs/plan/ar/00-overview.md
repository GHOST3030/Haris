# مشروع Vigentra — نظرة عامة

## الاسم
**Vigentra** — أداة تراقب وتقيّم، لا تدّعي كشف الاختراق بشكل مطلق.
بدائل: SentraScan, GuardLens, RiskLens, ShieldSense.

## الفلسفة
Security Scanner + Risk Assessment + Privacy Monitor يجمع إشارات متعددة ويحولها إلى درجة خطورة مفسَّرة.

## القرار المعماري
Native (Kotlin) أولًا → Risk Engine → الجسر (MethodChannel) → Flutter UI → Threat Intelligence → Network/Privacy → Backend → Research Layer.

## ترتيب المراحل
| الملف | المرحلة |
|---|---|
| 01-native-engine.md | إعداد محرك الفحص (Kotlin فقط) |
| 02-risk-engine.md | Risk Engine |
| 03-bridge-flutter-scaffold.md | الجسر + Flutter هيكلي |
| 04-flutter-ui.md | بناء الـUI الكامل |
| 05-threat-intelligence.md | Threat Intelligence |
| 06-network-privacy.md | Network Security + Privacy Center |
| 07-backend.md | Backend |
| 08-research-layer.md | Security Research Layer |
| 09-stack-and-principles.md | Stack النهائي + المبادئ الحاكمة |

## Stack مختصر
Flutter + Kotlin + MethodChannel + Riverpod + SQLite/Drift + NestJS + PostgreSQL/Supabase.
Feature-First architecture، أقل إصدار Android 10+.
