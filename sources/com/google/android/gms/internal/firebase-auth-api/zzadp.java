package com.google.android.gms.internal.firebase-auth-api;

import C4.j;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzadp {
    private final String zza;
    private final String zzb;

    public zzadp(Context context) {
        this(context, context.getPackageName());
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    private zzadp(Context context, String str) {
        r.m(context);
        String g = r.g(str);
        this.zza = g;
        try {
            byte[] a = C4.a.a(context, g);
            if (a != null) {
                this.zzb = j.c(a, false);
                return;
            }
            Log.e("FBA-PackageInfo", "single cert required: " + str);
            this.zzb = null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("FBA-PackageInfo", "no pkg: " + str);
            this.zzb = null;
        }
    }
}
