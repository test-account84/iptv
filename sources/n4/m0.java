package n4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        double d = 0.0d;
        String str = null;
        List list = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 2) {
                i = y4.b.u(parcel, s);
            } else if (l == 3) {
                str = y4.b.f(parcel, s);
            } else if (l == 4) {
                list = y4.b.j(parcel, s, m.CREATOR);
            } else if (l == 5) {
                list2 = y4.b.j(parcel, s, x4.a.CREATOR);
            } else if (l != 6) {
                y4.b.A(parcel, s);
            } else {
                d = y4.b.o(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new n(i, str, list, list2, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new n[i];
    }
}
