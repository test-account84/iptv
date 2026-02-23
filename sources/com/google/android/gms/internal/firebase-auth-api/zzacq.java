package com.google.android.gms.internal.firebase-auth-api;

import java.lang.reflect.Type;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzacq {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzacq";

    private zzacq() {
    }

    public static Object zza(String str, Type type) throws zzaaf {
        if (type == String.class) {
            try {
                zzael zzaelVar = (zzael) new zzael().zza(str);
                if (zzaelVar.zzb()) {
                    return zzaelVar.zza();
                }
                throw new zzaaf("No error message: " + str);
            } catch (Exception e) {
                throw new zzaaf("Json conversion failed! " + e.getMessage(), e);
            }
        }
        if (type == Void.class) {
            return null;
        }
        try {
            try {
                return ((zzacs) ((Class) type).getConstructor((Class[]) null).newInstance((Object[]) null)).zza(str);
            } catch (Exception e2) {
                throw new zzaaf("Json conversion failed! " + e2.getMessage(), e2);
            }
        } catch (Exception e3) {
            throw new zzaaf("Instantiation of JsonResponse failed! " + String.valueOf(type), e3);
        }
    }
}
