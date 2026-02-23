package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class auo extends awy implements Serializable {
    private static final long serialVersionUID = 0;
    final ati a;
    final awy b;

    public auo(ati atiVar, awy awyVar) {
        atp.k(atiVar);
        this.a = atiVar;
        this.b = awyVar;
    }

    public final int compare(Object obj, Object obj2) {
        return this.b.compare(this.a.a(obj), this.a.a(obj2));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof auo) {
            auo auoVar = (auo) obj;
            if (this.a.equals(auoVar.a) && this.b.equals(auoVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        return this.b + ".onResultOf(" + this.a + ")";
    }
}
