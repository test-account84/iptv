package e4;

import e4.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class w implements Runnable {
    public final /* synthetic */ A.a a;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;

    public /* synthetic */ w(A.a aVar, String str, long j, long j2) {
        this.a = aVar;
        this.c = str;
        this.d = j;
        this.e = j2;
    }

    public final void run() {
        A.a.h(this.a, this.c, this.d, this.e);
    }
}
