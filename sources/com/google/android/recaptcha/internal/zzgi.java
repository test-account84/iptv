package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzgi extends zzeh {
    protected zzgo zza;
    private final zzgo zzb;

    public zzgi(zzgo zzgoVar) {
        this.zzb = zzgoVar;
        if (zzgoVar.zzF()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = zzgoVar.zzs();
    }

    private static void zzd(Object obj, Object obj2) {
        zzih.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    public final /* synthetic */ zzhy zzX() {
        return this.zzb;
    }

    public final /* synthetic */ zzeh zzb(zzei zzeiVar) {
        zzg((zzgo) zzeiVar);
        return this;
    }

    /* renamed from: zzf, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzgi zza() {
        zzgi zzgiVar = (zzgi) this.zzb.zzh(5, null, null);
        zzgiVar.zza = zzk();
        return zzgiVar;
    }

    public final zzgi zzg(zzgo zzgoVar) {
        if (!this.zzb.equals(zzgoVar)) {
            if (!this.zza.zzF()) {
                zzn();
            }
            zzd(this.zza, zzgoVar);
        }
        return this;
    }

    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzgo zzj() {
        zzgo zzk = zzk();
        if (zzk.zzo()) {
            return zzk;
        }
        throw new zzje(zzk);
    }

    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public zzgo zzk() {
        if (!this.zza.zzF()) {
            return this.zza;
        }
        this.zza.zzA();
        return this.zza;
    }

    public final void zzm() {
        if (this.zza.zzF()) {
            return;
        }
        zzn();
    }

    public void zzn() {
        zzgo zzs = this.zzb.zzs();
        zzd(zzs, this.zza);
        this.zza = zzs;
    }

    public final boolean zzo() {
        return zzgo.zzE(this.zza, false);
    }
}
