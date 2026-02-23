package z3;

import O2.H0;
import android.util.SparseArray;
import c4.c;
import d4.k0;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b implements B {
    public static final SparseArray c = c();
    public final c.c a;
    public final Executor b;

    public b(c.c cVar, Executor executor) {
        this.a = (c.c) d4.a.e(cVar);
        this.b = (Executor) d4.a.e(executor);
    }

    public static SparseArray c() {
        SparseArray sparseArray = new SparseArray();
        try {
            sparseArray.put(0, d(G3.a.class));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, d(I3.a.class));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, d(O3.a.class));
        } catch (ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    public static Constructor d(Class cls) {
        try {
            return cls.asSubclass(A.class).getConstructor(new Class[]{H0.class, c.c.class, Executor.class});
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Downloader constructor missing", e);
        }
    }

    public A a(w wVar) {
        int y0 = k0.y0(wVar.c, wVar.d);
        if (y0 == 0 || y0 == 1 || y0 == 2) {
            return b(wVar, y0);
        }
        if (y0 == 4) {
            return new F(new H0.c().m(wVar.c).d(wVar.g).a(), this.a, this.b);
        }
        throw new IllegalArgumentException("Unsupported type: " + y0);
    }

    public final A b(w wVar, int i) {
        Constructor constructor = (Constructor) c.get(i);
        if (constructor == null) {
            throw new IllegalStateException("Module missing for content type " + i);
        }
        try {
            return (A) constructor.newInstance(new Object[]{new H0.c().m(wVar.c).j(wVar.e).d(wVar.g).a(), this.a, this.b});
        } catch (Exception e) {
            throw new IllegalStateException("Failed to instantiate downloader for content type " + i, e);
        }
    }
}
