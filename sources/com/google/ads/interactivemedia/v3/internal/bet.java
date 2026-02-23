package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bet {
    private final Class a;
    private final bjj b;

    public /* synthetic */ bet(Class cls, bjj bjjVar) {
        this.a = cls;
        this.b = bjjVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bet)) {
            return false;
        }
        bet betVar = (bet) obj;
        return betVar.a.equals(this.a) && betVar.b.equals(this.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        return this.a.getSimpleName() + ", object identifier: " + String.valueOf(this.b);
    }
}
