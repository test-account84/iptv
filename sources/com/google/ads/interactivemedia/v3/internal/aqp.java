package com.google.ads.interactivemedia.v3.internal;

import android.os.StrictMode;
import com.google.android.gms.common.internal.Hide;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aqp {
    public static Object a(atq atqVar) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return atqVar.a();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
