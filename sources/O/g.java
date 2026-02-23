package O;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends f {
    public final Object c;

    public g(int i) {
        super(i);
        this.c = new Object();
    }

    public boolean a(Object obj) {
        boolean a;
        synchronized (this.c) {
            a = super.a(obj);
        }
        return a;
    }

    public Object b() {
        Object b;
        synchronized (this.c) {
            b = super.b();
        }
        return b;
    }
}
