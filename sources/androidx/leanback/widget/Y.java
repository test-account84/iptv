package androidx.leanback.widget;

import android.database.Observable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class y {
    public final a a = new a();
    public boolean b;
    public F c;

    public static final class a extends Observable {
        public void a() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((b) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    public static abstract class b {
        public abstract void a();
    }

    public y(E e) {
        h(new S(e));
    }

    public abstract Object a(int i);

    public long b(int i) {
        return -1L;
    }

    public final F c() {
        return this.c;
    }

    public final boolean d() {
        return this.b;
    }

    public final void e() {
        this.a.a();
    }

    public void f() {
    }

    public final void g(b bVar) {
        this.a.registerObserver(bVar);
    }

    public final void h(F f) {
        if (f == null) {
            throw new IllegalArgumentException("Presenter selector must not be null");
        }
        F f2 = this.c;
        boolean z = false;
        boolean z2 = f2 != null;
        if (z2 && f2 != f) {
            z = true;
        }
        this.c = f;
        if (z) {
            f();
        }
        if (z2) {
            e();
        }
    }

    public abstract int i();

    public final void j(b bVar) {
        this.a.unregisterObserver(bVar);
    }
}
