package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n2 implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ f5 c;
    public final /* synthetic */ D2 d;

    public n2(D2 d2, d dVar, f5 f5Var) {
        this.d = d2;
        this.a = dVar;
        this.c = f5Var;
    }

    public final void run() {
        D2.Z(this.d).e();
        if (this.a.h.H() == null) {
            D2.Z(this.d).t(this.a, this.c);
        } else {
            D2.Z(this.d).z(this.a, this.c);
        }
    }
}
