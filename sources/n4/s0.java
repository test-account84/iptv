package n4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.MediaInfo;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        MediaInfo mediaInfo = null;
        long[] jArr = null;
        String str = null;
        List list = null;
        c cVar = null;
        v vVar = null;
        j jVar = null;
        o oVar = null;
        double d = 0.0d;
        double d2 = 0.0d;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 2:
                    mediaInfo = (MediaInfo) y4.b.e(parcel, s, MediaInfo.CREATOR);
                    break;
                case 3:
                    j = y4.b.w(parcel, s);
                    break;
                case 4:
                    i = y4.b.u(parcel, s);
                    break;
                case 5:
                    d = y4.b.o(parcel, s);
                    break;
                case 6:
                    i2 = y4.b.u(parcel, s);
                    break;
                case 7:
                    i3 = y4.b.u(parcel, s);
                    break;
                case 8:
                    j2 = y4.b.w(parcel, s);
                    break;
                case 9:
                    j3 = y4.b.w(parcel, s);
                    break;
                case 10:
                    d2 = y4.b.o(parcel, s);
                    break;
                case 11:
                    z = y4.b.m(parcel, s);
                    break;
                case 12:
                    jArr = y4.b.d(parcel, s);
                    break;
                case 13:
                    i4 = y4.b.u(parcel, s);
                    break;
                case 14:
                    i5 = y4.b.u(parcel, s);
                    break;
                case 15:
                    str = y4.b.f(parcel, s);
                    break;
                case 16:
                    i6 = y4.b.u(parcel, s);
                    break;
                case 17:
                    list = y4.b.j(parcel, s, p.CREATOR);
                    break;
                case 18:
                    z2 = y4.b.m(parcel, s);
                    break;
                case 19:
                    cVar = (c) y4.b.e(parcel, s, c.CREATOR);
                    break;
                case 20:
                    vVar = (v) y4.b.e(parcel, s, v.CREATOR);
                    break;
                case 21:
                    jVar = (j) y4.b.e(parcel, s, j.CREATOR);
                    break;
                case 22:
                    oVar = (o) y4.b.e(parcel, s, o.CREATOR);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new r(mediaInfo, j, i, d, i2, i3, j2, j3, d2, z, jArr, i4, i5, str, i6, list, z2, cVar, vVar, jVar, oVar);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new r[i];
    }
}
