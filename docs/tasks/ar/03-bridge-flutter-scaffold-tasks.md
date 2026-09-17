# مهام المرحلة 3 — الجسر (MethodChannel) + Flutter هيكلي

## إعداد مشروع Flutter
- [ ] إنشاء مشروع Flutter جديد داخل `flutter_app/`.
- [ ] تفعيل دعم Android فقط في هذه المرحلة (تجاهل iOS مؤقتًا).
- [ ] ربط module الـKotlin الموجود في `android/` مع مشروع Flutter (كـ source set أو plugin محلي).
- [ ] التأكد أن Gradle لمشروع Flutter يبني بنجاح مع الكود الأصلي المدمج.

## MethodChannel
- [ ] تعريف قناة باسم `com.vigentra/security_engine` في الطرف الأصلي (Kotlin) والطرف الآخر (Dart).
- [ ] تنفيذ `MethodCallHandler` في `MainActivity.kt` يستقبل الاستدعاءات.
- [ ] تنفيذ دالة `quickScan()` تُشغّل مجموعة فرعية من الفحوصات وتُرجع JSON.
- [ ] تنفيذ دالة `deepScan()` تُشغّل كل الفحوصات المتاحة في المرحلة 1-2.
- [ ] تنفيذ دالة `privacyScan()` (placeholder مبدئي، التفاصيل الكاملة في المرحلة 6).
- [ ] معالجة الأخطاء (Exceptions) وإرسالها كـ `PlatformException` واضحة إلى Dart.

## طرف Dart
- [ ] إنشاء كلاس `SecurityEngineBridge` يغلّف استدعاءات MethodChannel.
- [ ] كتابة دوال Dart async: `Future<Map> quickScan()`, `deepScan()`, `privacyScan()`.
- [ ] إنشاء Models في Dart (`ScanResult`, `RiskScore`, `RiskReason`) مطابقة لهيكل JSON القادم من Kotlin.
- [ ] كتابة parsing (يدويًا أو عبر `json_serializable`) وتحويل الـJSON إلى Models.
- [ ] معالجة حالات الخطأ في Dart (عرض رسالة واضحة عند فشل الاستدعاء).

## شاشة Debug مؤقتة
- [ ] بناء شاشة Flutter بسيطة بها زر "Run Scan".
- [ ] عرض الـJSON الخام (أو الـModel المُحوَّل) كنص على الشاشة بعد الضغط.
- [ ] إضافة مؤشر تحميل بسيط أثناء انتظار النتيجة.

## إعداد Riverpod
- [ ] إضافة حزمة Riverpod إلى المشروع.
- [ ] إنشاء أول Provider بسيط (`securityEngineProvider`) يغلّف `SecurityEngineBridge`.
- [ ] ربط شاشة Debug بالـProvider بدلًا من استدعاء الجسر مباشرة.

## معيار إنهاء المرحلة
- [ ] الضغط على زر "Scan" في تطبيق Flutter حقيقي (على جهاز/محاكي) يُرجع نتيجة صحيحة ومطابقة لما ينتجه المحرك الأصلي.
