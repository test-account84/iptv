package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x2 implements Runnable {
    public final /* synthetic */ v a;
    public final /* synthetic */ String c;
    public final /* synthetic */ D2 d;

    public x2(D2 d2, v vVar, String str) {
        this.d = d2;
        this.a = vVar;
        this.c = str;
    }

    public final void run() {
        D2.Z(this.d).e();
        D2.Z(this.d).k(this.a, this.c);
    }
}
