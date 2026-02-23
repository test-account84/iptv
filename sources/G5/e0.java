package G5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.firebase-auth-api.zzagt;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e0 implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        zzagt zzagtVar = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 1:
                    str = y4.b.f(parcel, s);
                    break;
                case 2:
                    str2 = y4.b.f(parcel, s);
                    break;
                case 3:
                    str3 = y4.b.f(parcel, s);
                    break;
                case 4:
                    zzagtVar = (zzagt) y4.b.e(parcel, s, zzagt.CREATOR);
                    break;
                case 5:
                    str4 = y4.b.f(parcel, s);
                    break;
                case 6:
                    str5 = y4.b.f(parcel, s);
                    break;
                case 7:
                    str6 = y4.b.f(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new f0(str, str2, str3, zzagtVar, str4, str5, str6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new f0[i];
    }
}
