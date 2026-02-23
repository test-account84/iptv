package W1;

import P1.a;
import W1.a;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e implements a {
    public static e f;
    public final c a = new c();
    public final j b = new j();
    public final File c;
    public final int d;
    public P1.a e;

    public e(File file, int i) {
        this.c = file;
        this.d = i;
    }

    public static synchronized a d(File file, int i) {
        e eVar;
        synchronized (e.class) {
            try {
                if (f == null) {
                    f = new e(file, i);
                }
                eVar = f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public void a(S1.c cVar) {
        try {
            e().V(this.b.a(cVar));
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }

    public void b(S1.c cVar, a.b bVar) {
        String a = this.b.a(cVar);
        this.a.a(cVar);
        try {
            try {
                a.b o = e().o(a);
                if (o != null) {
                    try {
                        if (bVar.a(o.f(0))) {
                            o.e();
                        }
                        o.b();
                    } catch (Throwable th) {
                        o.b();
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            this.a.b(cVar);
        } catch (Throwable th2) {
            this.a.b(cVar);
            throw th2;
        }
    }

    public File c(S1.c cVar) {
        try {
            a.d q = e().q(this.b.a(cVar));
            if (q != null) {
                return q.a(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    public final synchronized P1.a e() {
        try {
            if (this.e == null) {
                this.e = P1.a.s(this.c, 1, 1, this.d);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e;
    }
}
