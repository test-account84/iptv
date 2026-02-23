package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzwt {
    private final zzwy zzh;
    public static final zzwt zza = new zzwt(new zzxa());
    public static final zzwt zzb = new zzwt(new zzxe());
    private static final zzwt zzf = new zzwt(new zzxg());
    private static final zzwt zzg = new zzwt(new zzxh());
    public static final zzwt zzc = new zzwt(new zzxd());
    public static final zzwt zzd = new zzwt(new zzxf());
    public static final zzwt zze = new zzwt(new zzxc());

    private zzwt(zzxb zzxbVar) {
        this.zzh = zzif.zzb() ? new zzww(zzxbVar, null) : zzxp.zza() ? new zzws(zzxbVar, null) : new zzwu(zzxbVar, null);
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzh.zza(str);
    }

    public static List zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }
}
