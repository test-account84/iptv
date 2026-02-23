package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzags implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 2:
                    str = y4.b.f(parcel, s);
                    break;
                case 3:
                    str2 = y4.b.f(parcel, s);
                    break;
                case 4:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 5:
                    str4 = y4.b.f(parcel, s);
                    break;
                case 6:
                    str5 = y4.b.f(parcel, s);
                    break;
                case 7:
                    str6 = y4.b.f(parcel, s);
                    break;
                case 8:
                    str7 = y4.b.f(parcel, s);
                    break;
                case 9:
                    str8 = y4.b.f(parcel, s);
                    break;
                case 10:
                    z = y4.b.m(parcel, s);
                    break;
                case 11:
                    z2 = y4.b.m(parcel, s);
                    break;
                case 12:
                    str9 = y4.b.f(parcel, s);
                    break;
                case 13:
                    str10 = y4.b.f(parcel, s);
                    break;
                case 14:
                    str11 = y4.b.f(parcel, s);
                    break;
                case 15:
                    str12 = y4.b.f(parcel, s);
                    break;
                case 16:
                    z3 = y4.b.m(parcel, s);
                    break;
                case 17:
                    str13 = y4.b.f(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new zzagt(str, str2, str3, str4, str5, str6, str7, str8, z, z2, str9, str10, str11, str12, z3, str13);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzagt[i];
    }
}
