package H5;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                j = y4.b.w(parcel, s);
            } else if (l != 2) {
                y4.b.A(parcel, s);
            } else {
                j2 = y4.b.w(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new d(j, j2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new d[i];
    }
}
