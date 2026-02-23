package x4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        int i = 0;
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                i = y4.b.u(parcel, s);
            } else if (l == 2) {
                uri = (Uri) y4.b.e(parcel, s, Uri.CREATOR);
            } else if (l == 3) {
                i2 = y4.b.u(parcel, s);
            } else if (l != 4) {
                y4.b.A(parcel, s);
            } else {
                i3 = y4.b.u(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new a(i, uri, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new a[i];
    }
}
