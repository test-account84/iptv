package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class adn implements adr {
    private static final byte[] a = {73, 68, 51};
    private final boolean b;
    private final ci c = new ci(new byte[7]);
    private final cj d = new cj(Arrays.copyOf(a, 10));
    private final String e;
    private String f;
    private aae g;
    private aae h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private long r;
    private int s;
    private long t;
    private aae u;
    private long v;

    public adn(boolean z, String str) {
        h();
        this.n = -1;
        this.o = -1;
        this.r = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.b = z;
        this.e = str;
    }

    public static boolean f(int i) {
        return (i & 65526) == 65520;
    }

    private final void g() {
        this.m = false;
        h();
    }

    private final void h() {
        this.i = 0;
        this.j = 0;
        this.k = 256;
    }

    private final void i() {
        this.i = 3;
        this.j = 0;
    }

    private final void j(aae aaeVar, long j, int i, int i2) {
        this.i = 4;
        this.j = i;
        this.u = aaeVar;
        this.v = j;
        this.s = i2;
    }

    private final boolean k(cj cjVar, byte[] bArr, int i) {
        int min = Math.min(cjVar.a(), i - this.j);
        cjVar.A(bArr, this.j, min);
        int i2 = this.j + min;
        this.j = i2;
        return i2 == i;
    }

    private static final boolean l(byte b) {
        return f((b & 255) | 65280);
    }

    private static final boolean m(cj cjVar, byte[] bArr, int i) {
        if (cjVar.a() < i) {
            return false;
        }
        cjVar.A(bArr, 0, i);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x024e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.google.ads.interactivemedia.v3.internal.cj r21) throws com.google.ads.interactivemedia.v3.internal.as {
        /*
            Method dump skipped, instructions count: 708
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.adn.a(com.google.ads.interactivemedia.v3.internal.cj):void");
    }

    public final void b(zk zkVar, aet aetVar) {
        aetVar.c();
        this.f = aetVar.b();
        aae i = zkVar.i(aetVar.a(), 1);
        this.g = i;
        this.u = i;
        if (!this.b) {
            this.h = new zg();
            return;
        }
        aetVar.c();
        aae i2 = zkVar.i(aetVar.a(), 5);
        this.h = i2;
        r rVar = new r();
        rVar.S(aetVar.b());
        rVar.ae("application/id3");
        i2.b(rVar.v());
    }

    public final void c() {
    }

    public final void d(long j, int i) {
        if (j != -9223372036854775807L) {
            this.t = j;
        }
    }

    public final void e() {
        this.t = -9223372036854775807L;
        g();
    }
}
