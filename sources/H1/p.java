package h1;

import h1.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class p {
    public final Object a;
    public final b.a b;
    public final u c;
    public boolean d;

    public interface a {
        void a(u uVar);
    }

    public interface b {
        void a(Object obj);
    }

    public p(u uVar) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = uVar;
    }

    public static p a(u uVar) {
        return new p(uVar);
    }

    public static p c(Object obj, b.a aVar) {
        return new p(obj, aVar);
    }

    public boolean b() {
        return this.c == null;
    }

    public p(Object obj, b.a aVar) {
        this.d = false;
        this.a = obj;
        this.b = aVar;
        this.c = null;
    }
}
