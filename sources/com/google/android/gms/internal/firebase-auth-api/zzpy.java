package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzpy implements zzcp {
    private static final zzpy zza = new zzpy();

    private zzpy() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzct.zza(zza);
    }

    public final Class zza() {
        return zzpz.class;
    }

    public final Class zzb() {
        return zzpz.class;
    }

    public final /* synthetic */ Object zza(zzcg zzcgVar) throws GeneralSecurityException {
        if (zzcgVar == null) {
            throw new GeneralSecurityException("primitive set must be non-null");
        }
        if (zzcgVar.zza() == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        Iterator it = zzcgVar.zzd().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
            }
        }
        return new zzqb(zzcgVar, null);
    }
}
