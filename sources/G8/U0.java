package G8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class u0 extends l {
    public final w8.l a;

    public u0(w8.l lVar) {
        this.a = lVar;
    }

    public void a(Throwable th) {
        this.a.invoke(th);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return k8.q.a;
    }

    public String toString() {
        return "InvokeOnCancel[" + P.a(this.a) + '@' + P.b(this) + ']';
    }
}
