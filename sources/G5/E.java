package G5;

import android.net.Uri;
import com.google.android.gms.internal.firebase-auth-api.zzat;
import java.util.HashMap;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class e {
    public static final zzat g;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("recoverEmail", 2);
        hashMap.put("resetPassword", 0);
        hashMap.put("signIn", 4);
        hashMap.put("verifyEmail", 1);
        hashMap.put("verifyBeforeChangeEmail", 5);
        hashMap.put("revertSecondFactorAddition", 6);
        g = zzat.zza(hashMap);
    }

    public e(String str) {
        String d = d(str, "apiKey");
        String d2 = d(str, "oobCode");
        String d3 = d(str, "mode");
        if (d == null || d2 == null || d3 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", new Object[]{"apiKey", "oobCode", "mode"}));
        }
        this.a = com.google.android.gms.common.internal.r.g(d);
        this.b = com.google.android.gms.common.internal.r.g(d2);
        this.c = com.google.android.gms.common.internal.r.g(d3);
        this.d = d(str, "continueUrl");
        this.e = d(str, "languageCode");
        this.f = d(str, "tenantId");
    }

    public static e b(String str) {
        com.google.android.gms.common.internal.r.g(str);
        try {
            return new e(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String d(String str, String str2) {
        Uri parse = Uri.parse(str);
        try {
            Set queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return parse.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(com.google.android.gms.common.internal.r.g(parse.getQueryParameter("link"))).getQueryParameter(str2);
            }
            return null;
        } catch (UnsupportedOperationException | NullPointerException unused) {
            return null;
        }
    }

    public String a() {
        return this.b;
    }

    public final String c() {
        return this.f;
    }
}
