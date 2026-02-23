package w4;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        PendingIntent pendingIntent = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                i = y4.b.u(parcel, s);
            } else if (l == 2) {
                i2 = y4.b.u(parcel, s);
            } else if (l == 3) {
                pendingIntent = (PendingIntent) y4.b.e(parcel, s, PendingIntent.CREATOR);
            } else if (l != 4) {
                y4.b.A(parcel, s);
            } else {
                str = y4.b.f(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new b(i, i2, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
