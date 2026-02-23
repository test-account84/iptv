package G5;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h0 implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            if (y4.b.l(s) != 1) {
                y4.b.A(parcel, s);
            } else {
                str = y4.b.f(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new i(str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new i[i];
    }
}
