package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class blw implements bkm {
    private final /* synthetic */ int a;

    public blw(int i) {
        this.a = i;
    }

    public final bkl a(bjt bjtVar, bof bofVar) {
        int i = this.a;
        if (i == 0) {
            if (bofVar.c() == Date.class) {
                return new blx();
            }
            return null;
        }
        if (i != 1) {
            Class c = bofVar.c();
            if (!Enum.class.isAssignableFrom(c) || c == Enum.class) {
                return null;
            }
            if (!c.isEnum()) {
                c = c.getSuperclass();
            }
            return new bnv(c);
        }
        Class d = bofVar.d();
        boolean z = d instanceof GenericArrayType;
        if (!z && (!(d instanceof Class) || !d.isArray())) {
            return null;
        }
        Type genericComponentType = z ? ((GenericArrayType) d).getGenericComponentType() : d.getComponentType();
        return new blu(bjtVar, bjtVar.a(bof.b(genericComponentType)), bks.a(genericComponentType));
    }
}
