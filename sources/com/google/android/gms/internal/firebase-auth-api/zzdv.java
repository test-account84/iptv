package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzif;
import com.google.android.gms.internal.firebase-auth-api.zzuy;
import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzdv extends zznb {
    public zzdv() {
        super(zzsi.class, new zzdu(zzxi.class));
    }

    public final /* synthetic */ zzakn zza(zzahp zzahpVar) throws zzaji {
        return zzsi.zza(zzahpVar, zzaio.zza());
    }

    public final zzif.zza zzb() {
        return zzif.zza.zza;
    }

    public final zzne zzc() {
        return new zzdx(this, zzsj.class);
    }

    public final zzuy.zza zzd() {
        return zzuy.zza.SYMMETRIC;
    }

    public final String zze() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final /* bridge */ /* synthetic */ void zza(zzakn zzaknVar) throws GeneralSecurityException {
        zza((zzsi) zzaknVar);
    }

    public static /* bridge */ /* synthetic */ void zza(zzdv zzdvVar, zzsm zzsmVar) {
        zza(zzsmVar);
    }

    public static void zza(zzsi zzsiVar) throws GeneralSecurityException {
        zzxo.zza(zzsiVar.zza(), 0);
        zzxo.zza(zzsiVar.zzf().zzb());
        zza(zzsiVar.zze());
    }

    private static void zza(zzsm zzsmVar) throws GeneralSecurityException {
        if (zzsmVar.zza() < 12 || zzsmVar.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
