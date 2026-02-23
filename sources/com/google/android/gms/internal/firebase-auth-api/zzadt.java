package com.google.android.gms.internal.firebase-auth-api;

import C4.h;
import G5.H;
import android.app.Activity;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzadt {
    private static final Map zza = new s.a();

    public static H zza(String str, H h, zzacx zzacxVar) {
        zza(str, zzacxVar);
        return new zzads(h, str);
    }

    public static void zza() {
        zza.clear();
    }

    public static /* synthetic */ void zza(String str) {
        zza.remove(str);
    }

    private static void zza(String str, zzacx zzacxVar) {
        zza.put(str, new zzadv(zzacxVar, h.c().a()));
    }

    public static boolean zza(String str, H h, Activity activity, Executor executor) {
        Map map = zza;
        if (!map.containsKey(str)) {
            zza(str, null);
            return false;
        }
        zzadv zzadvVar = (zzadv) map.get(str);
        if (h.c().a() - zzadvVar.zzb >= 120000) {
            zza(str, null);
            return false;
        }
        zzacx zzacxVar = zzadvVar.zza;
        if (zzacxVar == null) {
            return true;
        }
        zzacxVar.zza(h, activity, executor, str);
        return true;
    }
}
