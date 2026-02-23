package J4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = "";
        ArrayList arrayList = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            int l = y4.b.l(s);
            if (l == 1) {
                arrayList = y4.b.j(parcel, s, zzbe.CREATOR);
            } else if (l == 2) {
                i = y4.b.u(parcel, s);
            } else if (l == 3) {
                str = y4.b.f(parcel, s);
            } else if (l != 4) {
                y4.b.A(parcel, s);
            } else {
                str2 = y4.b.f(parcel, s);
            }
        }
        y4.b.k(parcel, B);
        return new h(arrayList, i, str, str2);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new h[i];
    }
}
