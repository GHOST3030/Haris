# المرحلة 5 — Threat Intelligence (Hash-based)

**الهدف:** طبقة تعرّف على تطبيقات معروفة الخطورة دون رفع بيانات المستخدم بالكامل.

## المهام
- حساب `SHA-256` لكل APK محليًا.
- مقارنة الـhash مع مصدر Threat Intelligence خارجي
  (مثل VirusTotal API عبر hash فقط، وليس رفع الملف).
- تصميم قاعدة بيانات محلية مبدئية (malware_hashes, suspicious_packages)
  قابلة للتحديث لاحقًا من Backend.
- دمج النتيجة (Known / Unknown / Suspicious) في الـRisk Engine كإشارة إضافية.

## مبدأ حاكم
لا يُرفع الـAPK كاملًا بشكل افتراضي — الـhash فقط هو ما يُرسل للفحص.
