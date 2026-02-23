package M4;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzra;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r3 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Uri c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ s3 f;

    public r3(s3 s3Var, boolean z, Uri uri, String str, String str2) {
        this.f = s3Var;
        this.a = z;
        this.c = uri;
        this.d = str;
        this.e = str2;
    }

    public final void run() {
        Bundle v0;
        s3 s3Var = this.f;
        boolean z = this.a;
        Uri uri = this.c;
        String str = this.d;
        String str2 = this.e;
        s3Var.a.h();
        try {
            a5 N = s3Var.a.a.N();
            zzra.zzc();
            h z2 = s3Var.a.a.z();
            l1 l1Var = m1.x0;
            boolean B = z2.B(null, l1Var);
            if (TextUtils.isEmpty(str2)) {
                v0 = null;
            } else {
                if (!str2.contains("gclid") && !str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_id") && !str2.contains("dclid") && !str2.contains("srsltid")) {
                    if (B && str2.contains("sfmc_id")) {
                        B = true;
                    }
                    N.a.d().q().a("Activity created with data 'referrer' without required params");
                    v0 = null;
                }
                v0 = N.v0(Uri.parse("https://google.com/search?".concat(str2)), B);
                if (v0 != null) {
                    v0.putString("_cis", "referrer");
                }
            }
            if (z) {
                a5 N2 = s3Var.a.a.N();
                zzra.zzc();
                Bundle v02 = N2.v0(uri, s3Var.a.a.z().B(null, l1Var));
                if (v02 != null) {
                    v02.putString("_cis", "intent");
                    if (!v02.containsKey("gclid") && v0 != null && v0.containsKey("gclid")) {
                        v02.putString("_cer", String.format("gclid=%s", new Object[]{v0.getString("gclid")}));
                    }
                    s3Var.a.u(str, "_cmp", v02);
                    s3Var.a.l.a(str, v02);
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            s3Var.a.a.d().q().b("Activity created with referrer", str2);
            if (s3Var.a.a.z().B(null, m1.c0)) {
                if (v0 != null) {
                    s3Var.a.u(str, "_cmp", v0);
                    s3Var.a.l.a(str, v0);
                } else {
                    s3Var.a.a.d().q().b("Referrer does not contain valid parameters", str2);
                }
                s3Var.a.K("auto", "_ldl", null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                s3Var.a.a.d().q().a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                s3Var.a.K("auto", "_ldl", str2, true);
            }
        } catch (RuntimeException e) {
            s3Var.a.a.d().r().b("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }
}
