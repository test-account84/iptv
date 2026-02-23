package x6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class g extends n {
    public static final g d;

    static {
        g gVar = new g();
        d = gVar;
        gVar.setStackTrace(n.c);
    }

    public g() {
    }

    public static g a() {
        return n.a ? new g() : d;
    }

    public static g b(Throwable th) {
        return n.a ? new g(th) : d;
    }

    public g(Throwable th) {
        super(th);
    }
}
