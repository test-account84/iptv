package E2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements j8.a {
    public static final Object c = new Object();
    public volatile j8.a a;
    public volatile Object b = c;

    public a(j8.a aVar) {
        this.a = aVar;
    }

    public static j8.a a(j8.a aVar) {
        d.b(aVar);
        return aVar instanceof a ? aVar : new a(aVar);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public Object get() {
        Object obj = this.b;
        Object obj2 = c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.b;
                    if (obj == obj2) {
                        obj = this.a.get();
                        this.b = b(this.b, obj);
                        this.a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
