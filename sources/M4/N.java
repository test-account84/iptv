package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n implements Runnable {
    public final /* synthetic */ G2 a;
    public final /* synthetic */ o c;

    public n(o oVar, G2 g2) {
        this.c = oVar;
        this.a = g2;
    }

    public final void run() {
        this.a.b();
        if (c.a()) {
            this.a.f().z(this);
            return;
        }
        boolean e = this.c.e();
        o.a(this.c, 0L);
        if (e) {
            this.c.c();
        }
    }
}
