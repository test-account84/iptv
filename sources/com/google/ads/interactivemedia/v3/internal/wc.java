package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class wc extends wb {
    private final boolean e;
    private final vu f;
    private final boolean g;
    private final boolean h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;
    private final int o;
    private final boolean p;
    private final boolean q;
    private final int r;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public wc(int r6, com.google.ads.interactivemedia.v3.internal.bf r7, int r8, com.google.ads.interactivemedia.v3.internal.vu r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.wc.<init>(int, com.google.ads.interactivemedia.v3.internal.bf, int, com.google.ads.interactivemedia.v3.internal.vu, int, boolean):void");
    }

    public static /* synthetic */ int a(wc wcVar, wc wcVar2) {
        awy c = (wcVar.e && wcVar.h) ? wd.c() : wd.c().a();
        aut j = aut.j();
        Integer valueOf = Integer.valueOf(wcVar.i);
        Integer valueOf2 = Integer.valueOf(wcVar2.i);
        boolean z = wcVar.f.x;
        return j.c(valueOf, valueOf2, wd.d()).c(Integer.valueOf(wcVar.j), Integer.valueOf(wcVar2.j), c).c(Integer.valueOf(wcVar.i), Integer.valueOf(wcVar2.i), c).a();
    }

    public static /* synthetic */ int d(wc wcVar, wc wcVar2) {
        aut c = aut.j().d(wcVar.h, wcVar2.h).b(wcVar.l, wcVar2.l).d(wcVar.m, wcVar2.m).d(wcVar.e, wcVar2.e).d(wcVar.g, wcVar2.g).c(Integer.valueOf(wcVar.k), Integer.valueOf(wcVar2.k), awy.c().a());
        boolean z = wcVar.p;
        aut d = c.d(z, wcVar2.p);
        boolean z2 = wcVar.q;
        aut d2 = d.d(z2, wcVar2.q);
        if (z && z2) {
            d2 = d2.b(wcVar.r, wcVar2.r);
        }
        return d2.a();
    }

    public final int b() {
        return this.o;
    }

    public final /* bridge */ /* synthetic */ boolean c(wb wbVar) {
        wc wcVar = (wc) wbVar;
        if (!cq.V(this.d.l, wcVar.d.l)) {
            return false;
        }
        boolean z = this.f.F;
        return this.p == wcVar.p && this.q == wcVar.q;
    }
}
