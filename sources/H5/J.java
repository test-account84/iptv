package H5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        List list = null;
        List list2 = null;
        b bVar = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                str = y4.b.f(parcel, s);
            } else if (l == 2) {
                str2 = y4.b.f(parcel, s);
            } else if (l == 3) {
                list = y4.b.j(parcel, s, G5.J.CREATOR);
            } else if (l == 4) {
                list2 = y4.b.j(parcel, s, G5.M.CREATOR);
            } else if (l != 5) {
                y4.b.A(parcel, s);
            } else {
                bVar = (b) y4.b.e(parcel, s, b.CREATOR);
            }
        }
        y4.b.k(parcel, B);
        return new k(str, str2, list, list2, bVar);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new k[i];
    }
}
