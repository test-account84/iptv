package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzald implements zzakl {
    private final zzakn zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzald(zzakn zzaknVar, String str, Object[] objArr) {
        this.zza = zzaknVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.zzd = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    public final zzakn zza() {
        return this.zza;
    }

    public final zzaky zzb() {
        int i = this.zzd;
        return (i & 1) != 0 ? zzaky.PROTO2 : (i & 4) == 4 ? zzaky.EDITIONS : zzaky.PROTO3;
    }

    public final boolean zzc() {
        return (this.zzd & 2) == 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
