package P4;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        Intent intent = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                i = y4.b.u(parcel, s);
            } else if (l == 2) {
                i2 = y4.b.u(parcel, s);
            } else if (l != 3) {
                y4.b.A(parcel, s);
            } else {
                intent = (Intent) y4.b.e(parcel, s, Intent.CREATOR);
            }
        }
        y4.b.k(parcel, B);
        return new b(i, i2, intent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
