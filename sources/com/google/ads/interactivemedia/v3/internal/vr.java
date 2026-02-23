package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class vr extends wb implements Comparable {
    private final int e;
    private final boolean f;
    private final String g;
    private final vu h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private final boolean m;
    private final int n;
    private final int o;
    private final boolean p;
    private final int q;
    private final int r;
    private final int s;
    private final int t;
    private final boolean u;
    private final boolean v;

    /* JADX WARN: Removed duplicated region for block: B:58:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public vr(int r6, com.google.ads.interactivemedia.v3.internal.bf r7, int r8, com.google.ads.interactivemedia.v3.internal.vu r9, int r10, boolean r11, com.google.ads.interactivemedia.v3.internal.atm r12) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.vr.<init>(int, com.google.ads.interactivemedia.v3.internal.bf, int, com.google.ads.interactivemedia.v3.internal.vu, int, boolean, com.google.ads.interactivemedia.v3.internal.atm):void");
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(vr vrVar) {
        awy c = (this.f && this.i) ? wd.c() : wd.c().a();
        aut c2 = aut.j().d(this.i, vrVar.i).c(Integer.valueOf(this.k), Integer.valueOf(vrVar.k), awy.c().a()).b(this.j, vrVar.j).b(this.l, vrVar.l).d(this.p, vrVar.p).d(this.m, vrVar.m).c(Integer.valueOf(this.n), Integer.valueOf(vrVar.n), awy.c().a()).b(this.o, vrVar.o).d(this.f, vrVar.f).c(Integer.valueOf(this.t), Integer.valueOf(vrVar.t), awy.c().a());
        Integer valueOf = Integer.valueOf(this.s);
        Integer valueOf2 = Integer.valueOf(vrVar.s);
        boolean z = this.h.x;
        aut c3 = c2.c(valueOf, valueOf2, wd.d()).d(this.u, vrVar.u).d(this.v, vrVar.v).c(Integer.valueOf(this.q), Integer.valueOf(vrVar.q), c).c(Integer.valueOf(this.r), Integer.valueOf(vrVar.r), c);
        Integer valueOf3 = Integer.valueOf(this.s);
        Integer valueOf4 = Integer.valueOf(vrVar.s);
        if (!cq.V(this.g, vrVar.g)) {
            c = wd.d();
        }
        return c3.c(valueOf3, valueOf4, c).a();
    }

    public final int b() {
        return this.e;
    }

    public final /* bridge */ /* synthetic */ boolean c(wb wbVar) {
        String str;
        vr vrVar = (vr) wbVar;
        boolean z = this.h.J;
        s sVar = this.d;
        int i = sVar.y;
        if (i == -1) {
            return false;
        }
        s sVar2 = vrVar.d;
        if (i != sVar2.y || (str = sVar.l) == null || !TextUtils.equals(str, sVar2.l)) {
            return false;
        }
        boolean z2 = this.h.I;
        int i2 = this.d.z;
        return i2 != -1 && i2 == vrVar.d.z && this.u == vrVar.u && this.v == vrVar.v;
    }
}
