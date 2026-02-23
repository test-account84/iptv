package H5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.firebase-auth-api.zzafn;
import com.google.android.gms.internal.firebase-auth-api.zzafq;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        zzafn zzafnVar = null;
        f0 f0Var = null;
        String str = null;
        String str2 = null;
        List list = null;
        List list2 = null;
        String str3 = null;
        Boolean bool = null;
        d dVar = null;
        G5.f0 f0Var2 = null;
        z zVar = null;
        ArrayList arrayList = null;
        boolean z = false;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 1:
                    zzafnVar = (zzafn) y4.b.e(parcel, s, zzafn.CREATOR);
                    break;
                case 2:
                    f0Var = (f0) y4.b.e(parcel, s, f0.CREATOR);
                    break;
                case 3:
                    str = y4.b.f(parcel, s);
                    break;
                case 4:
                    str2 = y4.b.f(parcel, s);
                    break;
                case 5:
                    list = y4.b.j(parcel, s, f0.CREATOR);
                    break;
                case 6:
                    list2 = y4.b.h(parcel, s);
                    break;
                case 7:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 8:
                    bool = y4.b.n(parcel, s);
                    break;
                case 9:
                    dVar = (d) y4.b.e(parcel, s, d.CREATOR);
                    break;
                case 10:
                    z = y4.b.m(parcel, s);
                    break;
                case 11:
                    f0Var2 = (G5.f0) y4.b.e(parcel, s, G5.f0.CREATOR);
                    break;
                case 12:
                    zVar = (z) y4.b.e(parcel, s, z.CREATOR);
                    break;
                case 13:
                    arrayList = y4.b.j(parcel, s, zzafq.CREATOR);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new b(zzafnVar, f0Var, str, str2, list, list2, str3, bool, dVar, z, f0Var2, zVar, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
