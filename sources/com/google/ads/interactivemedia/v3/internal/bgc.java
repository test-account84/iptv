package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgc {
    private final bfx a;
    private final List b;
    private final Integer c;

    public /* synthetic */ bgc(bfx bfxVar, List list, Integer num) {
        this.a = bfxVar;
        this.b = list;
        this.c = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bgc)) {
            return false;
        }
        bgc bgcVar = (bgc) obj;
        if (this.a.equals(bgcVar.a) && this.b.equals(bgcVar.b)) {
            Integer num = this.c;
            Integer num2 = bgcVar.c;
            if (num == num2) {
                return true;
            }
            if (num != null && num.equals(num2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.a, this.b, this.c});
    }
}
