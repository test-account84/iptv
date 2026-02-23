package U1;

import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h implements l {
    public final l a;
    public final boolean b;
    public a c;
    public S1.c d;
    public int e;
    public boolean f;

    public interface a {
        void c(S1.c cVar, h hVar);
    }

    public h(l lVar, boolean z) {
        if (lVar == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.a = lVar;
        this.b = z;
    }

    public void a() {
        if (this.f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.e++;
    }

    public void b() {
        if (this.e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f = true;
        this.a.b();
    }

    public boolean c() {
        return this.b;
    }

    public void d() {
        if (this.e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = this.e - 1;
        this.e = i;
        if (i == 0) {
            this.c.c(this.d, this);
        }
    }

    public void e(S1.c cVar, a aVar) {
        this.d = cVar;
        this.c = aVar;
    }

    public Object get() {
        return this.a.get();
    }

    public int getSize() {
        return this.a.getSize();
    }
}
