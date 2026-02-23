package kotlinx.coroutines.scheduling;

import G8.n0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class f extends n0 {
    public final int e;
    public final int f;
    public final long g;
    public final String h;
    public a i = f0();

    public f(int i, int i2, long j, String str) {
        this.e = i;
        this.f = i2;
        this.g = j;
        this.h = str;
    }

    public void c0(o8.g gVar, Runnable runnable) {
        a.h(this.i, runnable, null, false, 6, null);
    }

    public final a f0() {
        return new a(this.e, this.f, this.g, this.h);
    }

    public final void g0(Runnable runnable, i iVar, boolean z) {
        this.i.g(runnable, iVar, z);
    }
}
