package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class asr {

    @VisibleForTesting
    final File a;
    private final File b;
    private final SharedPreferences c;
    private final int d;

    public asr(Context context, int i) {
        this.c = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        com.google.ads.interactivemedia.v3.impl.data.av.e(dir, false);
        this.b = dir;
        File dir2 = context.getDir("tmppccache", 0);
        com.google.ads.interactivemedia.v3.impl.data.av.e(dir2, true);
        this.a = dir2;
        this.d = i;
    }

    @VisibleForTesting
    public static String a(apo apoVar) {
        return C4.j.a(apoVar.av());
    }

    private final File e() {
        File file = new File(this.b, Integer.toString(apl.b(this.d)));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String f() {
        return "FBAMTD" + apl.b(this.d);
    }

    private final String g() {
        return "LATMTD" + apl.b(this.d);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(com.google.ads.interactivemedia.v3.internal.apm r8, com.google.ads.interactivemedia.v3.internal.asu r9) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.asr.b(com.google.ads.interactivemedia.v3.internal.apm, com.google.ads.interactivemedia.v3.internal.asu):boolean");
    }

    @VisibleForTesting
    public final apo c(int i) {
        SharedPreferences sharedPreferences;
        String f;
        if (i == 1) {
            sharedPreferences = this.c;
            f = g();
        } else {
            sharedPreferences = this.c;
            f = f();
        }
        String string = sharedPreferences.getString(f, (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            apo g = apo.g(bpb.t(C4.j.d(string)));
            String k = g.k();
            File a = com.google.ads.interactivemedia.v3.impl.data.av.a(k, "pcam.jar", e());
            if (!a.exists()) {
                a = com.google.ads.interactivemedia.v3.impl.data.av.a(k, "pcam", e());
            }
            File a2 = com.google.ads.interactivemedia.v3.impl.data.av.a(k, "pcbc", e());
            if (a.exists()) {
                if (a2.exists()) {
                    return g;
                }
            }
        } catch (bqw unused) {
        }
        return null;
    }

    public final asq d(int i) {
        apo c = c(1);
        if (c == null) {
            return null;
        }
        String k = c.k();
        File a = com.google.ads.interactivemedia.v3.impl.data.av.a(k, "pcam.jar", e());
        if (!a.exists()) {
            a = com.google.ads.interactivemedia.v3.impl.data.av.a(k, "pcam", e());
        }
        return new asq(c, a, com.google.ads.interactivemedia.v3.impl.data.av.a(k, "pcbc", e()), com.google.ads.interactivemedia.v3.impl.data.av.a(k, "pcopt", e()));
    }
}
