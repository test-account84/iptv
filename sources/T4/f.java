package t4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        double d = 0.0d;
        double d2 = 0.0d;
        n4.d dVar = null;
        n4.A a = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 2:
                    d = y4.b.o(parcel, s);
                    break;
                case 3:
                    z = y4.b.m(parcel, s);
                    break;
                case 4:
                    i = y4.b.u(parcel, s);
                    break;
                case 5:
                    dVar = (n4.d) y4.b.e(parcel, s, n4.d.CREATOR);
                    break;
                case 6:
                    i2 = y4.b.u(parcel, s);
                    break;
                case 7:
                    a = (n4.A) y4.b.e(parcel, s, n4.A.CREATOR);
                    break;
                case 8:
                    d2 = y4.b.o(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new e(d, z, i, dVar, i2, a, d2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new e[i];
    }
}
