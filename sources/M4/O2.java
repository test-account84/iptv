package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o2 implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ D2 c;

    public o2(D2 d2, d dVar) {
        this.c = d2;
        this.a = dVar;
    }

    public final void run() {
        D2.Z(this.c).e();
        if (this.a.h.H() == null) {
            D2.Z(this.c).s(this.a);
        } else {
            D2.Z(this.c).y(this.a);
        }
    }
}
