# المرحلة 2 — Risk Engine (محلي، Kotlin)

**الهدف:** تحويل النتائج الخام إلى درجة خطورة قابلة للتفسير.

## المهام
- تصميم `RiskEngine` كوحدة منفصلة تستقبل نتائج كل الـModules وتعيد `RiskScore` + `List<RiskReason>`.
- نظام scoring **قابل للتعديل** (config/JSON، وليس hardcoded):

| الإشارة | النقاط |
|---|---|
| Unknown source | +20 |
| Accessibility capability | +25 |
| Overlay capability | +15 |
| SMS permissions | +15 |
| Device admin | +20 |
| Microphone + background | +10 |
| Camera + background | +10 |
| Known malicious signature | +100 |

- تصنيف النتيجة:
  - SAFE: 0-20
  - LOW: 21-40
  - MEDIUM: 41-60
  - HIGH: 61-80
  - CRITICAL: 81+

- **قاعدة أساسية:** أي نتيجة يجب أن تُرفق دائمًا بـ"لماذا" (Explainability) — لا تقييم بدون تفسير.
- بناء `IntegrityChecker` (Root indicators: su binary, Magisk indicators, root management apps).
- بناء `BootloaderChecker` (LOCKED / UNLOCKED / UNKNOWN).
- كلاهما يغذّيان الـRisk Engine كإشارات إضافية، وليس كأحكام نهائية.
- اختبار الـRisk Engine بسيناريوهات وهمية (Mock data) لكل مستوى خطورة.

## معيار الانتقال للمرحلة 3
المحرك الكامل (Scanner + Risk Engine) يعمل ويُنتج تقارير JSON صحيحة ومفسَّرة، مُختبر يدويًا دون أي واجهة.
