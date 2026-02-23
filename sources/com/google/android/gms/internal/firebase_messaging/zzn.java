package com.google.android.gms.internal.firebase_messaging;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzn implements zzs {
    private final int zza;
    private final zzr zzb;

    public zzn(int i, zzr zzrVar) {
        this.zza = i;
        this.zzb = zzrVar;
    }

    public final Class annotationType() {
        return zzs.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs zzsVar = (zzs) obj;
        return this.zza == zzsVar.zza() && this.zzb.equals(zzsVar.zzb());
    }

    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    public final int zza() {
        return this.zza;
    }

    public final zzr zzb() {
        return this.zzb;
    }
}
