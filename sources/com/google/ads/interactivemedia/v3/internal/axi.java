package com.google.ads.interactivemedia.v3.internal;

import j$.util.Objects;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class axi extends awy implements Serializable {
    private static final long serialVersionUID = 0;
    final awy a;

    public axi(awy awyVar) {
        this.a = awyVar;
    }

    public final awy a() {
        return this.a;
    }

    public final int compare(Object obj, Object obj2) {
        return this.a.compare(obj2, obj);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof axi) {
            return this.a.equals(((axi) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return -this.a.hashCode();
    }

    public final String toString() {
        awy awyVar = this.a;
        Objects.toString(awyVar);
        return String.valueOf(awyVar).concat(".reverse()");
    }
}
