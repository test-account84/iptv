package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class eq {
    public final String a;
    public final s b;
    public final s c;
    public final int d;
    public final int e;

    public eq(String str, s sVar, s sVar2, int i, int i2) {
        boolean z = true;
        if (i != 0) {
            if (i2 == 0) {
                i2 = 0;
            } else {
                z = false;
            }
        }
        af.u(z);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.a = str;
        af.s(sVar);
        this.b = sVar;
        af.s(sVar2);
        this.c = sVar2;
        this.d = i;
        this.e = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && eq.class == obj.getClass()) {
            eq eqVar = (eq) obj;
            if (this.d == eqVar.d && this.e == eqVar.e && this.a.equals(eqVar.a) && this.b.equals(eqVar.b) && this.c.equals(eqVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.d + 527) * 31) + this.e) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}
