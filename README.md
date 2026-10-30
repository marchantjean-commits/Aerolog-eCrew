# AeroLog EASA

Aplicación de bitácora de vuelo con sincronización eCrew, importación automática de CSV, restauración JSON y exportación PDF.

## Desarrollo

```bash
npm install
npm run start
```

## Android

Requisitos: Android Studio, Android SDK y JDK 21.

```bash
npm install
npx cap sync android
npx cap open android
```

Para compilar:

```bash
cd android
./gradlew assembleDebug
```

El APK se genera en `android/app/build/outputs/apk/debug/`.

## iOS

Requiere macOS, Xcode y una cuenta Apple Developer:

```bash
npm install
npx cap sync ios
npx cap open ios
```

Después usar **Product → Archive** en Xcode para generar el `.ipa`.

## Seguridad

No guardar tokens, contraseñas, certificados ni archivos `local.properties` en GitHub. Las credenciales eCrew deben configurarse localmente.
