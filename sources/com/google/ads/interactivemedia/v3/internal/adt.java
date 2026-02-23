package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class adt implements adr {
    private static final double[] a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String b;
    private aae c;
    private final cj d;
    private final aef e;
    private final boolean[] f;
    private final ads g;
    private long h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;
    private final aeq q;

    public adt() {
        this(null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.google.ads.interactivemedia.v3.internal.cj r27) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.adt.a(com.google.ads.interactivemedia.v3.internal.cj):void");
    }

    public final void b(zk zkVar, aet aetVar) {
        aetVar.c();
        this.b = aetVar.b();
        this.c = zkVar.i(aetVar.a(), 2);
        aeq aeqVar = this.q;
        if (aeqVar != null) {
            aeqVar.b(zkVar, aetVar);
        }
    }

    public final void c() {
    }

    public final void d(long j, int i) {
        this.l = j;
    }

    public final void e() {
        zw.d(this.f);
        this.g.b();
        aef aefVar = this.e;
        if (aefVar != null) {
            aefVar.b();
        }
        this.h = 0L;
        this.i = false;
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }

    public adt(aeq aeqVar, byte[] bArr) {
        cj cjVar;
        this.q = aeqVar;
        this.f = new boolean[4];
        this.g = new ads();
        if (aeqVar != null) {
            this.e = new aef(178);
            cjVar = new cj();
        } else {
            cjVar = null;
            this.e = null;
        }
        this.d = cjVar;
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }
}
