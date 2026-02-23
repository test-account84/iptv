package Q2;

import Q2.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ z.a a;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;

    public /* synthetic */ x(z.a aVar, int i, long j, long j2) {
        this.a = aVar;
        this.c = i;
        this.d = j;
        this.e = j2;
    }

    public final void run() {
        z.a.f(this.a, this.c, this.d, this.e);
    }
}
