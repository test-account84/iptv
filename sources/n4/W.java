package n4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        u uVar = null;
        long j = 0;
        long j2 = 0;
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
                    j = y4.b.w(parcel, s);
                    break;
                case 5:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 6:
                    str4 = y4.b.f(parcel, s);
                    break;
                case 7:
                    str5 = y4.b.f(parcel, s);
                    break;
                case 8:
                    str6 = y4.b.f(parcel, s);
                    break;
                case 9:
                    str7 = y4.b.f(parcel, s);
                    break;
                case 10:
                    str8 = y4.b.f(parcel, s);
                    break;
                case 11:
                    j2 = y4.b.w(parcel, s);
                    break;
                case 12:
                    str9 = y4.b.f(parcel, s);
                    break;
                case 13:
                    uVar = (u) y4.b.e(parcel, s, u.CREATOR);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new a(str, str2, j, str3, str4, str5, str6, str7, str8, j2, str9, uVar);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new a[i];
    }
}
