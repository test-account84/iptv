package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class beu {
    private final Class a;
    private final Class b;

    public /* synthetic */ beu(Class cls, Class cls2) {
        this.a = cls;
        this.b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof beu)) {
            return false;
        }
        beu beuVar = (beu) obj;
        return beuVar.a.equals(this.a) && beuVar.b.equals(this.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        return this.a.getSimpleName() + " with serialization type: " + this.b.getSimpleName();
    }
}
