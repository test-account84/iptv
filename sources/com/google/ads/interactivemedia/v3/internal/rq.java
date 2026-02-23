package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class rq {
    public final String a;
    public final boolean b;
    public final boolean c;

    public rq(String str, boolean z, boolean z2) {
        this.a = str;
        this.b = z;
        this.c = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == rq.class) {
            rq rqVar = (rq) obj;
            if (TextUtils.equals(this.a, rqVar.a) && this.b == rqVar.b && this.c == rqVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() + 31) * 31) + (true != this.b ? 1237 : 1231)) * 31) + (true != this.c ? 1237 : 1231);
    }
}
