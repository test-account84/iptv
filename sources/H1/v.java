package h1;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class v {
    public static String a = "Volley";
    public static boolean b = Log.isLoggable("Volley", 2);
    public static final String c = v.class.getName();

    public static class a {
        public static final boolean c = v.b;
        public final List a = new ArrayList();
        public boolean b = false;

        public static class a {
            public final String a;
            public final long b;
            public final long c;

            public a(String str, long j, long j2) {
                this.a = str;
                this.b = j;
                this.c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (this.b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.a.add(new a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void b(String str) {
            this.b = true;
            long c2 = c();
            if (c2 <= 0) {
                return;
            }
            long j = ((a) this.a.get(0)).c;
            v.b("(%-4d ms) %s", Long.valueOf(c2), str);
            for (a aVar : this.a) {
                long j2 = aVar.c;
                v.b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(aVar.b), aVar.a);
                j = j2;
            }
        }

        public final long c() {
            if (this.a.size() == 0) {
                return 0L;
            }
            return ((a) this.a.get(r2.size() - 1)).c - ((a) this.a.get(0)).c;
        }

        public void finalize() {
            if (this.b) {
                return;
            }
            b("Request on the loose");
            v.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClassName().equals(c)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }

    public static void b(String str, Object... objArr) {
        Log.d(a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(a, a(str, objArr));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        Log.e(a, a(str, objArr), th);
    }

    public static void e(String str, Object... objArr) {
        if (b) {
            Log.v(a, a(str, objArr));
        }
    }
}
