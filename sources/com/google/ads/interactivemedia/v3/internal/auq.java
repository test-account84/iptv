package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class auq extends awy implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator a;

    public auq(Comparator comparator) {
        atp.k(comparator);
        this.a = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.a.compare(obj, obj2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof auq) {
            return this.a.equals(((auq) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }
}
