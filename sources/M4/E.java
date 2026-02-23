package M4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        V4 v4 = null;
        String str3 = null;
        v vVar = null;
        v vVar2 = null;
        v vVar3 = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
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
                    v4 = (V4) y4.b.e(parcel, s, V4.CREATOR);
                    break;
                case 5:
                    j = y4.b.w(parcel, s);
                    break;
                case 6:
                    z = y4.b.m(parcel, s);
                    break;
                case 7:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 8:
                    vVar = (v) y4.b.e(parcel, s, v.CREATOR);
                    break;
                case 9:
                    j2 = y4.b.w(parcel, s);
                    break;
                case 10:
                    vVar2 = (v) y4.b.e(parcel, s, v.CREATOR);
                    break;
                case 11:
                    j3 = y4.b.w(parcel, s);
                    break;
                case 12:
                    vVar3 = (v) y4.b.e(parcel, s, v.CREATOR);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new d(str, str2, v4, j, z, str3, vVar, j2, vVar2, j3, vVar3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new d[i];
    }
}
