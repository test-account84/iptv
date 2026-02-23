package Q2;

import Q2.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ z.a a;
    public final /* synthetic */ String c;

    public /* synthetic */ p(z.a aVar, String str) {
        this.a = aVar;
        this.c = str;
    }

    public final void run() {
        z.a.c(this.a, this.c);
    }
}
