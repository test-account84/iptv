package F3;

import F3.k;
import O2.z0;
import android.net.Uri;
import java.util.Collections;
import java.util.List;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class j {
    public final long a;
    public final z0 b;
    public final y c;
    public final long d;
    public final List e;
    public final List f;
    public final List g;
    public final i h;

    public static class c extends j {
        public final Uri i;
        public final long j;
        public final String k;
        public final i l;
        public final m m;

        public c(long j, z0 z0Var, List list, k.e eVar, List list2, List list3, List list4, String str, long j2) {
            super(j, z0Var, list, eVar, list2, list3, list4, null);
            this.i = Uri.parse(((F3.b) list.get(0)).a);
            i c = eVar.c();
            this.l = c;
            this.k = str;
            this.j = j2;
            this.m = c != null ? null : new m(new i(null, 0L, j2));
        }

        public String a() {
            return this.k;
        }

        public E3.f b() {
            return this.m;
        }

        public i m() {
            return this.l;
        }
    }

    public j(long j, z0 z0Var, List list, k kVar, List list2, List list3, List list4) {
        d4.a.a(!list.isEmpty());
        this.a = j;
        this.b = z0Var;
        this.c = y.r(list);
        this.e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f = list3;
        this.g = list4;
        this.h = kVar.a(this);
        this.d = kVar.b();
    }

    public static j o(long j, z0 z0Var, List list, k kVar, List list2, List list3, List list4, String str) {
        if (kVar instanceof k.e) {
            return new c(j, z0Var, list, (k.e) kVar, list2, list3, list4, str, -1L);
        }
        if (kVar instanceof k.a) {
            return new b(j, z0Var, list, (k.a) kVar, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    public abstract String a();

    public abstract E3.f b();

    public abstract i m();

    public i n() {
        return this.h;
    }

    public /* synthetic */ j(long j, z0 z0Var, List list, k kVar, List list2, List list3, List list4, a aVar) {
        this(j, z0Var, list, kVar, list2, list3, list4);
    }

    public static class b extends j implements E3.f {
        public final k.a i;

        public b(long j, z0 z0Var, List list, k.a aVar, List list2, List list3, List list4) {
            super(j, z0Var, list, aVar, list2, list3, list4, null);
            this.i = aVar;
        }

        public String a() {
            return null;
        }

        public long c(long j) {
            return this.i.j(j);
        }

        public long d(long j, long j2) {
            return this.i.h(j, j2);
        }

        public long e(long j, long j2) {
            return this.i.d(j, j2);
        }

        public long f(long j, long j2) {
            return this.i.f(j, j2);
        }

        public i g(long j) {
            return this.i.k(this, j);
        }

        public long h(long j, long j2) {
            return this.i.i(j, j2);
        }

        public long i(long j) {
            return this.i.g(j);
        }

        public boolean j() {
            return this.i.l();
        }

        public long k() {
            return this.i.e();
        }

        public long l(long j, long j2) {
            return this.i.c(j, j2);
        }

        public i m() {
            return null;
        }

        public E3.f b() {
            return this;
        }
    }
}
