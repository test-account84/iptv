package o4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        List list = null;
        n4.i iVar = null;
        p4.a aVar = null;
        List list2 = null;
        double d = 0.0d;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i = 0;
        boolean z8 = false;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 2:
                    str = y4.b.f(parcel, s);
                    break;
                case 3:
                    list = y4.b.h(parcel, s);
                    break;
                case 4:
                    z = y4.b.m(parcel, s);
                    break;
                case 5:
                    iVar = (n4.i) y4.b.e(parcel, s, n4.i.CREATOR);
                    break;
                case 6:
                    z2 = y4.b.m(parcel, s);
                    break;
                case 7:
                    aVar = (p4.a) y4.b.e(parcel, s, p4.a.CREATOR);
                    break;
                case 8:
                    z3 = y4.b.m(parcel, s);
                    break;
                case 9:
                    d = y4.b.o(parcel, s);
                    break;
                case 10:
                    z4 = y4.b.m(parcel, s);
                    break;
                case 11:
                    z5 = y4.b.m(parcel, s);
                    break;
                case 12:
                    z6 = y4.b.m(parcel, s);
                    break;
                case 13:
                    list2 = y4.b.h(parcel, s);
                    break;
                case 14:
                    z7 = y4.b.m(parcel, s);
                    break;
                case 15:
                    i = y4.b.u(parcel, s);
                    break;
                case 16:
                    z8 = y4.b.m(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new c(str, list, z, iVar, z2, aVar, z3, d, z4, z5, z6, list2, z7, i, z8);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new c[i];
    }
}
