package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bky implements Cloneable, bkm {
    public static final bky a = new bky();
    private final double b = -1.0d;
    private final int c = 136;
    private final boolean d = true;
    private List e = Collections.emptyList();
    private final List f = Collections.emptyList();

    private final boolean f(Class cls) {
        return h(cls);
    }

    private final boolean g(Class cls, boolean z) {
        for (com.google.ads.interactivemedia.v3.impl.data.k kVar : z ? this.e : this.f) {
        }
        return false;
    }

    private final boolean h(Class cls) {
        if (Enum.class.isAssignableFrom(cls) || i(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    private static final boolean i(Class cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public final bkl a(bjt bjtVar, bof bofVar) {
        boolean z;
        boolean z2;
        Class c = bofVar.c();
        boolean f = f(c);
        if (f) {
            z = true;
        } else {
            g(c, true);
            z = false;
        }
        if (f) {
            z2 = true;
        } else {
            g(c, false);
            z2 = false;
        }
        if (z || z2) {
            return new bkx(this, z2, z, bjtVar, bofVar);
        }
        return null;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final bky clone() {
        try {
            return (bky) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean c(Class cls, boolean z) {
        if (f(cls)) {
            return true;
        }
        g(cls, z);
        return false;
    }

    public final boolean d(Field field, boolean z) {
        if ((field.getModifiers() & 136) != 0 || field.isSynthetic() || h(field.getType())) {
            return true;
        }
        List<com.google.ads.interactivemedia.v3.impl.data.k> list = z ? this.e : this.f;
        if (list.isEmpty()) {
            return false;
        }
        bjk bjkVar = new bjk(field);
        for (com.google.ads.interactivemedia.v3.impl.data.k kVar : list) {
            if (com.google.ads.interactivemedia.v3.impl.data.k.i(bjkVar)) {
                return true;
            }
        }
        return false;
    }

    public final bky e(com.google.ads.interactivemedia.v3.impl.data.k kVar) {
        bky clone = clone();
        ArrayList arrayList = new ArrayList(this.e);
        clone.e = arrayList;
        arrayList.add(kVar);
        return clone;
    }
}
