package I5;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class x implements j6.b {
    public static final Object c = new Object();
    public volatile Object a = c;
    public volatile j6.b b;

    public x(j6.b bVar) {
        this.b = bVar;
    }

    public Object get() {
        Object obj = this.a;
        Object obj2 = c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.a;
                    if (obj == obj2) {
                        obj = this.b.get();
                        this.a = obj;
                        this.b = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
