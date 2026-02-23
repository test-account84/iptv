package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class me {
    private final mb a;
    public final s b;
    public final avo c;
    public final long d;
    public final List e;

    public /* synthetic */ me(s sVar, List list, mk mkVar, List list2) {
        af.u(!list.isEmpty());
        this.b = sVar;
        this.c = avo.m(list);
        this.e = Collections.unmodifiableList(list2);
        this.a = mkVar.i(this);
        this.d = cq.w(mkVar.j, 1000000L, mkVar.i);
    }

    public abstract li k();

    public abstract mb l();

    public abstract void m();

    public final mb n() {
        return this.a;
    }
}
