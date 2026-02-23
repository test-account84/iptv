package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v4 {
    public u4 a;
    public final /* synthetic */ z4 b;

    public v4(z4 z4Var) {
        this.b = z4Var;
    }

    public final void a(long j) {
        this.a = new u4(this, this.b.a.a().a(), j);
        z4.o(this.b).postDelayed(this.a, 2000L);
    }

    public final void b() {
        this.b.h();
        u4 u4Var = this.a;
        if (u4Var != null) {
            z4.o(this.b).removeCallbacks(u4Var);
        }
        this.b.a.F().r.a(false);
        this.b.s(false);
    }
}
