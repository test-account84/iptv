package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import j$.util.Objects;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class OnBackPressedDispatcher {
    public final Runnable a;
    public O.a c;
    public OnBackInvokedCallback d;
    public OnBackInvokedDispatcher e;
    public final ArrayDeque b = new ArrayDeque();
    public boolean f = false;

    public class LifecycleOnBackPressedCancellable implements androidx.lifecycle.n, androidx.activity.a {
        public final androidx.lifecycle.j a;
        public final h c;
        public androidx.activity.a d;

        public LifecycleOnBackPressedCancellable(androidx.lifecycle.j jVar, h hVar) {
            this.a = jVar;
            this.c = hVar;
            jVar.a(this);
        }

        public void b(p pVar, j.b bVar) {
            if (bVar == j.b.ON_START) {
                this.d = OnBackPressedDispatcher.this.c(this.c);
                return;
            }
            if (bVar != j.b.ON_STOP) {
                if (bVar == j.b.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar = this.d;
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }

        public void cancel() {
            this.a.c(this);
            this.c.e(this);
            androidx.activity.a aVar = this.d;
            if (aVar != null) {
                aVar.cancel();
                this.d = null;
            }
        }
    }

    public static class a {
        public static OnBackInvokedCallback a(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new k(runnable);
        }

        public static void b(Object obj, int i, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class b implements androidx.activity.a {
        public final h a;

        public b(h hVar) {
            this.a = hVar;
        }

        public void cancel() {
            OnBackPressedDispatcher.this.b.remove(this.a);
            this.a.e(this);
            if (L.a.d()) {
                this.a.g(null);
                OnBackPressedDispatcher.this.h();
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.a = runnable;
        if (L.a.d()) {
            this.c = new i(this);
            this.d = a.a(new j(this));
        }
    }

    public static /* synthetic */ void a(OnBackPressedDispatcher onBackPressedDispatcher, Boolean bool) {
        onBackPressedDispatcher.e(bool);
    }

    public void b(p pVar, h hVar) {
        androidx.lifecycle.j lifecycle = pVar.getLifecycle();
        if (lifecycle.b() == j.c.DESTROYED) {
            return;
        }
        hVar.a(new LifecycleOnBackPressedCancellable(lifecycle, hVar));
        if (L.a.d()) {
            h();
            hVar.g(this.c);
        }
    }

    public androidx.activity.a c(h hVar) {
        this.b.add(hVar);
        b bVar = new b(hVar);
        hVar.a(bVar);
        if (L.a.d()) {
            h();
            hVar.g(this.c);
        }
        return bVar;
    }

    public boolean d() {
        Iterator descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (((h) descendingIterator.next()).c()) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ void e(Boolean bool) {
        if (L.a.d()) {
            h();
        }
    }

    public void f() {
        Iterator descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext()) {
            h hVar = (h) descendingIterator.next();
            if (hVar.c()) {
                hVar.b();
                return;
            }
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void g(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        this.e = onBackInvokedDispatcher;
        h();
    }

    public void h() {
        boolean d = d();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.e;
        if (onBackInvokedDispatcher != null) {
            if (d && !this.f) {
                a.b(onBackInvokedDispatcher, 0, this.d);
                this.f = true;
            } else {
                if (d || !this.f) {
                    return;
                }
                a.c(onBackInvokedDispatcher, this.d);
                this.f = false;
            }
        }
    }
}
