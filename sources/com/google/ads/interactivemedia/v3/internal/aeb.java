package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aeb implements adr {
    private String a;
    private aae b;
    private aea c;
    private boolean d;
    private long k;
    private final bdy n;
    private final boolean[] e = new boolean[3];
    private final aef f = new aef(32);
    private final aef g = new aef(33);
    private final aef h = new aef(34);
    private final aef i = new aef(39);
    private final aef j = new aef(40);
    private long l = -9223372036854775807L;
    private final cj m = new cj();

    public aeb(bdy bdyVar, byte[] bArr, byte[] bArr2) {
        this.n = bdyVar;
    }

    private final void f(byte[] bArr, int i, int i2) {
        this.c.b(bArr, i, i2);
        if (!this.d) {
            this.f.a(bArr, i, i2);
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
        }
        this.i.a(bArr, i, i2);
        this.j.a(bArr, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:189:0x0345  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.google.ads.interactivemedia.v3.internal.cj r38) {
        /*
            Method dump skipped, instructions count: 1008
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aeb.a(com.google.ads.interactivemedia.v3.internal.cj):void");
    }

    public final void b(zk zkVar, aet aetVar) {
        aetVar.c();
        this.a = aetVar.b();
        aae i = zkVar.i(aetVar.a(), 2);
        this.b = i;
        this.c = new aea(i);
        this.n.l(zkVar, aetVar);
    }

    public final void c() {
    }

    public final void d(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }

    public final void e() {
        this.k = 0L;
        this.l = -9223372036854775807L;
        zw.d(this.e);
        this.f.b();
        this.g.b();
        this.h.b();
        this.i.b();
        this.j.b();
        aea aeaVar = this.c;
        if (aeaVar != null) {
            aeaVar.c();
        }
    }
}
