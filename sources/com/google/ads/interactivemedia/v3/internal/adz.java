package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class adz implements adr {
    private final boolean a;
    private final boolean b;
    private long f;
    private String h;
    private aae i;
    private ady j;
    private boolean k;
    private boolean m;
    private final bdy o;
    private final boolean[] g = new boolean[3];
    private final aef c = new aef(7);
    private final aef d = new aef(8);
    private final aef e = new aef(6);
    private long l = -9223372036854775807L;
    private final cj n = new cj();

    public adz(bdy bdyVar, boolean z, boolean z2, byte[] bArr, byte[] bArr2) {
        this.o = bdyVar;
        this.a = z;
        this.b = z2;
    }

    private final void f(byte[] bArr, int i, int i2) {
        if (!this.k || this.j.g()) {
            this.c.a(bArr, i, i2);
            this.d.a(bArr, i, i2);
        }
        this.e.a(bArr, i, i2);
        this.j.a(bArr, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.google.ads.interactivemedia.v3.internal.cj r21) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.adz.a(com.google.ads.interactivemedia.v3.internal.cj):void");
    }

    public final void b(zk zkVar, aet aetVar) {
        aetVar.c();
        this.h = aetVar.b();
        aae i = zkVar.i(aetVar.a(), 2);
        this.i = i;
        this.j = new ady(i, this.a, this.b);
        this.o.l(zkVar, aetVar);
    }

    public final void c() {
    }

    public final void d(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
        this.m |= (i & 2) != 0;
    }

    public final void e() {
        this.f = 0L;
        this.m = false;
        this.l = -9223372036854775807L;
        zw.d(this.g);
        this.c.b();
        this.d.b();
        this.e.b();
        ady adyVar = this.j;
        if (adyVar != null) {
            adyVar.d();
        }
    }
}
