package com.google.android.gms.internal.location;

import J4.Y;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;
import y4.a;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzj extends a {
    final Y zzc;
    final List zzd;
    final String zze;

    @VisibleForTesting
    static final List zza = Collections.emptyList();
    static final Y zzb = new Y();
    public static final Parcelable.Creator CREATOR = new zzk();

    public zzj(Y y, List list, String str) {
        this.zzc = y;
        this.zzd = list;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        return q.b(this.zzc, zzjVar.zzc) && q.b(this.zzd, zzjVar.zzd) && q.b(this.zze, zzjVar.zze);
    }

    public final int hashCode() {
        return this.zzc.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        String str = this.zze;
        int length = valueOf.length();
        StringBuilder sb = new StringBuilder(length + 77 + valueOf2.length() + String.valueOf(str).length());
        sb.append("DeviceOrientationRequestInternal{deviceOrientationRequest=");
        sb.append(valueOf);
        sb.append(", clients=");
        sb.append(valueOf2);
        sb.append(", tag='");
        sb.append(str);
        sb.append("'}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.r(parcel, 1, this.zzc, i, false);
        c.x(parcel, 2, this.zzd, false);
        c.t(parcel, 3, this.zze, false);
        c.b(parcel, a);
    }
}
