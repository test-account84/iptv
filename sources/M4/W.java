package M4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w implements Parcelable.Creator {
    public static void a(v vVar, Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 2, vVar.f, false);
        y4.c.r(parcel, 3, vVar.g, i, false);
        y4.c.t(parcel, 4, vVar.h, false);
        y4.c.o(parcel, 5, vVar.i);
        y4.c.b(parcel, a);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        long j = 0;
        String str = null;
        t tVar = null;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 2) {
                str = y4.b.f(parcel, s);
            } else if (l == 3) {
                tVar = (t) y4.b.e(parcel, s, t.CREATOR);
            } else if (l == 4) {
                str2 = y4.b.f(parcel, s);
            } else if (l != 5) {
                y4.b.A(parcel, s);
            } else {
                j = y4.b.w(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new v(str, tVar, str2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new v[i];
    }
}
