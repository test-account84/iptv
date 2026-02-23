package E1;

import d.D;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b {
    public final x1.d a;

    public b(x1.d dVar) {
        this.a = (x1.d) x1.g.c(dVar, "logger == null");
    }

    public void a(String str, Object... objArr) {
        e(3, str, null, objArr);
    }

    public void b(Throwable th, String str, Object... objArr) {
        e(3, str, th, objArr);
    }

    public void c(String str, Object... objArr) {
        e(6, str, null, objArr);
    }

    public void d(Throwable th, String str, Object... objArr) {
        e(6, str, th, objArr);
    }

    public final void e(int i, String str, Throwable th, Object... objArr) {
        if (this.a.f()) {
            D.a(this.a.e());
            x1.d.d(th);
            throw null;
        }
    }

    public void f(String str, Object... objArr) {
        e(5, str, null, objArr);
    }

    public void g(Throwable th, String str, Object... objArr) {
        e(5, str, th, objArr);
    }
}
