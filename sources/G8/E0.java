package G8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class e0 extends l {
    public final d0 a;

    public e0(d0 d0Var) {
        this.a = d0Var;
    }

    public void a(Throwable th) {
        this.a.dispose();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return k8.q.a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }
}
