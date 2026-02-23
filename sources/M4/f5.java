package M4;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f5 extends y4.a {
    public static final Parcelable.Creator CREATOR = new g5();
    public final String A;
    public final String B;
    public final String C;
    public final boolean D;
    public final long E;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final long j;
    public final long k;
    public final String l;
    public final boolean m;
    public final boolean n;
    public final long o;
    public final String p;
    public final long q;
    public final long r;
    public final int s;
    public final boolean t;
    public final boolean u;
    public final String v;
    public final Boolean w;
    public final long x;
    public final List y;
    public final String z;

    public f5(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, List list, String str8, String str9, String str10, String str11, boolean z5, long j7) {
        com.google.android.gms.common.internal.r.g(str);
        this.f = str;
        this.g = true == TextUtils.isEmpty(str2) ? null : str2;
        this.h = str3;
        this.o = j;
        this.i = str4;
        this.j = j2;
        this.k = j3;
        this.l = str5;
        this.m = z;
        this.n = z2;
        this.p = str6;
        this.q = 0L;
        this.r = j5;
        this.s = i;
        this.t = z3;
        this.u = z4;
        this.v = str7;
        this.w = bool;
        this.x = j6;
        this.y = list;
        this.z = null;
        this.A = str9;
        this.B = str10;
        this.C = str11;
        this.D = z5;
        this.E = j7;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.t(parcel, 2, this.f, false);
        y4.c.t(parcel, 3, this.g, false);
        y4.c.t(parcel, 4, this.h, false);
        y4.c.t(parcel, 5, this.i, false);
        y4.c.o(parcel, 6, this.j);
        y4.c.o(parcel, 7, this.k);
        y4.c.t(parcel, 8, this.l, false);
        y4.c.c(parcel, 9, this.m);
        y4.c.c(parcel, 10, this.n);
        y4.c.o(parcel, 11, this.o);
        y4.c.t(parcel, 12, this.p, false);
        y4.c.o(parcel, 13, this.q);
        y4.c.o(parcel, 14, this.r);
        y4.c.l(parcel, 15, this.s);
        y4.c.c(parcel, 16, this.t);
        y4.c.c(parcel, 18, this.u);
        y4.c.t(parcel, 19, this.v, false);
        y4.c.d(parcel, 21, this.w, false);
        y4.c.o(parcel, 22, this.x);
        y4.c.v(parcel, 23, this.y, false);
        y4.c.t(parcel, 24, this.z, false);
        y4.c.t(parcel, 25, this.A, false);
        y4.c.t(parcel, 26, this.B, false);
        y4.c.t(parcel, 27, this.C, false);
        y4.c.c(parcel, 28, this.D);
        y4.c.o(parcel, 29, this.E);
        y4.c.b(parcel, a);
    }

    public f5(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, List list, String str8, String str9, String str10, String str11, boolean z5, long j7) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.o = j3;
        this.i = str4;
        this.j = j;
        this.k = j2;
        this.l = str5;
        this.m = z;
        this.n = z2;
        this.p = str6;
        this.q = j4;
        this.r = j5;
        this.s = i;
        this.t = z3;
        this.u = z4;
        this.v = str7;
        this.w = bool;
        this.x = j6;
        this.y = list;
        this.z = str8;
        this.A = str9;
        this.B = str10;
        this.C = str11;
        this.D = z5;
        this.E = j7;
    }
}
