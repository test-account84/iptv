package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l1 {
    public static final Object h = new Object();
    public final String a;
    public final i1 b;
    public final Object c;
    public final Object d;
    public final Object e = new Object();
    public volatile Object f = null;
    public volatile Object g = null;

    public /* synthetic */ l1(String str, Object obj, Object obj2, i1 i1Var, k1 k1Var) {
        this.a = str;
        this.c = obj;
        this.d = obj2;
        this.b = i1Var;
    }

    public final Object a(Object obj) {
        synchronized (this.e) {
        }
        if (obj != null) {
            return obj;
        }
        if (j1.a == null) {
            return this.c;
        }
        synchronized (h) {
            try {
                if (c.a()) {
                    return this.g == null ? this.c : this.g;
                }
                try {
                    for (l1 l1Var : m1.b()) {
                        if (c.a()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object obj2 = null;
                        try {
                            i1 i1Var = l1Var.b;
                            if (i1Var != null) {
                                obj2 = i1Var.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (h) {
                            l1Var.g = obj2;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                i1 i1Var2 = this.b;
                if (i1Var2 == null) {
                    return this.c;
                }
                try {
                    return i1Var2.zza();
                } catch (SecurityException unused3) {
                    return this.c;
                } catch (IllegalStateException unused4) {
                    return this.c;
                }
            } finally {
            }
        }
    }

    public final String b() {
        return this.a;
    }
}
