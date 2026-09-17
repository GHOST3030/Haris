# مهام المرحلة 4 — بناء الـUI الكامل (Flutter)

## الهيكلة العامة (Feature-First)
- [ ] إنشاء مجلد `core/` بمكوناته: `constants`, `theme`, `routing`, `security`, `utils`.
- [ ] إنشاء مجلدات `features/`: `dashboard`, `device_scan`, `applications`, `permissions`, `network_security`, `scan_history`.
- [ ] إعداد نظام التوجيه (Routing) بين الشاشات (go_router أو ما يعادله).
- [ ] إعداد الـTheme الأساسي (ألوان، خطوط) بما يتماشى مع فكرة "أداة أمان جادة" وليس تخويف بصري.

## Dashboard
- [ ] بناء واجهة عرض الدرجة الكلية (مثلاً 82/100) كمؤشر دائري أو بطاقة.
- [ ] عرض حالة عامة نصية: SECURE / AT RISK بلون مناسب (ليس أحمر صارخ دائمًا).
- [ ] زر "Scan Device" يستدعي Quick Scan افتراضيًا.
- [ ] قائمة Checks سريعة (✓/⚠) لكل فئة رئيسية (Integrity, Applications, Permissions, Network, Accessibility).
- [ ] ربط الشاشة بـProvider Riverpod يقرأ آخر نتيجة فحص محفوظة.

## Scan Screen
- [ ] واجهة اختيار نوع الفحص: Quick / Deep / Privacy.
- [ ] شريط تقدّم أو رسوم متحركة بسيطة أثناء الفحص الفعلي (مرتبط بحالة حقيقية من المحرك، وليس Future.delayed وهمي).
- [ ] عرض عدد العناصر التي تم فحصها لحظيًا إن أمكن (Streaming عبر EventChannel اختياريًا).
- [ ] الانتقال التلقائي إلى شاشة Security Report عند انتهاء الفحص.

## Applications Screen
- [ ] قائمة (ListView) بكل التطبيقات المثبتة مع أيقونة، اسم، ودرجة خطورة مختصرة.
- [ ] شاشة تفاصيل لكل تطبيق: Source, Permissions, Accessibility, Overlay, Device Admin.
- [ ] فلترة/ترتيب حسب مستوى الخطورة (الأعلى خطورة أولًا).
- [ ] بحث بالاسم داخل القائمة.

## Security Report Screen
- [ ] عرض المشاكل المكتشفة كقائمة (Card لكل مشكلة).
- [ ] لكل مشكلة: العنوان + شرح "لماذا" (Explanation) + مستوى الخطورة.
- [ ] صياغة كل النصوص بلغة محايدة (Security Risk Detected) بدون "الجهاز مخترق".
- [ ] زر أو رابط لكل مشكلة يفتح شاشة التطبيق المعني إن وُجد.

## Scan History
- [ ] إعداد قاعدة بيانات محلية (SQLite عبر Drift).
- [ ] تصميم جدول لحفظ نتائج كل فحص (timestamp, score, level, summary).
- [ ] شاشة عرض قائمة الفحوصات السابقة.
- [ ] رسم بياني بسيط لتطور الدرجة عبر الزمن (اختياري في هذه المرحلة).

## Localization
- [ ] إعداد نظام الترجمة (intl / easy_localization).
- [ ] استخراج كل النصوص الثابتة إلى ملفات ترجمة (ar.json, en.json).
- [ ] إضافة مبدّل لغة في الإعدادات (إن وُجدت شاشة إعدادات).

## معيار إنهاء المرحلة
- [ ] تجربة كاملة من فتح التطبيق → Scan → Report → History تعمل بسلاسة بدون بيانات وهمية.
