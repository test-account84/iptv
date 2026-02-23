package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bkr implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type a;
    private final Type b;

    public bkr(Type[] typeArr, Type[] typeArr2) {
        int length = typeArr2.length;
        bjh.d(length <= 1);
        bjh.d(typeArr.length == 1);
        if (length != 1) {
            Type type = typeArr[0];
            type.getClass();
            bks.g(type);
            this.b = null;
            this.a = bks.d(typeArr[0]);
            return;
        }
        Type type2 = typeArr2[0];
        type2.getClass();
        bks.g(type2);
        bjh.d(typeArr[0] == Object.class);
        this.b = bks.d(typeArr2[0]);
        this.a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && bks.h(this, (WildcardType) obj);
    }

    public final Type[] getLowerBounds() {
        Type type = this.b;
        return type != null ? new Type[]{type} : bks.a;
    }

    public final Type[] getUpperBounds() {
        return new Type[]{this.a};
    }

    public final int hashCode() {
        Type type = this.b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.a.hashCode() + 31);
    }

    public final String toString() {
        String valueOf;
        String str;
        Type type = this.b;
        if (type != null) {
            valueOf = String.valueOf(bks.b(type));
            str = "? super ";
        } else {
            Type type2 = this.a;
            if (type2 == Object.class) {
                return "?";
            }
            valueOf = String.valueOf(bks.b(type2));
            str = "? extends ";
        }
        return str.concat(valueOf);
    }
}
