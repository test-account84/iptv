package n4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class z implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 2) {
                f = y4.b.q(parcel, s);
            } else if (l == 3) {
                f2 = y4.b.q(parcel, s);
            } else if (l != 4) {
                y4.b.A(parcel, s);
            } else {
                f3 = y4.b.q(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new y(f, f2, f3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new y[i];
    }
}
