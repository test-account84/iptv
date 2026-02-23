package com.google.android.gms.internal.measurement;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzie extends zzii {
    static final zzie zza = new zzie();

    private zzie() {
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    public final Object zza() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final boolean zzb() {
        return false;
    }
}
