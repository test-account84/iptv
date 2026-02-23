package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o4 implements Runnable {
    public final /* synthetic */ S4 a;
    public final /* synthetic */ Runnable c;

    public o4(q4 q4Var, S4 s4, Runnable runnable) {
        this.a = s4;
        this.c = runnable;
    }

    public final void run() {
        this.a.e();
        this.a.l0(this.c);
        this.a.C();
    }
}
