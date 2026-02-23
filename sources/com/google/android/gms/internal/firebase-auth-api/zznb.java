package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zznb {
    private final Class zza;
    private final Map zzb;
    private final Class zzc;

    @SafeVarargs
    public zznb(Class cls, zzoh... zzohVarArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        for (zzoh zzohVar : zzohVarArr) {
            if (hashMap.containsKey(zzohVar.zza())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + zzohVar.zza().getCanonicalName());
            }
            hashMap.put(zzohVar.zza(), zzohVar);
        }
        this.zzc = zzohVarArr.length > 0 ? zzohVarArr[0].zza() : Void.class;
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public abstract zzakn zza(zzahp zzahpVar) throws zzaji;

    public final Object zza(zzakn zzaknVar, Class cls) throws GeneralSecurityException {
        zzoh zzohVar = (zzoh) this.zzb.get(cls);
        if (zzohVar != null) {
            return zzohVar.zza(zzaknVar);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract void zza(zzakn zzaknVar) throws GeneralSecurityException;

    public abstract zzif.zza zzb();

    public zzne zzc() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract zzuy.zza zzd();

    public abstract String zze();

    public final Class zzf() {
        return this.zzc;
    }

    public final Class zzg() {
        return this.zza;
    }

    public final Set zzh() {
        return this.zzb.keySet();
    }
}
