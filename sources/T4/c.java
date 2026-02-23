package t4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends y4.a {
    public static final Parcelable.Creator CREATOR = new y();
    public final String f;

    public c(String str) {
        this.f = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return a.k(this.f, ((c) obj).f);
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 2, this.f, false);
        y4.c.b(parcel, a);
    }

    public final String zza() {
        return this.f;
    }
}
