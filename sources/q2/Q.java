package Q2;

import Q2.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ z.a a;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;

    public /* synthetic */ q(z.a aVar, String str, long j, long j2) {
        this.a = aVar;
        this.c = str;
        this.d = j;
        this.e = j2;
    }

    public final void run() {
        z.a.j(this.a, this.c, this.d, this.e);
    }
}
