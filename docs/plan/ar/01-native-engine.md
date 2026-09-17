# المرحلة 1 — إعداد المحرك الأساسي (Kotlin فقط، بدون Flutter)

**الهدف:** بيئة Kotlin مستقلة (مشروع Android عادي أو module) لبناء واختبار الفحوصات دون أي واجهة.

## المهام
- إنشاء مشروع Android (أو Gradle module منفصل) قابل لإعادة استخدامه لاحقًا كـ plugin.
- بناء `AppScanner`: قراءة قائمة التطبيقات عبر `PackageManager`
  (packageName, versionName, installerPackage, targetSdk, minSdk, debuggable flag, isSystemApp).
- بناء `PermissionAnalyzer`: استخراج الصلاحيات المطلوبة لكل تطبيق وتصنيفها (dangerous / normal / signature).
- بناء `AccessibilityMonitor`: قراءة الخدمات المفعّلة عبر `AccessibilityManager`.
- بناء `OverlayDetector`: فحص التطبيقات التي تملك `SYSTEM_ALERT_WINDOW`.
- بناء `DeviceAdminChecker`: قراءة قائمة Device Administrators عبر `DevicePolicyManager`.
- اختبار كل Module عبر Logcat أو Unit Tests بسيطة على جهاز/محاكي حقيقي.

## هيكلة الكود
```
android/app/src/main/kotlin/security/
├── scanner/
├── apps/
├── permissions/
├── integrity/
├── network/
└── risk/
```

## مخرجات المرحلة
كل module يرجع `data class` منظم (JSON-serializable) يمثل نتيجة الفحص الخام، دون أي تقييم خطورة بعد.

## معيار الانتقال
كل module يعمل بشكل مستقل ويُنتج بيانات خام صحيحة، مُختبرة على جهاز حقيقي.
