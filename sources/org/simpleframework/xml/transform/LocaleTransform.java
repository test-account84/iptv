package org.simpleframework.xml.transform;

import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class LocaleTransform implements Transform {
    private final Pattern pattern = Pattern.compile("_");

    public Locale read(String str) throws Exception {
        String[] split = this.pattern.split(str);
        if (split.length >= 1) {
            return read(split);
        }
        throw new InvalidFormatException("Invalid locale %s", str);
    }

    public String write(Locale locale) {
        return locale.toString();
    }

    private Locale read(String[] strArr) throws Exception {
        String[] strArr2 = new String[3];
        strArr2[0] = "";
        strArr2[1] = "";
        strArr2[2] = "";
        for (int i = 0; i < 3; i++) {
            if (i < strArr.length) {
                strArr2[i] = strArr[i];
            }
        }
        return new Locale(strArr2[0], strArr2[1], strArr2[2]);
    }
}
