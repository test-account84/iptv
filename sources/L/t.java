package L;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class t {
    public static long a;
    public static Method b;
    public static Method c;
    public static Method d;
    public static Method e;

    public static class a {
        public static void a(String str) {
            Trace.beginSection(str);
        }

        public static void b() {
            Trace.endSection();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                Class cls = Long.TYPE;
                b = Trace.class.getMethod("isTagEnabled", new Class[]{cls});
                Class cls2 = Integer.TYPE;
                c = Trace.class.getMethod("asyncTraceBegin", new Class[]{cls, String.class, cls2});
                d = Trace.class.getMethod("asyncTraceEnd", new Class[]{cls, String.class, cls2});
                e = Trace.class.getMethod("traceCounter", new Class[]{cls, String.class, cls2});
            } catch (Exception e2) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
            }
        }
    }

    public static void a(String str) {
        a.a(str);
    }

    public static void b() {
        a.b();
    }
}
