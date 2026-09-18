# مهام المرحلة 1 — إعداد المحرك الأساسي (Kotlin)

## إعداد المشروع
- [x] إنشاء مشروع Android جديد (أو Gradle module منفصل باسم `security-engine`).
- [ ] إعداد بنية الحزم: `security.scanner`, `security.apps`, `security.permissions`, `security.integrity`, `security.network`, `security.risk`.
- [ ] إضافة إعدادات Gradle الأساسية (minSdk 29، Kotlin version، dependencies).
- [ ] إعداد Git repo/branching للمحرك (إن كان منفصلًا) أو مجلد `android/` داخل المستودع الحالي.

## AppScanner
- [ ] كتابة دالة لجلب قائمة كل التطبيقات المثبتة عبر `PackageManager.getInstalledPackages()`.
- [ ] استخراج `packageName`, `versionName`, `versionCode`.
- [ ] استخراج `installerPackageName` (مصدر التثبيت).
- [ ] استخراج `targetSdkVersion` و `minSdkVersion`.
- [ ] استخراج `applicationInfo.flags` لمعرفة `debuggable` و `isSystemApp`.
- [ ] تجميع كل هذا في `data class AppInfo`.
- [ ] كتابة دالة تُرجع `List<AppInfo>` كاملة.
- [ ] اختبار الدالة على جهاز حقيقي وطباعة النتائج في Logcat.

## PermissionAnalyzer
- [ ] كتابة دالة لجلب صلاحيات تطبيق معيّن عبر `PackageManager.getPackageInfo(pkg, GET_PERMISSIONS)`.
- [ ] بناء قائمة مرجعية بالصلاحيات "الخطيرة" (dangerous) المعروفة في Android.
- [ ] تصنيف كل صلاحية: dangerous / normal / signature.
- [ ] بناء `data class PermissionInfo(name, protectionLevel, isGranted)`.
- [ ] ربط النتيجة بكل `AppInfo` (قائمة صلاحيات لكل تطبيق).
- [ ] اختبار الدالة على تطبيقات معروفة (مثال: WhatsApp) والتحقق من صحة النتائج.

## AccessibilityMonitor
- [ ] الحصول على `AccessibilityManager` عبر `Context.getSystemService`.
- [ ] جلب `getEnabledAccessibilityServiceList()`.
- [ ] استخراج اسم الحزمة والخدمة لكل accessibility service مفعّلة.
- [ ] بناء `data class AccessibilityServiceInfo(packageName, serviceName)`.
- [ ] اختبار الدالة بتفعيل/تعطيل خدمة Accessibility يدويًا والتحقق من النتيجة.

## OverlayDetector
- [ ] كتابة دالة تفحص التطبيقات المالكة لصلاحية `SYSTEM_ALERT_WINDOW`.
- [ ] التحقق من حالة الصلاحية الفعلية (granted) وليس فقط requested.
- [ ] بناء `data class OverlayInfo(packageName, isGranted)`.
- [ ] اختبار الدالة على تطبيق يستخدم overlay فعليًا (مثال: تطبيق فقاعات دردشة).

## DeviceAdminChecker
- [ ] الحصول على `DevicePolicyManager` عبر `Context.getSystemService`.
- [ ] جلب `getActiveAdmins()`.
- [ ] استخراج اسم الحزمة لكل Device Admin نشط.
- [ ] بناء `data class DeviceAdminInfo(packageName, componentName)`.
- [ ] اختبار الدالة بعد تفعيل Device Admin تجريبي (مثال: Find My Device).

## التكامل والاختبار
- [ ] بناء `data class ScanRawResult` يجمع نتائج كل الـModules أعلاه.
- [ ] كتابة دالة orchestrator بسيطة تُشغّل كل الفحوصات وتُرجع `ScanRawResult` واحد.
- [ ] تحويل `ScanRawResult` إلى JSON (باستخدام Gson أو kotlinx.serialization) والتحقق من صحة الشكل.
- [ ] كتابة Unit Tests أساسية لكل Module (باستخدام بيانات وهمية حيث يلزم).
- [ ] توثيق كل Module بتعليقات KDoc قصيرة.

## معيار إنهاء المرحلة
- [ ] تشغيل الفحص الكامل على جهاز حقيقي وطباعة JSON صحيح في Logcat دون أخطاء.
