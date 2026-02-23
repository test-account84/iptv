package w4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        long j = -1;
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                str = y4.b.f(parcel, s);
            } else if (l == 2) {
                i = y4.b.u(parcel, s);
            } else if (l != 3) {
                y4.b.A(parcel, s);
            } else {
                j = y4.b.w(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new d(str, i, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new d[i];
    }
}
