package n4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        long j = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        n nVar = null;
        List list = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 2:
                    str = y4.b.f(parcel, s);
                    break;
                case 3:
                    str2 = y4.b.f(parcel, s);
                    break;
                case 4:
                    i = y4.b.u(parcel, s);
                    break;
                case 5:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 6:
                    nVar = (n) y4.b.e(parcel, s, n.CREATOR);
                    break;
                case 7:
                    i2 = y4.b.u(parcel, s);
                    break;
                case 8:
                    list = y4.b.j(parcel, s, p.CREATOR);
                    break;
                case 9:
                    i3 = y4.b.u(parcel, s);
                    break;
                case 10:
                    j = y4.b.w(parcel, s);
                    break;
                case 11:
                    z = y4.b.m(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new o(str, str2, i, str3, nVar, i2, list, i3, j, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new o[i];
    }
}
