package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u4 implements Runnable {
    public final long a;
    public final long c;
    public final /* synthetic */ v4 d;

    public u4(v4 v4Var, long j, long j2) {
        this.d = v4Var;
        this.a = j;
        this.c = j2;
    }

    public final void run() {
        this.d.b.a.f().z(new t4(this));
    }
}
