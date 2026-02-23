package M4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g5 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        List list = null;
        String str8 = null;
        String str9 = null;
        String str10 = "";
        String str11 = str10;
        long j7 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = false;
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
                    str3 = y4.b.f(parcel, s);
                    break;
                case 5:
                    str4 = y4.b.f(parcel, s);
                    break;
                case 6:
                    j = y4.b.w(parcel, s);
                    break;
                case 7:
                    j2 = y4.b.w(parcel, s);
                    break;
                case 8:
                    str5 = y4.b.f(parcel, s);
                    break;
                case 9:
                    z = y4.b.m(parcel, s);
                    break;
                case 10:
                    z2 = y4.b.m(parcel, s);
                    break;
                case 11:
                    j7 = y4.b.w(parcel, s);
                    break;
                case 12:
                    str6 = y4.b.f(parcel, s);
                    break;
                case 13:
                    j3 = y4.b.w(parcel, s);
                    break;
                case 14:
                    j4 = y4.b.w(parcel, s);
                    break;
                case 15:
                    i = y4.b.u(parcel, s);
                    break;
                case 16:
                    z3 = y4.b.m(parcel, s);
                    break;
                case 17:
                case 20:
                default:
                    y4.b.A(parcel, s);
                    break;
                case 18:
                    z4 = y4.b.m(parcel, s);
                    break;
                case 19:
                    str7 = y4.b.f(parcel, s);
                    break;
                case 21:
                    bool = y4.b.n(parcel, s);
                    break;
                case 22:
                    j5 = y4.b.w(parcel, s);
                    break;
                case 23:
                    list = y4.b.h(parcel, s);
                    break;
                case 24:
                    str8 = y4.b.f(parcel, s);
                    break;
                case 25:
                    str10 = y4.b.f(parcel, s);
                    break;
                case 26:
                    str11 = y4.b.f(parcel, s);
                    break;
                case 27:
                    str9 = y4.b.f(parcel, s);
                    break;
                case 28:
                    z5 = y4.b.m(parcel, s);
                    break;
                case 29:
                    j6 = y4.b.w(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new f5(str, str2, str3, str4, j, j2, str5, z, z2, j7, str6, j3, j4, i, z3, z4, str7, bool, j5, list, str8, str10, str11, str9, z5, j6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new f5[i];
    }
}
