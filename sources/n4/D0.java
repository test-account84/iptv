package n4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaTrack;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        m mVar = null;
        List list = null;
        t tVar = null;
        String str3 = null;
        List list2 = null;
        List list3 = null;
        String str4 = null;
        u uVar = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        long j = 0;
        long j2 = 0;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 2:
                    str = y4.b.f(parcel, s);
                    break;
                case 3:
                    i = y4.b.u(parcel, s);
                    break;
                case 4:
                    str2 = y4.b.f(parcel, s);
                    break;
                case 5:
                    mVar = (m) y4.b.e(parcel, s, m.CREATOR);
                    break;
                case 6:
                    j = y4.b.w(parcel, s);
                    break;
                case 7:
                    list = y4.b.j(parcel, s, MediaTrack.CREATOR);
                    break;
                case 8:
                    tVar = (t) y4.b.e(parcel, s, t.CREATOR);
                    break;
                case 9:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 10:
                    list2 = y4.b.j(parcel, s, b.CREATOR);
                    break;
                case 11:
                    list3 = y4.b.j(parcel, s, a.CREATOR);
                    break;
                case 12:
                    str4 = y4.b.f(parcel, s);
                    break;
                case 13:
                    uVar = (u) y4.b.e(parcel, s, u.CREATOR);
                    break;
                case 14:
                    j2 = y4.b.w(parcel, s);
                    break;
                case 15:
                    str5 = y4.b.f(parcel, s);
                    break;
                case 16:
                    str6 = y4.b.f(parcel, s);
                    break;
                case 17:
                    str7 = y4.b.f(parcel, s);
                    break;
                case 18:
                    str8 = y4.b.f(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new MediaInfo(str, i, str2, mVar, j, list, tVar, str3, list2, list3, str4, uVar, j2, str5, str6, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MediaInfo[i];
    }
}
