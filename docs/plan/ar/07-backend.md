# المرحلة 7 — Backend (NestJS + Supabase/PostgreSQL)

**الهدف:** يأتي بعد أن يعمل كل شيء محليًا، وليس قبل ذلك.

## المهام
- NestJS API لاستقبال بيانات مجمّعة فقط
  (Risk Score, Scanner version, Device integrity summary) — لا بيانات خام حساسة.
- Supabase/PostgreSQL لتخزين:
  - user accounts (Supabase Auth)
  - Scan history (اختياري/مع موافقة المستخدم)
  - Threat Intelligence database قابلة للتحديث من السيرفر إلى التطبيق
    (بدل أن تكون hardcoded في التطبيق).
- Endpoint لتحديث `malware_hashes` / `suspicious_packages` بشكل دوري إلى الجهاز.
- HTTPS + Certificate Pinning للاتصال بين Flutter و NestJS.
