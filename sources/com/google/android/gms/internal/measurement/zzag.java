package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzag implements zzap {
    private final zzap zza;
    private final String zzb;

    public zzag() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return false;
        }
        zzag zzagVar = (zzag) obj;
        return this.zzb.equals(zzagVar.zzb) && this.zza.equals(zzagVar.zza);
    }

    public final int hashCode() {
        return (this.zzb.hashCode() * 31) + this.zza.hashCode();
    }

    public final zzap zzb() {
        return this.zza;
    }

    public final zzap zzbU(String str, zzg zzgVar, List list) {
        throw new IllegalStateException("Control does not have functions");
    }

    public final String zzc() {
        return this.zzb;
    }

    public final zzap zzd() {
        return new zzag(this.zzb, this.zza.zzd());
    }

    public final Boolean zzg() {
        throw new IllegalStateException("Control is not a boolean");
    }

    public final Double zzh() {
        throw new IllegalStateException("Control is not a double");
    }

    public final String zzi() {
        throw new IllegalStateException("Control is not a String");
    }

    public final Iterator zzl() {
        return null;
    }

    public zzag(String str) {
        this.zza = zzap.zzf;
        this.zzb = str;
    }

    public zzag(String str, zzap zzapVar) {
        this.zza = zzapVar;
        this.zzb = str;
    }
}
