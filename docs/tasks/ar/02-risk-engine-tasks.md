# مهام المرحلة 2 — Risk Engine

## هيكلة الإعدادات (Config)
- [ ] تصميم ملف JSON/YAML خارجي لأوزان الـscoring (غير Hardcoded).
- [ ] تعريف الحقول: `signal`, `points`, `description`.
- [ ] كتابة دالة لتحميل الإعدادات وقراءتها في وقت التشغيل.
- [ ] وضع القيم الافتراضية المتفق عليها (Unknown source +20، Accessibility +25... إلخ).

## RiskEngine — البنية
- [ ] تعريف `data class RiskReason(signal, points, explanation)`.
- [ ] تعريف `data class RiskScore(total, level, reasons: List<RiskReason>)`.
- [ ] كتابة دالة `calculateScore(rawResult: ScanRawResult): RiskScore`.
- [ ] تطبيق منطق تجميع النقاط من كل الإشارات (unknown source, accessibility, overlay, SMS, device admin, camera/mic background...).
- [ ] كتابة دالة تصنيف المستوى: SAFE/LOW/MEDIUM/HIGH/CRITICAL بناءً على المجموع.
- [ ] التأكد أن كل نقطة مضافة إلى المجموع تُرفق بسبب (`RiskReason`) واضح.

## IntegrityChecker (Root)
- [ ] فحص وجود ملف `su` في المسارات الشائعة (`/system/bin/su`, `/system/xbin/su`...).
- [ ] فحص وجود تطبيقات إدارة Root معروفة (Magisk Manager وغيرها) عبر PackageManager.
- [ ] فحص خصائص النظام المشبوهة (`ro.debuggable`, `ro.secure`).
- [ ] تجميع النتائج في `data class IntegritySignal(indicator, detected)`.
- [ ] إرسال النتائج كإشارة إضافية إلى RiskEngine (وليس كحكم نهائي "الجهاز مخترق").

## BootloaderChecker
- [ ] قراءة حالة Bootloader عبر الخصائص المتاحة (`ro.boot.verifiedbootstate` أو ما يعادلها).
- [ ] تصنيف الحالة: LOCKED / UNLOCKED / UNKNOWN.
- [ ] التعامل مع الحالات التي لا يمكن فيها قراءة الحالة (صلاحيات النظام).

## الاختبار
- [ ] إنشاء بيانات Mock تمثل: جهاز نظيف، جهاز به تطبيق مشبوه، جهاز Root.
- [ ] التحقق من أن كل سيناريو يُصنَّف في المستوى الصحيح (SAFE/LOW/MEDIUM/HIGH/CRITICAL).
- [ ] التحقق من أن كل نتيجة تحتوي على تفسير (Explainability) واضح وغير مكرر.
- [ ] اختبار حساسية الأوزان (تعديل config وإعادة الاختبار للتأكد أن التغيير ينعكس فعليًا).

## معيار إنهاء المرحلة
- [ ] دمج RiskEngine مع نتائج المرحلة 1 وإنتاج تقرير JSON كامل (raw + score + reasons) صحيح ومُختبر يدويًا.
