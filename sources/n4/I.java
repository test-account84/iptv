package n4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class i extends y4.a {
    public static final Parcelable.Creator CREATOR = new b0();
    public boolean f;
    public String g;
    public boolean h;
    public h i;

    public i() {
        this(false, t4.a.h(Locale.getDefault()), false, null);
    }

    public boolean H() {
        return this.h;
    }

    public h I() {
        return this.i;
    }

    public String J() {
        return this.g;
    }

    public boolean K() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f == iVar.f && t4.a.k(this.g, iVar.g) && this.h == iVar.h && t4.a.k(this.i, iVar.i);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Boolean.valueOf(this.f), this.g, Boolean.valueOf(this.h), this.i);
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s, androidReceiverCompatible: %b)", new Object[]{Boolean.valueOf(this.f), this.g, Boolean.valueOf(this.h)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.c(parcel, 2, K());
        y4.c.t(parcel, 3, J(), false);
        y4.c.c(parcel, 4, H());
        y4.c.r(parcel, 5, I(), i, false);
        y4.c.b(parcel, a);
    }

    public i(boolean z, String str, boolean z2, h hVar) {
        this.f = z;
        this.g = str;
        this.h = z2;
        this.i = hVar;
    }
}
