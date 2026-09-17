# Stack النهائي + المبادئ الحاكمة

## Stack النهائي

| الطبقة | التقنية |
|---|---|
| UI | Flutter |
| اللغة | Dart |
| محرك الأمان | Kotlin |
| الاتصال | MethodChannel / EventChannel |
| إدارة الحالة | Riverpod |
| قاعدة بيانات محلية | SQLite / Drift |
| Backend | NestJS |
| قاعدة بيانات | PostgreSQL / Supabase |
| المصادقة | Supabase Auth |
| Threat Intelligence | Hash-based APIs |
| التشفير | Android Keystore |
| الشبكة | HTTPS + Certificate Pinning حيث يلزم |
| المعمارية | Feature-First |
| أقل إصدار Android | Android 10+ |

## مبادئ حاكمة يجب الالتزام بها طوال المشروع
1. **لا ادعاءات مطلقة**: "Security Risk Detected — Risk Level: HIGH" وليس "الجهاز مخترق".
2. **Root/Bootloader Unlocked ≠ Malware** — إشارة خطر فقط.
3. **Accessibility/Overlay/SMS Permission ≠ Malware بمفرده** — التجميع هو ما يرفع الخطورة.
4. **لا رفع بيانات المستخدم الكاملة** (Contacts/SMS/Photos) إلى أي خادم بدون داعٍ صريح وموافقة.
5. **كل Risk Score يجب أن يكون مفسَّرًا** (Explainability أولاً).
6. **Scoring قابل للتعديل من خارج الكود** (config)، وليس Hardcoded.
7. **UI لا يُبنى قبل أن يعمل المحرك فعليًا** — لا "Scan animation" فارغة بـ`Future.delayed`.

## الخطوة التالية المقترحة
البدء فورًا في **المرحلة 1**: إنشاء مشروع Kotlin/Android مستقل وبناء أول Module (`AppScanner`)
واختباره على جهاز حقيقي قبل كتابة أي سطر Flutter.
