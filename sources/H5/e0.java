package H5;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e0 implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                str = y4.b.f(parcel, s);
            } else if (l == 2) {
                str2 = y4.b.f(parcel, s);
            } else if (l != 3) {
                y4.b.A(parcel, s);
            } else {
                z = y4.b.m(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new b0(str, str2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new b0[i];
    }
}
