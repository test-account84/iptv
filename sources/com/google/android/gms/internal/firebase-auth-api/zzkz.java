package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzsi;
import com.google.android.gms.internal.firebase-auth-api.zzsu;
import com.google.android.gms.internal.firebase-auth-api.zztc;
import com.google.android.gms.internal.firebase-auth-api.zzuc;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzkz implements zzwi {
    private final String zza;
    private final int zzb;
    private zzsu zzc;
    private zzse zzd;
    private int zze;
    private zztc zzf;

    public zzkz(zzvb zzvbVar) throws GeneralSecurityException {
        String zzf = zzvbVar.zzf();
        this.zza = zzf;
        if (zzf.equals(zzcw.zzb)) {
            try {
                zzsv zza = zzsv.zza(zzvbVar.zze(), zzaio.zza());
                this.zzc = zzsu.zza(zzct.zza(zzvbVar).zze(), zzaio.zza());
                this.zzb = zza.zza();
                return;
            } catch (zzaji e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        }
        if (zzf.equals(zzcw.zza)) {
            try {
                zzsf zza2 = zzsf.zza(zzvbVar.zze(), zzaio.zza());
                this.zzd = zzse.zza(zzct.zza(zzvbVar).zze(), zzaio.zza());
                this.zze = zza2.zzc().zza();
                this.zzb = this.zze + zza2.zzd().zza();
                return;
            } catch (zzaji e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        }
        if (!zzf.equals(zziz.zza)) {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: " + zzf);
        }
        try {
            zztd zza3 = zztd.zza(zzvbVar.zze(), zzaio.zza());
            this.zzf = zztc.zza(zzct.zza(zzvbVar).zze(), zzaio.zza());
            this.zzb = zza3.zza();
        } catch (zzaji e3) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
        }
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzly zza(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzb) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.zza.equals(zzcw.zzb)) {
            return new zzly((zzbg) zzct.zza(this.zza, ((zzsu) ((zzajc) ((zzsu.zza) zzsu.zzb().zza(this.zzc)).zza(zzahp.zza(bArr, 0, this.zzb)).zzf())).zzi(), zzbg.class));
        }
        if (!this.zza.equals(zzcw.zza)) {
            if (!this.zza.equals(zziz.zza)) {
                throw new GeneralSecurityException("unknown DEM key type");
            }
            return new zzly((zzbp) zzct.zza(this.zza, ((zztc) ((zzajc) ((zztc.zza) zztc.zzb().zza(this.zzf)).zza(zzahp.zza(bArr, 0, this.zzb)).zzf())).zzi(), zzbp.class));
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
        zzsi zzsiVar = (zzsi) ((zzajc) ((zzsi.zza) zzsi.zzb().zza(this.zzd.zzd())).zza(zzahp.zza(copyOfRange)).zzf());
        return new zzly((zzbg) zzct.zza(this.zza, ((zzse) ((zzajc) zzse.zzb().zza(this.zzd.zza()).zza(zzsiVar).zza((zzuc) ((zzajc) ((zzuc.zza) zzuc.zzb().zza(this.zzd.zze())).zza(zzahp.zza(copyOfRange2)).zzf())).zzf())).zzi(), zzbg.class));
    }
}
