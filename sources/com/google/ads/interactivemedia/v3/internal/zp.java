package com.google.ads.interactivemedia.v3.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zp {
    private static final Pattern c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int a = -1;
    public int b = -1;

    private final boolean c(String str) {
        Matcher matcher = c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i = cq.a;
            int parseInt = Integer.parseInt(group, 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.a = parseInt;
            this.b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean a() {
        return (this.a == -1 || this.b == -1) ? false : true;
    }

    public final void b(ao aoVar) {
        for (int i = 0; i < aoVar.a(); i++) {
            an b = aoVar.b(i);
            if (b instanceof aau) {
                aau aauVar = (aau) b;
                if ("iTunSMPB".equals(aauVar.b) && c(aauVar.c)) {
                    return;
                }
            } else if (b instanceof abb) {
                abb abbVar = (abb) b;
                if ("com.apple.iTunes".equals(abbVar.a) && "iTunSMPB".equals(abbVar.b) && c(abbVar.c)) {
                    return;
                }
            } else {
                continue;
            }
        }
    }
}
