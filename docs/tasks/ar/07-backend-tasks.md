# مهام المرحلة 7 — Backend (NestJS + Supabase/PostgreSQL)

## إعداد المشروع
- [ ] إنشاء مشروع NestJS جديد (`backend/`).
- [ ] إعداد الاتصال بقاعدة بيانات Supabase/PostgreSQL.
- [ ] إعداد متغيرات البيئة (`.env`) للمفاتيح والاتصالات (غير مرفوعة إلى Git).
- [ ] إعداد Supabase Auth للتكامل مع NestJS (JWT verification).

## قاعدة البيانات
- [ ] تصميم جدول `users` (يُدار غالبًا عبر Supabase Auth مباشرة).
- [ ] تصميم جدول `scan_summaries` (user_id, risk_score, risk_level, scanner_version, created_at) — بيانات مجمّعة فقط.
- [ ] تصميم جدول `malware_hashes` (hash, status, source, updated_at).
- [ ] تصميم جدول `suspicious_packages` (package_name, reason, severity, updated_at).
- [ ] كتابة Migrations لكل الجداول أعلاه.

## Endpoints
- [ ] `POST /scan-summary` — استقبال ملخص فحص من التطبيق (بيانات مجمّعة فقط) وحفظه.
- [ ] `GET /threat-intel/hashes` — إرجاع قائمة الـhashes المحدّثة (مع دعم pagination/آخر تحديث).
- [ ] `GET /threat-intel/packages` — إرجاع قائمة الحزم المشبوهة المحدّثة.
- [ ] `POST /threat-intel/report` (اختياري) — السماح بالإبلاغ عن تطبيق مشبوه من المستخدمين.
- [ ] حماية كل الـEndpoints بمصادقة JWT عبر Supabase Auth.
- [ ] التحقق من صحة المدخلات (DTO validation) في كل Endpoint.

## الاتصال مع Flutter
- [ ] إضافة عميل HTTP في Flutter (Dio أو http) مهيّأ بعنوان الـBackend.
- [ ] تفعيل Certificate Pinning للاتصال بين التطبيق والـBackend.
- [ ] بناء آلية مزامنة دورية لتحديث `malware_hashes`/`suspicious_packages` محليًا من الـBackend.
- [ ] إرسال ملخص الفحص إلى الـBackend فقط بموافقة صريحة من المستخدم (Toggle في الإعدادات).

## الاختبار والنشر
- [ ] كتابة اختبارات أساسية (e2e) للـEndpoints الرئيسية.
- [ ] إعداد بيئة Staging منفصلة عن Production.
- [ ] توثيق الـAPI (Swagger/OpenAPI عبر NestJS).

## معيار إنهاء المرحلة
- [ ] تطبيق Flutter حقيقي يرسل ملخص فحص وتستقبل قائمة Threat Intelligence محدّثة من Backend يعمل فعليًا.
