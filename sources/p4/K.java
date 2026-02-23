package P4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.N;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        N n = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                i = y4.b.u(parcel, s);
            } else if (l != 2) {
                y4.b.A(parcel, s);
            } else {
                n = (N) y4.b.e(parcel, s, N.CREATOR);
            }
        }
        y4.b.k(parcel, B);
        return new j(i, n);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new j[i];
    }
}
