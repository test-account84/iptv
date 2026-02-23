package z3;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public final w a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final int g;
    public final v h;

    public c(w wVar, int i, long j, long j2, long j3, int i2, int i3) {
        this(wVar, i, j, j2, j3, i2, i3, new v());
    }

    public long a() {
        return this.h.a;
    }

    public float b() {
        return this.h.b;
    }

    public boolean c() {
        int i = this.b;
        return i == 3 || i == 4;
    }

    public c(w wVar, int i, long j, long j2, long j3, int i2, int i3, v vVar) {
        d4.a.e(vVar);
        boolean z = false;
        d4.a.a((i3 == 0) == (i != 4));
        if (i2 != 0) {
            if (i != 2 && i != 0) {
                z = true;
            }
            d4.a.a(z);
        }
        this.a = wVar;
        this.b = i;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = i2;
        this.g = i3;
        this.h = vVar;
    }
}
