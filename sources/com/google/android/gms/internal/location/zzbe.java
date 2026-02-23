package com.google.android.gms.internal.location;

import J4.f;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Locale;
import y4.a;
import y4.c;

@VisibleForTesting
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbe extends a implements f {
    public static final Parcelable.Creator CREATOR = new zzbf();
    private final String zza;
    private final long zzb;
    private final short zzc;
    private final double zzd;
    private final double zze;
    private final float zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;

    public zzbe(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        if (str == null || str.length() > 100) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "requestId is null or too long: ".concat(valueOf) : new String("requestId is null or too long: "));
        }
        if (f <= 0.0f) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("invalid radius: ");
            sb.append(f);
            throw new IllegalArgumentException(sb.toString());
        }
        if (d > 90.0d || d < -90.0d) {
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("invalid latitude: ");
            sb2.append(d);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (d2 > 180.0d || d2 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("invalid longitude: ");
            sb3.append(d2);
            throw new IllegalArgumentException(sb3.toString());
        }
        int i4 = i & 7;
        if (i4 == 0) {
            StringBuilder sb4 = new StringBuilder(46);
            sb4.append("No supported transition specified: ");
            sb4.append(i);
            throw new IllegalArgumentException(sb4.toString());
        }
        this.zzc = s;
        this.zza = str;
        this.zzd = d;
        this.zze = d2;
        this.zzf = f;
        this.zzb = j;
        this.zzg = i4;
        this.zzh = i2;
        this.zzi = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbe) {
            zzbe zzbeVar = (zzbe) obj;
            if (this.zzf == zzbeVar.zzf && this.zzd == zzbeVar.zzd && this.zze == zzbeVar.zze && this.zzc == zzbeVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final String getRequestId() {
        return this.zza;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzd);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zze);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzf)) * 31) + this.zzc) * 31) + this.zzg;
    }

    public final String toString() {
        Locale locale = Locale.US;
        short s = this.zzc;
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{s != -1 ? s != 1 ? "UNKNOWN" : "CIRCLE" : "INVALID", this.zza.replaceAll("\\p{C}", "?"), Integer.valueOf(this.zzg), Double.valueOf(this.zzd), Double.valueOf(this.zze), Float.valueOf(this.zzf), Integer.valueOf(this.zzh / 1000), Integer.valueOf(this.zzi), Long.valueOf(this.zzb)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.t(parcel, 1, this.zza, false);
        c.o(parcel, 2, this.zzb);
        c.s(parcel, 3, this.zzc);
        c.g(parcel, 4, this.zzd);
        c.g(parcel, 5, this.zze);
        c.i(parcel, 6, this.zzf);
        c.l(parcel, 7, this.zzg);
        c.l(parcel, 8, this.zzh);
        c.l(parcel, 9, this.zzi);
        c.b(parcel, a);
    }
}
