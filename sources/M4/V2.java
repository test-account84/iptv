package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v2 implements Runnable {
    public final /* synthetic */ f5 a;
    public final /* synthetic */ D2 c;

    public v2(D2 d2, f5 f5Var) {
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
        K2 c = K2.c(f5Var.A, 100);
        K2 c0 = Z.c0(f5Var.f);
        Z.d().v().c("Setting consent, package, consent", f5Var.f, c);
        Z.A(f5Var.f, c);
        if (c.m(c0)) {
            Z.v(f5Var);
        }
    }
}
