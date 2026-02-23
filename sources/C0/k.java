package C0;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class k {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final e b;
    public volatile G0.f c;

    public k(e eVar) {
        this.b = eVar;
    }

    public G0.f a() {
        b();
        return e(this.a.compareAndSet(false, true));
    }

    public void b() {
        this.b.a();
    }

    public final G0.f c() {
        return this.b.d(d());
    }

    public abstract String d();

    public final G0.f e(boolean z) {
        if (!z) {
            return c();
        }
        if (this.c == null) {
            this.c = c();
        }
        return this.c;
    }

    public void f(G0.f fVar) {
        if (fVar == this.c) {
            this.a.set(false);
        }
    }
}
