package U1;

import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i implements Runnable, X1.b {
    public final O1.i a;
    public final a c;
    public final U1.a d;
    public b e = b.CACHE;
    public volatile boolean f;

    public interface a extends m2.e {
        void c(i iVar);
    }

    public enum b {
        CACHE,
        SOURCE
    }

    public i(a aVar, U1.a aVar2, O1.i iVar) {
        this.c = aVar;
        this.d = aVar2;
        this.a = iVar;
    }

    public int a() {
        return this.a.ordinal();
    }

    public void b() {
        this.f = true;
        this.d.c();
    }

    public final l c() {
        return f() ? d() : e();
    }

    public final l d() {
        l lVar;
        try {
            lVar = this.d.f();
        } catch (Exception e) {
            if (Log.isLoggable("EngineRunnable", 3)) {
                Log.d("EngineRunnable", "Exception decoding result from cache: " + e);
            }
            lVar = null;
        }
        return lVar == null ? this.d.h() : lVar;
    }

    public final l e() {
        return this.d.d();
    }

    public final boolean f() {
        return this.e == b.CACHE;
    }

    public final void g(l lVar) {
        this.c.f(lVar);
    }

    public final void h(Exception exc) {
        if (!f()) {
            this.c.a(exc);
        } else {
            this.e = b.SOURCE;
            this.c.c(this);
        }
    }

    public void run() {
        Exception exc;
        if (this.f) {
            return;
        }
        l lVar = null;
        try {
            lVar = c();
            exc = null;
        } catch (OutOfMemoryError e) {
            if (Log.isLoggable("EngineRunnable", 2)) {
                Log.v("EngineRunnable", "Out Of Memory Error decoding", e);
            }
            exc = new j(e);
        } catch (Exception e2) {
            if (Log.isLoggable("EngineRunnable", 2)) {
                Log.v("EngineRunnable", "Exception decoding", e2);
            }
            exc = e2;
        }
        if (this.f) {
            if (lVar != null) {
                lVar.b();
            }
        } else if (lVar == null) {
            h(exc);
        } else {
            g(lVar);
        }
    }
}
