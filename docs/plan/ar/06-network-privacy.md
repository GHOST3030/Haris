# المرحلة 6 — Network Security + Privacy Center

**الهدف:** توسيع الفحص إلى الشبكة وخصوصية المستخدم.

## Network Security Module
- حالة Wi-Fi
- VPN
- Private DNS
- Proxy
- Network Security Config
- Cleartext traffic
- دون ادعاء كشف كل هجمات MITM.

## Privacy Center
- عرض التطبيقات التي تملك صلاحية:
  - Camera
  - Microphone
  - Location
  - Contacts
  - SMS
  - Accessibility
  - Notifications
- تمييز "استخدام حديث" إن أمكن عبر `AppOpsManager`.

## مبدأ حاكم
لا يُرسل شيء إلى الخارج إلا الضروري
(مثال: `{device_integrity, risk_level, scanner_version}` فقط،
وليس محتوى جهات الاتصال أو الرسائل).
