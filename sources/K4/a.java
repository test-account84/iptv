package k4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.List;
import y4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = b.B(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = b.s(parcel);
            switch (b.l(s)) {
                case 1:
                    i = b.u(parcel, s);
                    break;
                case 2:
                    str = b.f(parcel, s);
                    break;
                case 3:
                    str2 = b.f(parcel, s);
                    break;
                case 4:
                    str3 = b.f(parcel, s);
                    break;
                case 5:
                    str4 = b.f(parcel, s);
                    break;
                case 6:
                    uri = (Uri) b.e(parcel, s, Uri.CREATOR);
                    break;
                case 7:
                    str5 = b.f(parcel, s);
                    break;
                case 8:
                    j = b.w(parcel, s);
                    break;
                case 9:
                    str6 = b.f(parcel, s);
                    break;
                case 10:
                    list = b.j(parcel, s, Scope.CREATOR);
                    break;
                case 11:
                    str7 = b.f(parcel, s);
                    break;
                case 12:
                    str8 = b.f(parcel, s);
                    break;
                default:
                    b.A(parcel, s);
                    break;
            }
        }
        b.k(parcel, B);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
