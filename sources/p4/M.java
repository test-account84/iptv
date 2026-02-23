package P4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.P;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        w4.b bVar = null;
        P p = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                i = y4.b.u(parcel, s);
            } else if (l == 2) {
                bVar = (w4.b) y4.b.e(parcel, s, w4.b.CREATOR);
            } else if (l != 3) {
                y4.b.A(parcel, s);
            } else {
                p = (P) y4.b.e(parcel, s, P.CREATOR);
            }
        }
        y4.b.k(parcel, B);
        return new l(i, bVar, p);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new l[i];
    }
}
