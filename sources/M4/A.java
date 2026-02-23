package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ long c;
    public final /* synthetic */ E0 d;

    public a(E0 e0, String str, long j) {
        this.d = e0;
        this.a = str;
        this.c = j;
    }

    public final void run() {
        E0.i(this.d, this.a, this.c);
    }
}
