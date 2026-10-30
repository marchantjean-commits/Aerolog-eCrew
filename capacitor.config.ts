import type { CapacitorConfig } from '@capacitor/cli';
const config: CapacitorConfig = {
  appId: 'com.aerolog.easa',
  appName: 'AeroLog EASA',
  webDir: 'dist',
  android: { allowMixedContent: false },
  ios: { backgroundColor: '#0f172a' }
};
export default config;
