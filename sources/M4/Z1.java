package M4;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.zzpe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class z1 extends F2 {
    public char c;
    public long d;
    public String e;
    public final x1 f;
    public final x1 g;
    public final x1 h;
    public final x1 i;
    public final x1 j;
    public final x1 k;
    public final x1 l;
    public final x1 m;
    public final x1 n;

    public z1(l2 l2Var) {
        super(l2Var);
        this.c = (char) 0;
        this.d = -1L;
        this.f = new x1(this, 6, false, false);
        this.g = new x1(this, 6, true, false);
        this.h = new x1(this, 6, false, true);
        this.i = new x1(this, 5, false, false);
        this.j = new x1(this, 5, true, false);
        this.k = new x1(this, 5, false, true);
        this.l = new x1(this, 4, false, false);
        this.m = new x1(this, 3, false, false);
        this.n = new x1(this, 2, false, false);
    }

    public static String A(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String B = B(z, obj);
        String B2 = B(z, obj2);
        String B3 = B(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(B)) {
            sb.append(str2);
            sb.append(B);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(B2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(B2);
        }
        if (!TextUtils.isEmpty(B3)) {
            sb.append(str3);
            sb.append(B3);
        }
        return sb.toString();
    }

    public static String B(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            char charAt = obj.toString().charAt(0);
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder();
            String str = charAt == '-' ? "-" : "";
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof y1 ? y1.a((y1) obj) : z ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String C = C(l2.class.getCanonicalName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && C(className).equals(C)) {
                sb2.append(": ");
                sb2.append(stackTraceElement);
                break;
            }
            i++;
        }
        return sb2.toString();
    }

    public static String C(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            return str.substring(0, lastIndexOf);
        }
        zzpe.zzc();
        return ((Boolean) m1.A0.a(null)).booleanValue() ? "" : str;
    }

    public static /* bridge */ /* synthetic */ void E(z1 z1Var, long j) {
        z1Var.d = 79000L;
    }

    public static /* bridge */ /* synthetic */ void F(z1 z1Var, char c) {
        z1Var.c = c;
    }

    public static /* bridge */ /* synthetic */ char o(z1 z1Var) {
        return z1Var.c;
    }

    public static /* bridge */ /* synthetic */ long p(z1 z1Var) {
        return z1Var.d;
    }

    public static Object z(String str) {
        if (str == null) {
            return null;
        }
        return new y1(str);
    }

    public final String D() {
        String str;
        synchronized (this) {
            try {
                if (this.e == null) {
                    this.e = this.a.Q() != null ? this.a.Q() : this.a.z().w();
                }
                com.google.android.gms.common.internal.r.m(this.e);
                str = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final void G(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(D(), i)) {
            Log.println(i, D(), A(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        com.google.android.gms.common.internal.r.m(str);
        i2 G = this.a.G();
        if (G == null) {
            Log.println(6, D(), "Scheduler not set. Not logging error/warn");
        } else if (G.n()) {
            G.z(new w1(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
        } else {
            Log.println(6, D(), "Scheduler not initialized. Not logging error/warn");
        }
    }

    public final boolean j() {
        return false;
    }

    public final x1 q() {
        return this.m;
    }

    public final x1 r() {
        return this.f;
    }

    public final x1 s() {
        return this.h;
    }

    public final x1 t() {
        return this.g;
    }

    public final x1 u() {
        return this.l;
    }

    public final x1 v() {
        return this.n;
    }

    public final x1 w() {
        return this.i;
    }

    public final x1 x() {
        return this.k;
    }

    public final x1 y() {
        return this.j;
    }
}
