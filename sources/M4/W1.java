package M4;

import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w1 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ z1 g;

    public w1(z1 z1Var, int i, String str, Object obj, Object obj2, Object obj3) {
        this.g = z1Var;
        this.a = i;
        this.c = str;
        this.d = obj;
        this.e = obj2;
        this.f = obj3;
    }

    public final void run() {
        z1 z1Var;
        char c;
        P1 F = this.g.a.F();
        if (!F.n()) {
            Log.println(6, this.g.D(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        z1 z1Var2 = this.g;
        if (z1.o(z1Var2) == 0) {
            if (z1Var2.a.z().H()) {
                z1Var = this.g;
                z1Var.a.b();
                c = 'C';
            } else {
                z1Var = this.g;
                z1Var.a.b();
                c = 'c';
            }
            z1.F(z1Var, c);
        }
        z1 z1Var3 = this.g;
        if (z1.p(z1Var3) < 0) {
            z1Var3.a.z().q();
            z1.E(z1Var3, 79000L);
        }
        char charAt = "01VDIWEA?".charAt(this.a);
        z1 z1Var4 = this.g;
        String str = "2" + charAt + z1.o(z1Var4) + z1.p(z1Var4) + ":" + z1.A(true, this.c, this.d, this.e, this.f);
        if (str.length() > 1024) {
            str = this.c.substring(0, 1024);
        }
        N1 n1 = F.d;
        if (n1 != null) {
            n1.b(str, 1L);
        }
    }
}
