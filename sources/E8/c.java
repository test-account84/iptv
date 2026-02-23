package E8;

import java.nio.charset.Charset;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class c {
    public static final c a = new c();
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    public static final Charset g;
    public static Charset h;
    public static Charset i;

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.l.d(forName, "forName(\"UTF-8\")");
        b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.l.d(forName2, "forName(\"UTF-16\")");
        c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.l.d(forName3, "forName(\"UTF-16BE\")");
        d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.l.d(forName4, "forName(\"UTF-16LE\")");
        e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.l.d(forName5, "forName(\"US-ASCII\")");
        f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.l.d(forName6, "forName(\"ISO-8859-1\")");
        g = forName6;
    }

    public final Charset a() {
        Charset charset = i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        kotlin.jvm.internal.l.d(forName, "forName(\"UTF-32BE\")");
        i = forName;
        return forName;
    }

    public final Charset b() {
        Charset charset = h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        kotlin.jvm.internal.l.d(forName, "forName(\"UTF-32LE\")");
        h = forName;
        return forName;
    }
}
