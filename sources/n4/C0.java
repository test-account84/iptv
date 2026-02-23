package n4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.MediaError;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int s;
        int B = y4.b.B(parcel);
        String str = null;
        long j = 0;
        String str2 = null;
        Integer num = null;
        String str3 = null;
        while (true) {
            long j2 = j;
            while (parcel.dataPosition() < B) {
                s = y4.b.s(parcel);
                int l = y4.b.l(s);
                if (l == 2) {
                    str2 = y4.b.f(parcel, s);
                } else if (l != 3) {
                    if (l == 4) {
                        num = y4.b.v(parcel, s);
                    } else if (l == 5) {
                        str3 = y4.b.f(parcel, s);
                    } else if (l != 6) {
                        y4.b.A(parcel, s);
                    } else {
                        str = y4.b.f(parcel, s);
                    }
                }
            }
            y4.b.k(parcel, B);
            return new MediaError(str2, j2, num, str3, t4.a.a(str));
            j = y4.b.w(parcel, s);
        }
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MediaError[i];
    }
}
