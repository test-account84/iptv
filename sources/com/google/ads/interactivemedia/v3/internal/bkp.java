package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bkp implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type a;

    public bkp(Type type) {
        type.getClass();
        this.a = bks.d(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && bks.h(this, (GenericArrayType) obj);
    }

    public final Type getGenericComponentType() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return String.valueOf(bks.b(this.a)).concat("[]");
    }
}
