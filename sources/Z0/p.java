package Z0;

import d.D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class p {
    public static final String s = Q0.k.f("WorkSpec");
    public static final n.a t = new a();
    public String a;
    public Q0.t b;
    public String c;
    public String d;
    public androidx.work.b e;
    public androidx.work.b f;
    public long g;
    public long h;
    public long i;
    public Q0.b j;
    public int k;
    public Q0.a l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;
    public Q0.o r;

    public class a implements n.a {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List apply(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            D.a(it.next());
            throw null;
        }
    }

    public static class b {
        public String a;
        public Q0.t b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b != bVar.b) {
                return false;
            }
            return this.a.equals(bVar.a);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    public p(p pVar) {
        this.b = Q0.t.ENQUEUED;
        androidx.work.b bVar = androidx.work.b.c;
        this.e = bVar;
        this.f = bVar;
        this.j = Q0.b.i;
        this.l = Q0.a.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.r = Q0.o.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = pVar.a;
        this.c = pVar.c;
        this.b = pVar.b;
        this.d = pVar.d;
        this.e = new androidx.work.b(pVar.e);
        this.f = new androidx.work.b(pVar.f);
        this.g = pVar.g;
        this.h = pVar.h;
        this.i = pVar.i;
        this.j = new Q0.b(pVar.j);
        this.k = pVar.k;
        this.l = pVar.l;
        this.m = pVar.m;
        this.n = pVar.n;
        this.o = pVar.o;
        this.p = pVar.p;
        this.q = pVar.q;
        this.r = pVar.r;
    }

    public long a() {
        if (c()) {
            return this.n + Math.min(18000000L, this.l == Q0.a.LINEAR ? this.m * this.k : (long) Math.scalb(this.m, this.k - 1));
        }
        if (!d()) {
            long j = this.n;
            if (j == 0) {
                j = System.currentTimeMillis();
            }
            return j + this.g;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.n;
        long j3 = j2 == 0 ? currentTimeMillis + this.g : j2;
        long j4 = this.i;
        long j5 = this.h;
        if (j4 != j5) {
            return j3 + j5 + (j2 == 0 ? j4 * (-1) : 0L);
        }
        return j3 + (j2 != 0 ? j5 : 0L);
    }

    public boolean b() {
        return !Q0.b.i.equals(this.j);
    }

    public boolean c() {
        return this.b == Q0.t.ENQUEUED && this.k > 0;
    }

    public boolean d() {
        return this.h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.g != pVar.g || this.h != pVar.h || this.i != pVar.i || this.k != pVar.k || this.m != pVar.m || this.n != pVar.n || this.o != pVar.o || this.p != pVar.p || this.q != pVar.q || !this.a.equals(pVar.a) || this.b != pVar.b || !this.c.equals(pVar.c)) {
            return false;
        }
        String str = this.d;
        if (str == null ? pVar.d == null : str.equals(pVar.d)) {
            return this.e.equals(pVar.e) && this.f.equals(pVar.f) && this.j.equals(pVar.j) && this.l == pVar.l && this.r == pVar.r;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        long j = this.g;
        int i = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.h;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.i;
        int hashCode3 = (((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.j.hashCode()) * 31) + this.k) * 31) + this.l.hashCode()) * 31;
        long j4 = this.m;
        int i3 = (hashCode3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.n;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.o;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.p;
        return ((((i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.q ? 1 : 0)) * 31) + this.r.hashCode();
    }

    public String toString() {
        return "{WorkSpec: " + this.a + "}";
    }

    public p(String str, String str2) {
        this.b = Q0.t.ENQUEUED;
        androidx.work.b bVar = androidx.work.b.c;
        this.e = bVar;
        this.f = bVar;
        this.j = Q0.b.i;
        this.l = Q0.a.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.r = Q0.o.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = str;
        this.c = str2;
    }
}
