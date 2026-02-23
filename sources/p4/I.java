package P4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        ArrayList arrayList = null;
        String str = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                arrayList = y4.b.h(parcel, s);
            } else if (l != 2) {
                y4.b.A(parcel, s);
            } else {
                str = y4.b.f(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new h(arrayList, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new h[i];
    }
}
