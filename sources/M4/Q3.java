package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q3 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ t3 c;

    public q3(t3 t3Var, boolean z) {
        this.c = t3Var;
        this.a = z;
    }

    public final void run() {
        boolean o = this.c.a.o();
        boolean n = this.c.a.n();
        this.c.a.k(this.a);
        if (n == this.a) {
            this.c.a.d().v().b("Default data collection state already set to", Boolean.valueOf(this.a));
        }
        if (this.c.a.o() == o || this.c.a.o() != this.c.a.n()) {
            this.c.a.d().x().c("Default data collection is different than actual status", Boolean.valueOf(this.a), Boolean.valueOf(o));
        }
        t3.e0(this.c);
    }
}
