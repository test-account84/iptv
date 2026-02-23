package G5;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d extends y4.a {
    public static final Parcelable.Creator CREATOR = new c0();
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final boolean j;
    public final String k;
    public final boolean l;
    public String m;
    public int n;
    public String o;

    public d(String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, String str6, int i, String str7) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = z;
        this.k = str5;
        this.l = z2;
        this.m = str6;
        this.n = i;
        this.o = str7;
    }

    public boolean H() {
        return this.l;
    }

    public boolean I() {
        return this.j;
    }

    public String J() {
        return this.k;
    }

    public String K() {
        return this.i;
    }

    public String L() {
        return this.g;
    }

    public String M() {
        return this.f;
    }

    public final int N() {
        return this.n;
    }

    public final void O(int i) {
        this.n = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 1, M(), false);
        y4.c.t(parcel, 2, L(), false);
        y4.c.t(parcel, 3, this.h, false);
        y4.c.t(parcel, 4, K(), false);
        y4.c.c(parcel, 5, I());
        y4.c.t(parcel, 6, J(), false);
        y4.c.c(parcel, 7, H());
        y4.c.t(parcel, 8, this.m, false);
        y4.c.l(parcel, 9, this.n);
        y4.c.t(parcel, 10, this.o, false);
        y4.c.b(parcel, a);
    }

    public final String zzc() {
        return this.o;
    }

    public final String zzd() {
        return this.h;
    }

    public final String zze() {
        return this.m;
    }
}
