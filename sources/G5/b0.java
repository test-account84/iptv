package G5;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b0 implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 2) {
                str = y4.b.f(parcel, s);
            } else if (l == 3) {
                str2 = y4.b.f(parcel, s);
            } else if (l == 4) {
                z = y4.b.m(parcel, s);
            } else if (l != 5) {
                y4.b.A(parcel, s);
            } else {
                z2 = y4.b.m(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new P(str, str2, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new P[i];
    }
}
