package n4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        int i = 0;
        ArrayList arrayList = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 2) {
                arrayList = y4.b.j(parcel, s, x4.a.CREATOR);
            } else if (l == 3) {
                bundle = y4.b.a(parcel, s);
            } else if (l != 4) {
                y4.b.A(parcel, s);
            } else {
                i = y4.b.u(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new m(arrayList, bundle, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new m[i];
    }
}
