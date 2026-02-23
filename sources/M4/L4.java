package M4;

import android.content.pm.PackageManager;
import android.util.Pair;
import h4.a;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l4 extends E4 {
    public final Map d;
    public final L1 e;
    public final L1 f;
    public final L1 g;
    public final L1 h;
    public final L1 i;

    public l4(S4 s4) {
        super(s4);
        this.d = new HashMap();
        P1 F = this.a.F();
        F.getClass();
        this.e = new L1(F, "last_delete_stale", 0L);
        P1 F2 = this.a.F();
        F2.getClass();
        this.f = new L1(F2, "backoff", 0L);
        P1 F3 = this.a.F();
        F3.getClass();
        this.g = new L1(F3, "last_upload", 0L);
        P1 F4 = this.a.F();
        F4.getClass();
        this.h = new L1(F4, "last_upload_attempt", 0L);
        P1 F5 = this.a.F();
        F5.getClass();
        this.i = new L1(F5, "midnight_offset", 0L);
    }

    public final boolean l() {
        return false;
    }

    public final Pair m(String str) {
        k4 k4Var;
        a.a aVar;
        h();
        long b = this.a.a().b();
        k4 k4Var2 = (k4) this.d.get(str);
        if (k4Var2 != null && b < k4Var2.c) {
            return new Pair(k4Var2.a, Boolean.valueOf(k4Var2.b));
        }
        h4.a.c(true);
        long r = this.a.z().r(str, m1.c) + b;
        try {
            long r2 = this.a.z().r(str, m1.d);
            if (r2 > 0) {
                try {
                    aVar = h4.a.a(this.a.c());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (k4Var2 != null && b < k4Var2.c + r2) {
                        return new Pair(k4Var2.a, Boolean.valueOf(k4Var2.b));
                    }
                    aVar = null;
                }
            } else {
                aVar = h4.a.a(this.a.c());
            }
        } catch (Exception e) {
            this.a.d().q().b("Unable to get advertising id", e);
            k4Var = new k4("", false, r);
        }
        if (aVar == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String a = aVar.a();
        k4Var = a != null ? new k4(a, aVar.b(), r) : new k4("", aVar.b(), r);
        this.d.put(str, k4Var);
        h4.a.c(false);
        return new Pair(k4Var.a, Boolean.valueOf(k4Var.b));
    }

    public final Pair n(String str, K2 k2) {
        return k2.j(J2.AD_STORAGE) ? m(str) : new Pair("", Boolean.FALSE);
    }

    public final String o(String str, boolean z) {
        h();
        String str2 = z ? (String) m(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest t = a5.t();
        if (t == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, t.digest(str2.getBytes()))});
    }
}
