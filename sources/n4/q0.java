package n4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.MediaInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        MediaInfo mediaInfo = null;
        long[] jArr = null;
        String str = null;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 2:
                    mediaInfo = (MediaInfo) y4.b.e(parcel, s, MediaInfo.CREATOR);
                    break;
                case 3:
                    i = y4.b.u(parcel, s);
                    break;
                case 4:
                    z = y4.b.m(parcel, s);
                    break;
                case 5:
                    d = y4.b.o(parcel, s);
                    break;
                case 6:
                    d2 = y4.b.o(parcel, s);
                    break;
                case 7:
                    d3 = y4.b.o(parcel, s);
                    break;
                case 8:
                    jArr = y4.b.d(parcel, s);
                    break;
                case 9:
                    str = y4.b.f(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new p(mediaInfo, i, z, d, d2, d3, jArr, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new p[i];
    }
}
