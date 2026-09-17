# المرحلة 3 — الجسر (MethodChannel) + Flutter هيكلي

**الهدف:** ربط المحرك الجاهز بتطبيق Flutter بسيط جدًا (بدون تصميم نهائي).

## المهام
- إنشاء مشروع Flutter وربط module الـKotlin كـ Android plugin/native code.
- تعريف MethodChannel واحد (`com.haris/security_engine`) بدوال:
  - `quickScan()`
  - `deepScan()`
  - `privacyScan()`
- تمرير نتائج الفحص كـ JSON من Kotlin إلى Dart وparsing بسيط في Dart
  (models via `json_serializable` أو يدويًا).
- شاشة Flutter مؤقتة واحدة (Debug screen) تعرض الـJSON الخام كنص فقط،
  للتأكد من أن الجسر يعمل بشكل صحيح end-to-end.
- إعداد Riverpod كـstate management من هذه النقطة فصاعدًا.

## معيار الانتقال للمرحلة 4
الضغط على زر "Scan" في تطبيق Flutter حقيقي يُرجع نتيجة صحيحة من المحرك الأصلي.
