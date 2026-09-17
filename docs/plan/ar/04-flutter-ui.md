# المرحلة 4 — بناء الـUI الكامل (Flutter)

**الهدف:** تحويل البيانات الخام إلى تجربة مستخدم احترافية.

## المهام
- هيكلة Feature-First:
```
lib/
├── core/ (constants, theme, routing, security, utils)
└── features/
    ├── dashboard/
    ├── device_scan/
    ├── applications/
    ├── permissions/
    ├── network_security/
    └── scan_history/
```

- **Dashboard:** درجة الأمان الكلية (مثلاً 82/100)، حالة "SECURE/AT RISK"، زر Scan، قائمة Checks (✓/⚠).
- **Scan Screen:** تفرقة واضحة بين:
  - Quick Scan (~10-30 ثانية)
  - Deep Scan
  - Privacy Scan
- **Applications Screen:** قائمة التطبيقات المثبتة مع درجة خطورة كل تطبيق وتفاصيله
  (Source, Permissions, Accessibility, Overlay...).
- **Security Report Screen:** شرح "لماذا" لكل مشكلة مكتشفة
  (مثال: "Unknown application installed", "Accessibility access enabled")،
  بدون لغة تخويف مثل "الجهاز مخترق".
- **Scan History:** حفظ نتائج الفحوصات محليًا (SQLite/Drift) لعرض التطور عبر الزمن.
- Localization (عربي/إنجليزي) من هذه المرحلة.
