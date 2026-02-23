package n4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.MediaTrack;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        List list = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 2:
                    j = y4.b.w(parcel, s);
                    break;
                case 3:
                    i = y4.b.u(parcel, s);
                    break;
                case 4:
                    str2 = y4.b.f(parcel, s);
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
                    i2 = y4.b.u(parcel, s);
                    break;
                case 9:
                    list = y4.b.h(parcel, s);
                    break;
                case 10:
                    str = y4.b.f(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new MediaTrack(j, i, str2, str3, str4, str5, i2, list, t4.a.a(str));
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MediaTrack[i];
    }
}
