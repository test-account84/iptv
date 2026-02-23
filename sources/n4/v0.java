package n4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        l lVar = null;
        String str = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 2) {
                lVar = (l) y4.b.e(parcel, s, l.CREATOR);
            } else if (l != 3) {
                y4.b.A(parcel, s);
            } else {
                str = y4.b.f(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new s(lVar, t4.a.a(str));
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new s[i];
    }
}
