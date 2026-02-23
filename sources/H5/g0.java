package H5;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g0 implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        b bVar = null;
        b0 b0Var = null;
        G5.f0 f0Var = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                bVar = (b) y4.b.e(parcel, s, b.CREATOR);
            } else if (l == 2) {
                b0Var = (b0) y4.b.e(parcel, s, b0.CREATOR);
            } else if (l != 3) {
                y4.b.A(parcel, s);
            } else {
                f0Var = (G5.f0) y4.b.e(parcel, s, G5.f0.CREATOR);
            }
        }
        y4.b.k(parcel, B);
        return new d0(bVar, b0Var, f0Var);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new d0[i];
    }
}
