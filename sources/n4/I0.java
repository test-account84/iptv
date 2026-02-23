package n4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.MediaInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        long j = 0;
        long j2 = 0;
        MediaInfo mediaInfo = null;
        o oVar = null;
        Boolean bool = null;
        long[] jArr = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        double d = 0.0d;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 2:
                    mediaInfo = (MediaInfo) y4.b.e(parcel, s, MediaInfo.CREATOR);
                    break;
                case 3:
                    oVar = (o) y4.b.e(parcel, s, o.CREATOR);
                    break;
                case 4:
                    bool = y4.b.n(parcel, s);
                    break;
                case 5:
                    j = y4.b.w(parcel, s);
                    break;
                case 6:
                    d = y4.b.o(parcel, s);
                    break;
                case 7:
                    jArr = y4.b.d(parcel, s);
                    break;
                case 8:
                    str = y4.b.f(parcel, s);
                    break;
                case 9:
                    str2 = y4.b.f(parcel, s);
                    break;
                case 10:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 11:
                    str4 = y4.b.f(parcel, s);
                    break;
                case 12:
                    str5 = y4.b.f(parcel, s);
                    break;
                case 13:
                    j2 = y4.b.w(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new l(mediaInfo, oVar, bool, j, d, jArr, str, str2, str3, str4, str5, j2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new l[i];
    }
}
