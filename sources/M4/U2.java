package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u2 implements Runnable {
    public final /* synthetic */ f5 a;
    public final /* synthetic */ D2 c;

    public u2(D2 d2, f5 f5Var) {
        this.c = d2;
        this.a = f5Var;
    }

    public final void run() {
        D2.Z(this.c).e();
        S4 Z = D2.Z(this.c);
        f5 f5Var = this.a;
        Z.f().h();
        Z.g();
        com.google.android.gms.common.internal.r.g(f5Var.f);
        Z.S(f5Var);
    }
}
