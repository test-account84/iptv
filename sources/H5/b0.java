package H5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b0 implements G5.f {
    public static final Parcelable.Creator CREATOR = new e0();
    public final String a;
    public final String c;
    public Map d;
    public boolean e;

    public b0(String str, String str2, boolean z) {
        com.google.android.gms.common.internal.r.g(str);
        com.google.android.gms.common.internal.r.g(str2);
        this.a = str;
        this.c = str2;
        this.d = x.d(str2);
        this.e = z;
    }

    public final String a() {
        return this.a;
    }

    public final boolean c() {
        return this.e;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, a(), false);
        y4.c.t(parcel, 2, this.c, false);
        y4.c.c(parcel, 3, c());
        y4.c.b(parcel, a);
    }

    public b0(boolean z) {
        this.e = z;
        this.c = null;
        this.a = null;
        this.d = null;
    }
}
