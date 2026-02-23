package M4;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f3 implements Runnable {
    public final /* synthetic */ AtomicReference a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ t3 f;

    public f3(t3 t3Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f = t3Var;
        this.a = atomicReference;
        this.c = str2;
        this.d = str3;
        this.e = z;
    }

    public final void run() {
        this.f.a.L().W(this.a, null, this.c, this.d, this.e);
    }
}
