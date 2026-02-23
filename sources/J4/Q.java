package J4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class q extends y4.a {
    public static final Parcelable.Creator CREATOR = new S();
    public final List f;
    public final int g;

    public q(List list, int i) {
        this.f = list;
        this.g = i;
    }

    public int H() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return com.google.android.gms.common.internal.q.b(this.f, qVar.f) && this.g == qVar.g;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f, Integer.valueOf(this.g));
    }

    public void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.common.internal.r.m(parcel);
        int a = y4.c.a(parcel);
        y4.c.x(parcel, 1, this.f, false);
        y4.c.l(parcel, 2, H());
        y4.c.b(parcel, a);
    }
}
