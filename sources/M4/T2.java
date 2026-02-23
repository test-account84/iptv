package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t2 implements Runnable {
    public final /* synthetic */ f5 a;
    public final /* synthetic */ D2 c;

    public t2(D2 d2, f5 f5Var) {
        this.c = d2;
        this.a = f5Var;
    }

    public final void run() {
        D2.Z(this.c).e();
        D2.Z(this.c).v(this.a);
    }
}
