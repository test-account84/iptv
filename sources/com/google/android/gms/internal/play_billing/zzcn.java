package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzcn extends zzax {
    protected zzcs zza;
    private final zzcs zzb;

    public zzcn(zzcs zzcsVar) {
        this.zzb = zzcsVar;
        if (zzcsVar.zzw()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = zzcsVar.zzl();
    }

    private static void zzl(Object obj, Object obj2) {
        zzel.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    /* renamed from: zzb, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzcn zza() {
        zzcn zzcnVar = (zzcn) this.zzb.zzx(5, null, null);
        zzcnVar.zza = zzg();
        return zzcnVar;
    }

    public final zzcn zzc(zzcs zzcsVar) {
        if (!this.zzb.equals(zzcsVar)) {
            if (!this.zza.zzw()) {
                zzj();
            }
            zzl(this.zza, zzcsVar);
        }
        return this;
    }

    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzcs zzf() {
        zzcs zzg = zzg();
        if (zzg.zzk()) {
            return zzg;
        }
        throw new zzfe(zzg);
    }

    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public zzcs zzg() {
        if (!this.zza.zzw()) {
            return this.zza;
        }
        this.zza.zzr();
        return this.zza;
    }

    public final /* bridge */ /* synthetic */ zzec zzh() {
        throw null;
    }

    public final void zzi() {
        if (this.zza.zzw()) {
            return;
        }
        zzj();
    }

    public void zzj() {
        zzcs zzl = this.zzb.zzl();
        zzl(zzl, this.zza);
        this.zza = zzl;
    }

    public final boolean zzk() {
        return zzcs.zzv(this.zza, false);
    }
}
