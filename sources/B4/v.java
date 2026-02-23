package b4;

import android.content.Context;
import android.os.Handler;
import b4.f;
import d4.k0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v implements f, S {
    public static final s5.y p = s5.y.E(4400000L, 3200000L, 2300000L, 1600000L, 810000L);
    public static final s5.y q = s5.y.E(1400000L, 990000L, 730000L, 510000L, 230000L);
    public static final s5.y r = s5.y.E(2100000L, 1400000L, 1000000L, 890000L, 640000L);
    public static final s5.y s = s5.y.E(2600000L, 1700000L, 1300000L, 1000000L, 700000L);
    public static final s5.y t = s5.y.E(5700000L, 3700000L, 2300000L, 1700000L, 990000L);
    public static final s5.y u = s5.y.E(2800000L, 1800000L, 1400000L, 1100000L, 870000L);
    public static v v;
    public final s5.A a;
    public final f.a.a b;
    public final O c;
    public final d4.e d;
    public final boolean e;
    public int f;
    public long g;
    public long h;
    public int i;
    public long j;
    public long k;
    public long l;
    public long m;
    public boolean n;
    public int o;

    public static final class b {
        public final Context a;
        public Map b;
        public int c;
        public d4.e d;
        public boolean e;

        public b(Context context) {
            this.a = context == null ? null : context.getApplicationContext();
            this.b = b(k0.P(context));
            this.c = 2000;
            this.d = d4.e.a;
            this.e = true;
        }

        public static Map b(String str) {
            int[] k = v.k(str);
            HashMap hashMap = new HashMap(8);
            hashMap.put(0, 1000000L);
            s5.y yVar = v.p;
            hashMap.put(2, (Long) yVar.get(k[0]));
            hashMap.put(3, (Long) v.q.get(k[1]));
            hashMap.put(4, (Long) v.r.get(k[2]));
            hashMap.put(5, (Long) v.s.get(k[3]));
            hashMap.put(10, (Long) v.t.get(k[4]));
            hashMap.put(9, (Long) v.u.get(k[5]));
            hashMap.put(7, (Long) yVar.get(k[0]));
            return hashMap;
        }

        public v a() {
            return new v(this.a, this.b, this.c, this.d, this.e, null);
        }
    }

    public v(Context context, Map map, int i, d4.e eVar, boolean z) {
        this.a = s5.A.d(map);
        this.b = new f.a.a();
        this.c = new O(i);
        this.d = eVar;
        this.e = z;
        if (context == null) {
            this.i = 0;
            this.l = m(0);
            return;
        }
        d4.I d = d4.I.d(context);
        int f = d.f();
        this.i = f;
        this.l = m(f);
        d.i(new u(this));
    }

    public static /* synthetic */ void j(v vVar, int i) {
        vVar.q(i);
    }

    public static /* synthetic */ int[] k(String str) {
        return l(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] l(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 8104
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.v.l(java.lang.String):int[]");
    }

    public static synchronized v n(Context context) {
        v vVar;
        synchronized (v.class) {
            try {
                if (v == null) {
                    v = new b(context).a();
                }
                vVar = v;
            } catch (Throwable th) {
                throw th;
            }
        }
        return vVar;
    }

    public static boolean o(s sVar, boolean z) {
        return z && !sVar.d(8);
    }

    public synchronized void a(o oVar, s sVar, boolean z) {
        try {
            if (o(sVar, z)) {
                if (this.f == 0) {
                    this.g = this.d.b();
                }
                this.f++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public /* synthetic */ long b() {
        return d.a(this);
    }

    public synchronized long e() {
        return this.l;
    }

    public synchronized void f(o oVar, s sVar, boolean z, int i) {
        if (o(sVar, z)) {
            this.h += i;
        }
    }

    public void g(Handler handler, f.a aVar) {
        d4.a.e(handler);
        d4.a.e(aVar);
        this.b.b(handler, aVar);
    }

    public void h(f.a aVar) {
        this.b.e(aVar);
    }

    public synchronized void i(o oVar, s sVar, boolean z) {
        try {
            if (o(sVar, z)) {
                d4.a.g(this.f > 0);
                long b2 = this.d.b();
                int i = (int) (b2 - this.g);
                this.j += i;
                long j = this.k;
                long j2 = this.h;
                this.k = j + j2;
                if (i > 0) {
                    this.c.c((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                    if (this.j >= 2000 || this.k >= 524288) {
                        this.l = (long) this.c.f(0.5f);
                    }
                    p(i, this.h, this.l);
                    this.g = b2;
                    this.h = 0L;
                }
                this.f--;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final long m(int i) {
        Long l = (Long) this.a.get(Integer.valueOf(i));
        if (l == null) {
            l = (Long) this.a.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    public final void p(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.m) {
            return;
        }
        this.m = j2;
        this.b.c(i, j, j2);
    }

    public final synchronized void q(int i) {
        int i2 = this.i;
        if (i2 == 0 || this.e) {
            if (this.n) {
                i = this.o;
            }
            if (i2 == i) {
                return;
            }
            this.i = i;
            if (i != 1 && i != 0 && i != 8) {
                this.l = m(i);
                long b2 = this.d.b();
                p(this.f > 0 ? (int) (b2 - this.g) : 0, this.h, this.l);
                this.g = b2;
                this.h = 0L;
                this.k = 0L;
                this.j = 0L;
                this.c.i();
            }
        }
    }

    public /* synthetic */ v(Context context, Map map, int i, d4.e eVar, boolean z, a aVar) {
        this(context, map, i, eVar, z);
    }

    public S d() {
        return this;
    }

    public void c(o oVar, s sVar, boolean z) {
    }
}
