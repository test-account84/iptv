package e4;

import e4.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ A.a a;
    public final /* synthetic */ String c;

    public /* synthetic */ t(A.a aVar, String str) {
        this.a = aVar;
        this.c = str;
    }

    public final void run() {
        A.a.j(this.a, this.c);
    }
}
