package com.google.android.gms.internal.location;

import J4.Y;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.d;
import java.util.List;
import y4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzk implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = b.B(parcel);
        Y y = zzj.zzb;
        List list = zzj.zza;
        String str = null;
        while (parcel.dataPosition() < B) {
            int s = b.s(parcel);
            int l = b.l(s);
            if (l == 1) {
                y = (Y) b.e(parcel, s, Y.CREATOR);
            } else if (l == 2) {
                list = b.j(parcel, s, d.CREATOR);
            } else if (l != 3) {
                b.A(parcel, s);
            } else {
                str = b.f(parcel, s);
            }
        }
        b.k(parcel, B);
        return new zzj(y, list, str);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzj[i];
    }
}
