package d3;

import d3.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x {
    public final byte[] a = new byte[10];
    public boolean b;
    public int c;
    public long d;
    public int e;
    public int f;
    public int g;

    public void a(w wVar, w.a aVar) {
        if (this.c > 0) {
            wVar.f(this.d, this.e, this.f, this.g, aVar);
            this.c = 0;
        }
    }

    public void b() {
        this.b = false;
        this.c = 0;
    }

    public void c(w wVar, long j, int i, int i2, int i3, w.a aVar) {
        d4.a.h(this.g <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.b) {
            int i4 = this.c;
            int i5 = i4 + 1;
            this.c = i5;
            if (i4 == 0) {
                this.d = j;
                this.e = i;
                this.f = 0;
            }
            this.f += i2;
            this.g = i3;
            if (i5 >= 16) {
                a(wVar, aVar);
            }
        }
    }

    public void d(j jVar) {
        if (this.b) {
            return;
        }
        jVar.s(this.a, 0, 10);
        jVar.f();
        if (Q2.b.j(this.a) == 0) {
            return;
        }
        this.b = true;
    }
}
