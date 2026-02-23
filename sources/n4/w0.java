package n4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        String str = null;
        String str2 = null;
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 2:
                    f = y4.b.q(parcel, s);
                    break;
                case 3:
                    i = y4.b.u(parcel, s);
                    break;
                case 4:
                    i2 = y4.b.u(parcel, s);
                    break;
                case 5:
                    i3 = y4.b.u(parcel, s);
                    break;
                case 6:
                    i4 = y4.b.u(parcel, s);
                    break;
                case 7:
                    i5 = y4.b.u(parcel, s);
                    break;
                case 8:
                    i6 = y4.b.u(parcel, s);
                    break;
                case 9:
                    i7 = y4.b.u(parcel, s);
                    break;
                case 10:
                    str = y4.b.f(parcel, s);
                    break;
                case 11:
                    i8 = y4.b.u(parcel, s);
                    break;
                case 12:
                    i9 = y4.b.u(parcel, s);
                    break;
                case 13:
                    str2 = y4.b.f(parcel, s);
                    break;
                default:
                    y4.b.A(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new t(f, i, i2, i3, i4, i5, i6, i7, str, i8, i9, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new t[i];
    }
}
