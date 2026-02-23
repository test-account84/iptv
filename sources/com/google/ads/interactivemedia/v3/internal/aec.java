package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aec implements adr {
    private aae b;
    private boolean c;
    private int e;
    private int f;
    private final cj a = new cj(10);
    private long d = -9223372036854775807L;

    public final void a(cj cjVar) {
        af.t(this.b);
        if (this.c) {
            int a = cjVar.a();
            int i = this.f;
            if (i < 10) {
                int min = Math.min(a, 10 - i);
                System.arraycopy(cjVar.H(), cjVar.c(), this.a.H(), this.f, min);
                if (this.f + min == 10) {
                    this.a.F(0);
                    if (this.a.i() != 73 || this.a.i() != 68 || this.a.i() != 51) {
                        cd.e("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.a.G(3);
                        this.e = this.a.h() + 10;
                    }
                }
            }
            int min2 = Math.min(a, this.e - this.f);
            this.b.e(cjVar, min2);
            this.f += min2;
        }
    }

    public final void b(zk zkVar, aet aetVar) {
        aetVar.c();
        aae i = zkVar.i(aetVar.a(), 5);
        this.b = i;
        r rVar = new r();
        rVar.S(aetVar.b());
        rVar.ae("application/id3");
        i.b(rVar.v());
    }

    public final void c() {
        int i;
        af.t(this.b);
        if (this.c && (i = this.e) != 0 && this.f == i) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                this.b.f(j, 1, i, 0, null);
            }
            this.c = false;
        }
    }

    public final void d(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.d = j;
        }
        this.e = 0;
        this.f = 0;
    }

    public final void e() {
        this.c = false;
        this.d = -9223372036854775807L;
    }
}
