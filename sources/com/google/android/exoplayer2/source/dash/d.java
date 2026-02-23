package com.google.android.exoplayer2.source.dash;

import B3.X;
import D3.f;
import O2.A0;
import O2.l1;
import O2.z0;
import android.os.Handler;
import android.os.Message;
import b4.k;
import d3.v;
import d3.w;
import d4.M;
import d4.k0;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import q3.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements Handler.Callback {
    public final b4.b a;
    public final b c;
    public F3.c g;
    public long h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final TreeMap f = new TreeMap();
    public final Handler e = k0.y(this);
    public final s3.b d = new s3.b();

    public static final class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    public interface b {
        void a(long j);

        void b();
    }

    public final class c implements w {
        public final X a;
        public final A0 b = new A0();
        public final e c = new e();
        public long d = -9223372036854775807L;

        public c(b4.b bVar) {
            this.a = X.l(bVar);
        }

        public /* synthetic */ int a(k kVar, int i, boolean z) {
            return v.a(this, kVar, i, z);
        }

        public /* synthetic */ void b(M m, int i) {
            v.b(this, m, i);
        }

        public void c(M m, int i, int i2) {
            this.a.b(m, i);
        }

        public void d(z0 z0Var) {
            this.a.d(z0Var);
        }

        public int e(k kVar, int i, boolean z, int i2) {
            return this.a.a(kVar, i, z);
        }

        public void f(long j, int i, int i2, int i3, w.a aVar) {
            this.a.f(j, i, i2, i3, aVar);
            l();
        }

        public final e g() {
            this.c.clear();
            if (this.a.S(this.b, this.c, 0, false) != -4) {
                return null;
            }
            this.c.i();
            return this.c;
        }

        public boolean h(long j) {
            return d.this.j(j);
        }

        public void i(f fVar) {
            long j = this.d;
            if (j == -9223372036854775807L || fVar.i > j) {
                this.d = fVar.i;
            }
            d.this.m(fVar);
        }

        public boolean j(f fVar) {
            long j = this.d;
            return d.this.n(j != -9223372036854775807L && j < fVar.h);
        }

        public final void k(long j, long j2) {
            d.d(d.this).sendMessage(d.d(d.this).obtainMessage(1, new a(j, j2)));
        }

        public final void l() {
            while (this.a.K(false)) {
                e g = g();
                if (g != null) {
                    long j = g.f;
                    q3.a a = d.a(d.this).a(g);
                    if (a != null) {
                        s3.a aVar = (s3.a) a.e(0);
                        if (d.b(aVar.a, aVar.c)) {
                            m(j, aVar);
                        }
                    }
                }
            }
            this.a.s();
        }

        public final void m(long j, s3.a aVar) {
            long c = d.c(aVar);
            if (c == -9223372036854775807L) {
                return;
            }
            k(j, c);
        }

        public void n() {
            this.a.T();
        }
    }

    public d(F3.c cVar, b bVar, b4.b bVar2) {
        this.g = cVar;
        this.c = bVar;
        this.a = bVar2;
    }

    public static /* synthetic */ s3.b a(d dVar) {
        return dVar.d;
    }

    public static /* synthetic */ boolean b(String str, String str2) {
        return h(str, str2);
    }

    public static /* synthetic */ long c(s3.a aVar) {
        return f(aVar);
    }

    public static /* synthetic */ Handler d(d dVar) {
        return dVar.e;
    }

    public static long f(s3.a aVar) {
        try {
            return k0.W0(k0.E(aVar.f));
        } catch (l1 unused) {
            return -9223372036854775807L;
        }
    }

    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    public final Map.Entry e(long j) {
        return this.f.ceilingEntry(Long.valueOf(j));
    }

    public final void g(long j, long j2) {
        Long l = (Long) this.f.get(Long.valueOf(j2));
        if (l != null && l.longValue() <= j) {
            return;
        }
        this.f.put(Long.valueOf(j2), Long.valueOf(j));
    }

    public boolean handleMessage(Message message) {
        if (this.k) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.a, aVar.b);
        return true;
    }

    public final void i() {
        if (this.i) {
            this.j = true;
            this.i = false;
            this.c.b();
        }
    }

    public boolean j(long j) {
        F3.c cVar = this.g;
        boolean z = false;
        if (!cVar.d) {
            return false;
        }
        if (this.j) {
            return true;
        }
        Map.Entry e = e(cVar.h);
        if (e != null && ((Long) e.getValue()).longValue() < j) {
            this.h = ((Long) e.getKey()).longValue();
            l();
            z = true;
        }
        if (z) {
            i();
        }
        return z;
    }

    public c k() {
        return new c(this.a);
    }

    public final void l() {
        this.c.a(this.h);
    }

    public void m(f fVar) {
        this.i = true;
    }

    public boolean n(boolean z) {
        if (!this.g.d) {
            return false;
        }
        if (this.j) {
            return true;
        }
        if (!z) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.k = true;
        this.e.removeCallbacksAndMessages((Object) null);
    }

    public final void p() {
        Iterator it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            if (((Long) ((Map.Entry) it.next()).getKey()).longValue() < this.g.h) {
                it.remove();
            }
        }
    }

    public void q(F3.c cVar) {
        this.j = false;
        this.h = -9223372036854775807L;
        this.g = cVar;
        p();
    }
}
