package n4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h extends y4.a {
    public static final Parcelable.Creator CREATOR = new x();
    public final String f;
    public final String g;

    public h(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public String H() {
        return this.f;
    }

    public String I() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return com.google.android.gms.common.internal.q.b(this.f, hVar.f) && com.google.android.gms.common.internal.q.b(this.g, hVar.g);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f, this.g);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, H(), false);
        y4.c.t(parcel, 2, I(), false);
        y4.c.b(parcel, a);
    }
}
