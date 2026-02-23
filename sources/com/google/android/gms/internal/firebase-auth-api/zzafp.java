package com.google.android.gms.internal.firebase-auth-api;

import C4.c;
import com.google.android.gms.common.internal.r;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzafp {
    public static long zza(String str) {
        zzafo zzb = zzb(str);
        return zzb.zza().longValue() - zzb.zzb().longValue();
    }

    private static zzafo zzb(String str) {
        r.g(str);
        List zza = zzab.zza('.').zza((CharSequence) str);
        if (zza.size() >= 2) {
            try {
                return zzafo.zza(new String(c.b((String) zza.get(1)), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Unable to decode token", e);
            }
        }
        throw new RuntimeException("Invalid idToken " + str);
    }
}
