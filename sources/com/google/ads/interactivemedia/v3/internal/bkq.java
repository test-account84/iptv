package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bkq implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type a;
    private final Type b;
    private final Type[] c;

    public bkq(Type type, Type type2, Type... typeArr) {
        type2.getClass();
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z = true;
            boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
            if (type == null && !z2) {
                z = false;
            }
            bjh.d(z);
        }
        this.a = type == null ? null : bks.d(type);
        this.b = bks.d(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.c = typeArr2;
        int length = typeArr2.length;
        for (int i = 0; i < length; i++) {
            Type type3 = this.c[i];
            type3.getClass();
            bks.g(type3);
            Type[] typeArr3 = this.c;
            typeArr3[i] = bks.d(typeArr3[i]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && bks.h(this, (ParameterizedType) obj);
    }

    public final Type[] getActualTypeArguments() {
        return (Type[]) this.c.clone();
    }

    public final Type getOwnerType() {
        return this.a;
    }

    public final Type getRawType() {
        return this.b;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.c) ^ this.b.hashCode();
        Type type = this.a;
        return hashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        int length = this.c.length;
        if (length == 0) {
            return bks.b(this.b);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(bks.b(this.b));
        sb.append("<");
        sb.append(bks.b(this.c[0]));
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(bks.b(this.c[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
