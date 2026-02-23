package n4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 2) {
                j = y4.b.w(parcel, s);
            } else if (l == 3) {
                j2 = y4.b.w(parcel, s);
            } else if (l == 4) {
                str = y4.b.f(parcel, s);
            } else if (l == 5) {
                str2 = y4.b.f(parcel, s);
            } else if (l != 6) {
                y4.b.A(parcel, s);
            } else {
                j3 = y4.b.w(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new c(j, j2, str, str2, j3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new c[i];
    }
}
