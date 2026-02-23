package v4;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            if (y4.b.l(s) != 1) {
                y4.b.A(parcel, s);
            } else {
                intent = (Intent) y4.b.e(parcel, s, Intent.CREATOR);
            }
        }
        y4.b.k(parcel, B);
        return new a(intent);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new a[i];
    }
}
