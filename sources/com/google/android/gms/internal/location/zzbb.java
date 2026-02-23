package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.location.LocationRequest;
import java.util.List;
import y4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbb implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = b.B(parcel);
        List list = zzba.zza;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j = Long.MAX_VALUE;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (parcel.dataPosition() < B) {
            int s = b.s(parcel);
            int l = b.l(s);
            if (l != 1) {
                switch (l) {
                    case 5:
                        list = b.j(parcel, s, d.CREATOR);
                        break;
                    case 6:
                        str = b.f(parcel, s);
                        break;
                    case 7:
                        z = b.m(parcel, s);
                        break;
                    case 8:
                        z2 = b.m(parcel, s);
                        break;
                    case 9:
                        z3 = b.m(parcel, s);
                        break;
                    case 10:
                        str2 = b.f(parcel, s);
                        break;
                    case 11:
                        z4 = b.m(parcel, s);
                        break;
                    case 12:
                        z5 = b.m(parcel, s);
                        break;
                    case 13:
                        str3 = b.f(parcel, s);
                        break;
                    case 14:
                        j = b.w(parcel, s);
                        break;
                    default:
                        b.A(parcel, s);
                        break;
                }
            } else {
                locationRequest = (LocationRequest) b.e(parcel, s, LocationRequest.CREATOR);
            }
        }
        b.k(parcel, B);
        return new zzba(locationRequest, list, str, z, z2, z3, str2, z4, z5, str3, j);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzba[i];
    }
}
