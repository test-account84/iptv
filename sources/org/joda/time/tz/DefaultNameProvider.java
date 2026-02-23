package org.joda.time.tz;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.joda.time.DateTimeUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DefaultNameProvider implements NameProvider {
    private HashMap iByLocaleCache = createCache();
    private HashMap iByLocaleCache2 = createCache();

    private HashMap createCache() {
        return new HashMap(7);
    }

    private synchronized String[] getNameSet(Locale locale, String str, String str2) {
        String[] strArr;
        String[] strArr2 = null;
        if (locale == null || str == null || str2 == null) {
            return null;
        }
        try {
            Map map = (Map) this.iByLocaleCache.get(locale);
            if (map == null) {
                HashMap hashMap = this.iByLocaleCache;
                Map createCache = createCache();
                hashMap.put(locale, createCache);
                map = createCache;
            }
            HashMap hashMap2 = (Map) map.get(str);
            if (hashMap2 == null) {
                hashMap2 = createCache();
                map.put(str, hashMap2);
                String[][] zoneStrings = DateTimeUtils.getDateFormatSymbols(Locale.ENGLISH).getZoneStrings();
                int length = zoneStrings.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        strArr = null;
                        break;
                    }
                    strArr = zoneStrings[i];
                    if (strArr != null && strArr.length == 5 && str.equals(strArr[0])) {
                        break;
                    }
                    i++;
                }
                String[][] zoneStrings2 = DateTimeUtils.getDateFormatSymbols(locale).getZoneStrings();
                int length2 = zoneStrings2.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length2) {
                        String[] strArr3 = zoneStrings2[i2];
                        if (strArr3 != null && strArr3.length == 5 && str.equals(strArr3[0])) {
                            strArr2 = strArr3;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                if (strArr != null && strArr2 != null) {
                    hashMap2.put(strArr[2], new String[]{strArr2[2], strArr2[1]});
                    if (strArr[2].equals(strArr[4])) {
                        hashMap2.put(strArr[4] + "-Summer", new String[]{strArr2[4], strArr2[3]});
                    } else {
                        hashMap2.put(strArr[4], new String[]{strArr2[4], strArr2[3]});
                    }
                }
            }
            return (String[]) hashMap2.get(str2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public String getName(Locale locale, String str, String str2) {
        String[] nameSet = getNameSet(locale, str, str2);
        if (nameSet == null) {
            return null;
        }
        return nameSet[1];
    }

    public String getShortName(Locale locale, String str, String str2) {
        String[] nameSet = getNameSet(locale, str, str2);
        if (nameSet == null) {
            return null;
        }
        return nameSet[0];
    }

    private synchronized String[] getNameSet(Locale locale, String str, String str2, boolean z) {
        String[] strArr;
        String[] strArr2 = null;
        if (locale == null || str == null || str2 == null) {
            return null;
        }
        try {
            Map map = (Map) this.iByLocaleCache2.get(locale);
            if (map == null) {
                HashMap hashMap = this.iByLocaleCache2;
                Map createCache = createCache();
                hashMap.put(locale, createCache);
                map = createCache;
            }
            HashMap hashMap2 = (Map) map.get(str);
            if (hashMap2 == null) {
                hashMap2 = createCache();
                map.put(str, hashMap2);
                String[][] zoneStrings = DateTimeUtils.getDateFormatSymbols(Locale.ENGLISH).getZoneStrings();
                int length = zoneStrings.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        strArr = null;
                        break;
                    }
                    strArr = zoneStrings[i];
                    if (strArr != null && strArr.length == 5 && str.equals(strArr[0])) {
                        break;
                    }
                    i++;
                }
                String[][] zoneStrings2 = DateTimeUtils.getDateFormatSymbols(locale).getZoneStrings();
                int length2 = zoneStrings2.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length2) {
                        String[] strArr3 = zoneStrings2[i2];
                        if (strArr3 != null && strArr3.length == 5 && str.equals(strArr3[0])) {
                            strArr2 = strArr3;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                if (strArr != null && strArr2 != null) {
                    hashMap2.put(Boolean.TRUE, new String[]{strArr2[2], strArr2[1]});
                    hashMap2.put(Boolean.FALSE, new String[]{strArr2[4], strArr2[3]});
                }
            }
            return (String[]) hashMap2.get(Boolean.valueOf(z));
        } catch (Throwable th) {
            throw th;
        }
    }

    public String getName(Locale locale, String str, String str2, boolean z) {
        String[] nameSet = getNameSet(locale, str, str2, z);
        if (nameSet == null) {
            return null;
        }
        return nameSet[1];
    }

    public String getShortName(Locale locale, String str, String str2, boolean z) {
        String[] nameSet = getNameSet(locale, str, str2, z);
        if (nameSet == null) {
            return null;
        }
        return nameSet[0];
    }
}
