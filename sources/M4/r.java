package M4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r {
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final Long h;
    public final Long i;
    public final Long j;
    public final Boolean k;

    public r(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        com.google.android.gms.common.internal.r.g(str);
        com.google.android.gms.common.internal.r.g(str2);
        com.google.android.gms.common.internal.r.a(j >= 0);
        com.google.android.gms.common.internal.r.a(j2 >= 0);
        com.google.android.gms.common.internal.r.a(j3 >= 0);
        com.google.android.gms.common.internal.r.a(j5 >= 0);
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = l;
        this.i = l2;
        this.j = l3;
        this.k = bool;
    }

    public final r a(Long l, Long l2, Boolean bool) {
        return new r(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, l, l2, bool);
    }

    public final r b(long j, long j2) {
        return new r(this.a, this.b, this.c, this.d, this.e, this.f, j, Long.valueOf(j2), this.i, this.j, this.k);
    }

    public final r c(long j) {
        return new r(this.a, this.b, this.c, this.d, this.e, j, this.g, this.h, this.i, this.j, this.k);
    }
}
