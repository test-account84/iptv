package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import w4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzacm {
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int j = i.h().j(context, 12451000);
            zza = Boolean.valueOf(j == 0 || j == 2);
        }
        return zza.booleanValue();
    }
}
