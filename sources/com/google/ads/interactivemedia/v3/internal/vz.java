package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class vz extends wb implements Comparable {
    private final int e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final boolean m;

    public vz(int i, bf bfVar, int i2, vu vuVar, int i3, String str) {
        int i4;
        super(i, bfVar, i2);
        int i5 = 0;
        this.f = wd.j(i3, false);
        int i6 = this.d.d;
        int i7 = vuVar.v;
        this.g = 1 == (i6 & 1);
        this.h = (i6 & 2) != 0;
        avo p = vuVar.t.isEmpty() ? avo.p("") : vuVar.t;
        int i8 = 0;
        while (true) {
            if (i8 >= p.size()) {
                i8 = Integer.MAX_VALUE;
                i4 = 0;
                break;
            } else {
                i4 = wd.b(this.d, (String) p.get(i8), false);
                if (i4 > 0) {
                    break;
                } else {
                    i8++;
                }
            }
        }
        this.i = i8;
        this.j = i4;
        int a = wd.a(this.d.e, vuVar.u);
        this.k = a;
        this.m = (this.d.e & 1088) != 0;
        int b = wd.b(this.d, str, wd.e(str) == null);
        this.l = b;
        boolean z = i4 > 0 || (vuVar.t.isEmpty() && a > 0) || this.g || (this.h && b > 0);
        if (wd.j(i3, vuVar.M) && z) {
            i5 = 1;
        }
        this.e = i5;
    }

    public static avo d(int i, bf bfVar, vu vuVar, int[] iArr, String str) {
        avk j = avo.j();
        for (int i2 = 0; i2 < bfVar.a; i2++) {
            j.g(new vz(i, bfVar, i2, vuVar, iArr[i2], str));
        }
        return j.f();
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(vz vzVar) {
        aut b = aut.j().d(this.f, vzVar.f).c(Integer.valueOf(this.i), Integer.valueOf(vzVar.i), awy.c().a()).b(this.j, vzVar.j).b(this.k, vzVar.k).d(this.g, vzVar.g).c(Boolean.valueOf(this.h), Boolean.valueOf(vzVar.h), this.j == 0 ? awy.c() : awy.c().a()).b(this.l, vzVar.l);
        if (this.k == 0) {
            b = b.e(this.m, vzVar.m);
        }
        return b.a();
    }

    public final int b() {
        return this.e;
    }

    public final /* bridge */ /* synthetic */ boolean c(wb wbVar) {
        return false;
    }
}
