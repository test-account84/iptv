package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class lt {
    public final String a;
    public final String b;
    public final int c;
    public final int d;

    public lt(String str, String str2, int i, int i2) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lt)) {
            return false;
        }
        lt ltVar = (lt) obj;
        return this.c == ltVar.c && this.d == ltVar.d && com.google.ads.interactivemedia.v3.impl.data.k.c(this.a, ltVar.a) && com.google.ads.interactivemedia.v3.impl.data.k.c(this.b, ltVar.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }
}
