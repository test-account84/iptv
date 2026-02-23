package Q2;

import Q2.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class w implements Runnable {
    public final /* synthetic */ z.a a;
    public final /* synthetic */ Exception c;

    public /* synthetic */ w(z.a aVar, Exception exc) {
        this.a = aVar;
        this.c = exc;
    }

    public final void run() {
        z.a.h(this.a, this.c);
    }
}
