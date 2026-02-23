package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bma implements bkm {
    private final bkw a;
    private final /* synthetic */ int b;

    public bma(bkw bkwVar, int i) {
        this.b = i;
        this.a = bkwVar;
    }

    public static final bkl b(bkw bkwVar, bjt bjtVar, bof bofVar, bkn bknVar) {
        bke bkeVar;
        bkl bmoVar;
        Object a = bkwVar.a(bof.a(bknVar.a())).a();
        boolean b = bknVar.b();
        if (a instanceof bkl) {
            bmoVar = (bkl) a;
        } else if (a instanceof bkm) {
            bmoVar = ((bkm) a).a(bjtVar, bofVar);
        } else {
            if (a instanceof bke) {
                bkeVar = (bke) a;
            } else {
                if (!(a instanceof bjx)) {
                    throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a.getClass().getName() + " as a @JsonAdapter for " + bofVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                }
                bkeVar = null;
            }
            bmoVar = new bmo(bkeVar, a instanceof bjx ? (bjx) a : null, bjtVar, bofVar, null, b);
            b = false;
        }
        return (bmoVar == null || !b) ? bmoVar : bmoVar.nullSafe();
    }

    public final bkl a(bjt bjtVar, bof bofVar) {
        int i = this.b;
        if (i == 0) {
            bkn bknVar = (bkn) bofVar.c().getAnnotation(bkn.class);
            if (bknVar == null) {
                return null;
            }
            return b(this.a, bjtVar, bofVar, bknVar);
        }
        if (i == 1) {
            Type d = bofVar.d();
            Class c = bofVar.c();
            if (!Collection.class.isAssignableFrom(c)) {
                return null;
            }
            Type e = bks.e(d, c);
            return new blv(bjtVar, e, bjtVar.a(bof.b(e)), this.a.a(bofVar));
        }
        Type d2 = bofVar.d();
        Class c2 = bofVar.c();
        if (!Map.class.isAssignableFrom(c2)) {
            return null;
        }
        Type[] i2 = bks.i(d2, c2);
        Type type = i2[0];
        return new bmf(bjtVar, i2[0], (type == Boolean.TYPE || type == Boolean.class) ? bnw.f : bjtVar.a(bof.b(type)), i2[1], bjtVar.a(bof.b(i2[1])), this.a.a(bofVar));
    }
}
