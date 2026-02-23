package org.simpleframework.xml.transform;

import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class StringArrayTransform implements Transform {
    private final Pattern pattern;
    private final String token;

    public StringArrayTransform() {
        this(",");
    }

    public StringArrayTransform(String str) {
        this.pattern = Pattern.compile(str);
        this.token = str;
    }

    public String[] read(String str) {
        return read(str, this.token);
    }

    public String write(String[] strArr) {
        return write(strArr, this.token);
    }

    private String[] read(String str, String str2) {
        String[] split = this.pattern.split(str);
        for (int i = 0; i < split.length; i++) {
            String str3 = split[i];
            if (str3 != null) {
                split[i] = str3.trim();
            }
        }
        return split;
    }

    private String write(String[] strArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            if (str2 != null) {
                if (sb.length() > 0) {
                    sb.append(str);
                    sb.append(' ');
                }
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
