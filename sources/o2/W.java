package O2;

import O2.n;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w extends p1 {
    public static final n.a q = new v();
    public static final String r = d4.k0.A0(1001);
    public static final String s = d4.k0.A0(1002);
    public static final String t = d4.k0.A0(1003);
    public static final String u = d4.k0.A0(1004);
    public static final String v = d4.k0.A0(1005);
    public static final String w = d4.k0.A0(1006);
    public final int j;
    public final String k;
    public final int l;
    public final z0 m;
    public final int n;
    public final B3.A o;
    public final boolean p;

    public w(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, false);
    }

    public static /* synthetic */ w f(Bundle bundle) {
        return new w(bundle);
    }

    public static w i(Throwable th, String str, int i, z0 z0Var, int i2, boolean z, int i3) {
        return new w(1, th, null, i3, str, i, z0Var, z0Var == null ? 4 : i2, z);
    }

    public static w j(IOException iOException, int i) {
        return new w(0, iOException, i);
    }

    public static w k(RuntimeException runtimeException) {
        return l(runtimeException, 1000);
    }

    public static w l(RuntimeException runtimeException, int i) {
        return new w(2, runtimeException, i);
    }

    public static String m(int i, String str, String str2, int i2, z0 z0Var, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i2 + ", format=" + z0Var + ", format_supported=" + d4.k0.b0(i3);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    public w g(B3.A a) {
        return new w((String) d4.k0.j(getMessage()), getCause(), this.a, this.j, this.k, this.l, this.m, this.n, a, this.c, this.p);
    }

    public Bundle h() {
        Bundle h = super.h();
        h.putInt(r, this.j);
        h.putString(s, this.k);
        h.putInt(t, this.l);
        z0 z0Var = this.m;
        if (z0Var != null) {
            h.putBundle(u, z0Var.h());
        }
        h.putInt(v, this.n);
        h.putBoolean(w, this.p);
        return h;
    }

    public w(int i, Throwable th, String str, int i2, String str2, int i3, z0 z0Var, int i4, boolean z) {
        this(m(i, str, str2, i3, z0Var, i4), th, i2, i, str2, i3, z0Var, i4, null, SystemClock.elapsedRealtime(), z);
    }

    public w(Bundle bundle) {
        super(bundle);
        this.j = bundle.getInt(r, 2);
        this.k = bundle.getString(s);
        this.l = bundle.getInt(t, -1);
        Bundle bundle2 = bundle.getBundle(u);
        this.m = bundle2 == null ? null : (z0) z0.u0.a(bundle2);
        this.n = bundle.getInt(v, 4);
        this.p = bundle.getBoolean(w, false);
        this.o = null;
    }

    public w(String str, Throwable th, int i, int i2, String str2, int i3, z0 z0Var, int i4, B3.A a, long j, boolean z) {
        super(str, th, i, j);
        d4.a.a(!z || i2 == 1);
        d4.a.a(th != null || i2 == 3);
        this.j = i2;
        this.k = str2;
        this.l = i3;
        this.m = z0Var;
        this.n = i4;
        this.o = a;
        this.p = z;
    }
}
