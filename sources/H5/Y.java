package H5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class y implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        ArrayList arrayList = null;
        List list = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                arrayList = y4.b.j(parcel, s, G5.J.CREATOR);
            } else if (l != 2) {
                y4.b.A(parcel, s);
            } else {
                list = y4.b.j(parcel, s, G5.M.CREATOR);
            }
        }
        y4.b.k(parcel, B);
        return new z(arrayList, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new z[i];
    }
}
