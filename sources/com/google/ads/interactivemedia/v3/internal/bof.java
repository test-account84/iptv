package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bof {
    private final Class a;
    private final Type b;
    private final int c;

    public bof() {
        ParameterizedType genericSuperclass = bof.class.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = genericSuperclass;
            if (parameterizedType.getRawType() == bof.class) {
                this.b = bks.d(parameterizedType.getActualTypeArguments()[0]);
                throw null;
            }
        } else if (genericSuperclass == bof.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public static bof a(Class cls) {
        return new bof(cls);
    }

    public static bof b(Type type) {
        return new bof(type);
    }

    public final Class c() {
        return this.a;
    }

    public final Type d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof bof) && bks.h(this.b, ((bof) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return bks.b(this.b);
    }

    private bof(Type type) {
        type.getClass();
        Type d = bks.d(type);
        this.b = d;
        this.a = bks.a(d);
        this.c = d.hashCode();
    }
}
