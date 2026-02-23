package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apg extends apj {
    private final View h;

    public apg(anw anwVar, agl aglVar, int i, View view, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "JgNevmfyr8lZxnvZfq3r729JgtxbLk039SjEVr1jMI7eztR3nd0tOgO6sMz+FJz+", "ylslQbtrjnaBQeIQLiG5TQpHgACRff6HBxNL0ysPa0Q=", aglVar, i, 57, null, null, null);
        this.h = view;
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.h != null) {
            Boolean bool = (Boolean) aqo.z.f();
            Boolean bool2 = (Boolean) aqo.B.f();
            aob aobVar = new aob((String) this.d.invoke((Object) null, new Object[]{this.h, this.a.b().getResources().getDisplayMetrics(), bool, bool2}));
            agl g = agb.g();
            g.l(aobVar.a.longValue());
            g.n(aobVar.b.longValue());
            g.o(aobVar.c.longValue());
            if (bool2.booleanValue()) {
                g.m(aobVar.e.longValue());
            }
            if (bool.booleanValue()) {
                g.k(aobVar.d.longValue());
            }
            this.g.aI((agb) g.aY());
        }
    }
}
