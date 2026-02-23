package com.onesignal;

import org.json.JSONException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class p2 extends m2 {
    public p2(String str, boolean z) {
        super(str, z);
    }

    public final int A() {
        int d = i().d("subscribableStatus", 1);
        if (d < -2) {
            return d;
        }
        if (i().c("androidPermission", true)) {
            return !i().c("userSubscribePref", true) ? -2 : 1;
        }
        return 0;
    }

    public void a() {
        try {
            t("notification_types", Integer.valueOf(A()));
        } catch (JSONException unused) {
        }
    }

    public m2 p(String str) {
        return new p2(str, false);
    }
}
