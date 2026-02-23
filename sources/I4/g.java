package i4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                str = y4.b.f(parcel, s);
            } else if (l != 2) {
                y4.b.A(parcel, s);
            } else {
                i = y4.b.u(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new f(str, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new f[i];
    }
}
