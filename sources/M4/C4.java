package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c4 implements Runnable {
    public final /* synthetic */ p1 a;
    public final /* synthetic */ h4 c;

    public c4(h4 h4Var, p1 p1Var) {
        this.c = h4Var;
        this.a = p1Var;
    }

    public final void run() {
        synchronized (this.c) {
            try {
                h4.a(this.c, false);
                if (!this.c.d.z()) {
                    this.c.d.a.d().v().a("Connected to service");
                    this.c.d.x(this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
