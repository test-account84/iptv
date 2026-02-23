package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class z2 implements Runnable {
    public final /* synthetic */ V4 a;
    public final /* synthetic */ f5 c;
    public final /* synthetic */ D2 d;

    public z2(D2 d2, V4 v4, f5 f5Var) {
        this.d = d2;
        this.a = v4;
        this.c = f5Var;
    }

    public final void run() {
        D2.Z(this.d).e();
        if (this.a.H() == null) {
            D2.Z(this.d).u(this.a.g, this.c);
        } else {
            D2.Z(this.d).B(this.a, this.c);
        }
    }
}
