package H5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        List list = null;
        k kVar = null;
        String str = null;
        G5.f0 f0Var = null;
        b bVar = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 1:
                    list = y4.b.j(parcel, s, G5.J.CREATOR);
                    break;
                case 2:
                    kVar = (k) y4.b.e(parcel, s, k.CREATOR);
                    break;
                case 3:
                    str = y4.b.f(parcel, s);
                    break;
                case 4:
                    f0Var = (G5.f0) y4.b.e(parcel, s, G5.f0.CREATOR);
                    break;
                case 5:
                    bVar = (b) y4.b.e(parcel, s, b.CREATOR);
                    break;
                case 6:
                    arrayList = y4.b.j(parcel, s, G5.M.CREATOR);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new h(list, kVar, str, f0Var, bVar, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new h[i];
    }
}
