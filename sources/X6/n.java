package x6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class n extends Exception {
    public static final boolean a;
    public static final StackTraceElement[] c;

    static {
        a = System.getProperty("surefire.test.class.path") != null;
        c = new StackTraceElement[0];
    }

    public n() {
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    public n(Throwable th) {
        super(th);
    }
}
