package G5;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c0 implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 1:
                    str = y4.b.f(parcel, s);
                    break;
                case 2:
                    str2 = y4.b.f(parcel, s);
                    break;
                case 3:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 4:
                    str4 = y4.b.f(parcel, s);
                    break;
                case 5:
                    z = y4.b.m(parcel, s);
                    break;
                case 6:
                    str5 = y4.b.f(parcel, s);
                    break;
                case 7:
                    z2 = y4.b.m(parcel, s);
                    break;
                case 8:
                    str6 = y4.b.f(parcel, s);
                    break;
                case 9:
                    i = y4.b.u(parcel, s);
                    break;
                case 10:
                    str7 = y4.b.f(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new d(str, str2, str3, str4, z, str5, z2, str6, i, str7);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new d[i];
    }
}
