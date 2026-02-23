package n4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        List list = null;
        List list2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        String str5 = null;
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
                    list = y4.b.j(parcel, s, x4.a.CREATOR);
                    break;
                case 5:
                    list2 = y4.b.h(parcel, s);
                    break;
                case 6:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 7:
                    uri = (Uri) y4.b.e(parcel, s, Uri.CREATOR);
                    break;
                case 8:
                    str4 = y4.b.f(parcel, s);
                    break;
                case 9:
                    str5 = y4.b.f(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new d(str, str2, list, list2, str3, uri, str4, str5);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new d[i];
    }
}
