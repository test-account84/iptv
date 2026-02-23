package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcl extends y4.a {
    public static final Parcelable.Creator CREATOR = new zzcm();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final Bundle zzg;
    public final String zzh;

    public zzcl(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle, String str4) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = z;
        this.zzd = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = bundle;
        this.zzh = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.o(parcel, 1, this.zza);
        y4.c.o(parcel, 2, this.zzb);
        y4.c.c(parcel, 3, this.zzc);
        y4.c.t(parcel, 4, this.zzd, false);
        y4.c.t(parcel, 5, this.zze, false);
        y4.c.t(parcel, 6, this.zzf, false);
        y4.c.e(parcel, 7, this.zzg, false);
        y4.c.t(parcel, 8, this.zzh, false);
        y4.c.b(parcel, a);
    }
}
