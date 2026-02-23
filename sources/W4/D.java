package w4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d extends y4.a {
    public static final Parcelable.Creator CREATOR = new t();
    public final String f;
    public final int g;
    public final long h;

    public d(String str, int i, long j) {
        this.f = str;
        this.g = i;
        this.h = j;
    }

    public long H() {
        long j = this.h;
        return j == -1 ? this.g : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (((getName() != null && getName().equals(dVar.getName())) || (getName() == null && dVar.getName() == null)) && H() == dVar.H()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.f;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(getName(), Long.valueOf(H()));
    }

    public final String toString() {
        q.a d = com.google.android.gms.common.internal.q.d(this);
        d.a("name", getName());
        d.a("version", Long.valueOf(H()));
        return d.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, getName(), false);
        y4.c.l(parcel, 2, this.g);
        y4.c.o(parcel, 3, H());
        y4.c.b(parcel, a);
    }

    public d(String str, long j) {
        this.f = str;
        this.h = j;
        this.g = -1;
    }
}
