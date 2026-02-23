package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import y4.a;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzba extends a {
    final LocationRequest zzb;
    final List zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final String zzh;
    final boolean zzi;
    boolean zzj;
    String zzk;
    long zzl;
    static final List zza = Collections.emptyList();
    public static final Parcelable.Creator CREATOR = new zzbb();

    public zzba(LocationRequest locationRequest, List list, String str, boolean z, boolean z2, boolean z3, String str2, boolean z4, boolean z5, String str3, long j) {
        this.zzb = locationRequest;
        this.zzc = list;
        this.zzd = str;
        this.zze = z;
        this.zzf = z2;
        this.zzg = z3;
        this.zzh = str2;
        this.zzi = z4;
        this.zzj = z5;
        this.zzk = str3;
        this.zzl = j;
    }

    public static zzba zza(String str, LocationRequest locationRequest) {
        return new zzba(locationRequest, zza, null, false, false, false, null, false, false, null, Long.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzba) {
            zzba zzbaVar = (zzba) obj;
            if (q.b(this.zzb, zzbaVar.zzb) && q.b(this.zzc, zzbaVar.zzc) && q.b(this.zzd, zzbaVar.zzd) && this.zze == zzbaVar.zze && this.zzf == zzbaVar.zzf && this.zzg == zzbaVar.zzg && q.b(this.zzh, zzbaVar.zzh) && this.zzi == zzbaVar.zzi && this.zzj == zzbaVar.zzj && q.b(this.zzk, zzbaVar.zzk)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        if (this.zzd != null) {
            sb.append(" tag=");
            sb.append(this.zzd);
        }
        if (this.zzh != null) {
            sb.append(" moduleId=");
            sb.append(this.zzh);
        }
        if (this.zzk != null) {
            sb.append(" contextAttributionTag=");
            sb.append(this.zzk);
        }
        sb.append(" hideAppOps=");
        sb.append(this.zze);
        sb.append(" clients=");
        sb.append(this.zzc);
        sb.append(" forceCoarseLocation=");
        sb.append(this.zzf);
        if (this.zzg) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        if (this.zzi) {
            sb.append(" locationSettingsIgnored");
        }
        if (this.zzj) {
            sb.append(" inaccurateLocationsDelayed");
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.r(parcel, 1, this.zzb, i, false);
        c.x(parcel, 5, this.zzc, false);
        c.t(parcel, 6, this.zzd, false);
        c.c(parcel, 7, this.zze);
        c.c(parcel, 8, this.zzf);
        c.c(parcel, 9, this.zzg);
        c.t(parcel, 10, this.zzh, false);
        c.c(parcel, 11, this.zzi);
        c.c(parcel, 12, this.zzj);
        c.t(parcel, 13, this.zzk, false);
        c.o(parcel, 14, this.zzl);
        c.b(parcel, a);
    }

    public final zzba zzb(long j) {
        if (this.zzb.J() <= this.zzb.I()) {
            this.zzl = 10000L;
            return this;
        }
        long I = this.zzb.I();
        long J = this.zzb.J();
        StringBuilder sb = new StringBuilder(120);
        sb.append("could not set max age when location batching is requested, interval=");
        sb.append(I);
        sb.append("maxWaitTime=");
        sb.append(J);
        throw new IllegalArgumentException(sb.toString());
    }

    public final zzba zzc(String str) {
        this.zzk = str;
        return this;
    }

    public final zzba zzd(boolean z) {
        this.zzj = true;
        return this;
    }
}
