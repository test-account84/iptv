package M4;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d extends y4.a {
    public static final Parcelable.Creator CREATOR = new e();
    public String f;
    public String g;
    public V4 h;
    public long i;
    public boolean j;
    public String k;
    public final v l;
    public long m;
    public v n;
    public final long o;
    public final v p;

    public d(d dVar) {
        com.google.android.gms.common.internal.r.m(dVar);
        this.f = dVar.f;
        this.g = dVar.g;
        this.h = dVar.h;
        this.i = dVar.i;
        this.j = dVar.j;
        this.k = dVar.k;
        this.l = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.o = dVar.o;
        this.p = dVar.p;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 2, this.f, false);
        y4.c.t(parcel, 3, this.g, false);
        y4.c.r(parcel, 4, this.h, i, false);
        y4.c.o(parcel, 5, this.i);
        y4.c.c(parcel, 6, this.j);
        y4.c.t(parcel, 7, this.k, false);
        y4.c.r(parcel, 8, this.l, i, false);
        y4.c.o(parcel, 9, this.m);
        y4.c.r(parcel, 10, this.n, i, false);
        y4.c.o(parcel, 11, this.o);
        y4.c.r(parcel, 12, this.p, i, false);
        y4.c.b(parcel, a);
    }

    public d(String str, String str2, V4 v4, long j, boolean z, String str3, v vVar, long j2, v vVar2, long j3, v vVar3) {
        this.f = str;
        this.g = str2;
        this.h = v4;
        this.i = j;
        this.j = z;
        this.k = str3;
        this.l = vVar;
        this.m = j2;
        this.n = vVar2;
        this.o = j3;
        this.p = vVar3;
    }
}
