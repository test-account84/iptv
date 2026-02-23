package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import y4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbd implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = b.B(parcel);
        zzba zzbaVar = null;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        int i = 1;
        while (parcel.dataPosition() < B) {
            int s = b.s(parcel);
            switch (b.l(s)) {
                case 1:
                    i = b.u(parcel, s);
                    break;
                case 2:
                    zzbaVar = (zzba) b.e(parcel, s, zzba.CREATOR);
                    break;
                case 3:
                    iBinder = b.t(parcel, s);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) b.e(parcel, s, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = b.t(parcel, s);
                    break;
                case 6:
                    iBinder3 = b.t(parcel, s);
                    break;
                default:
                    b.A(parcel, s);
                    break;
            }
        }
        b.k(parcel, B);
        return new zzbc(i, zzbaVar, iBinder, pendingIntent, iBinder2, iBinder3);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzbc[i];
    }
}
