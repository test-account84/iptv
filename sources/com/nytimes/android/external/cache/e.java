package com.nytimes.android.external.cache;

import com.nytimes.android.external.cache.k;
import com.nytimes.android.external.cache.l;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class e {
    public static final u p = new a();
    public static final Logger q = Logger.getLogger(e.class.getName());
    public x f;
    public k.r g;
    public k.r h;
    public h l;
    public h m;
    public q n;
    public u o;
    public boolean a = true;
    public int b = -1;
    public int c = -1;
    public long d = -1;
    public long e = -1;
    public long i = -1;
    public long j = -1;
    public long k = -1;

    public class a extends u {
        public long a() {
            return 0L;
        }
    }

    public enum b implements q {
        INSTANCE;

        public void onRemoval(r rVar) {
        }
    }

    public enum c implements x {
        INSTANCE;

        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    public static e q() {
        return new e();
    }

    public d a() {
        c();
        b();
        return new k.m(this);
    }

    public final void b() {
        o.d(this.k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    public final void c() {
        boolean z;
        String str;
        if (this.f == null) {
            z = this.e == -1;
            str = "maximumWeight requires weigher";
        } else {
            if (!this.a) {
                if (this.e == -1) {
                    q.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
                    return;
                }
                return;
            }
            z = this.e != -1;
            str = "weigher requires maximumWeight";
        }
        o.d(z, str);
    }

    public int d() {
        int i = this.c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public long e() {
        long j = this.j;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public long f() {
        long j = this.i;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public int g() {
        int i = this.b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public h h() {
        return (h) l.a(this.l, i().defaultEquivalence());
    }

    public k.r i() {
        return (k.r) l.a(this.g, k.r.STRONG);
    }

    public long j() {
        if (this.i == 0 || this.j == 0) {
            return 0L;
        }
        return this.f == null ? this.d : this.e;
    }

    public long k() {
        long j = this.k;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public q l() {
        return (q) l.a(this.n, b.INSTANCE);
    }

    public u m(boolean z) {
        u uVar = this.o;
        return uVar != null ? uVar : z ? u.b() : p;
    }

    public h n() {
        return (h) l.a(this.m, o().defaultEquivalence());
    }

    public k.r o() {
        return (k.r) l.a(this.h, k.r.STRONG);
    }

    public x p() {
        return (x) l.a(this.f, c.INSTANCE);
    }

    public String toString() {
        l.b b2 = l.b(this);
        int i = this.b;
        if (i != -1) {
            b2.a("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            b2.a("concurrencyLevel", i2);
        }
        long j = this.d;
        if (j != -1) {
            b2.b("maximumSize", j);
        }
        long j2 = this.e;
        if (j2 != -1) {
            b2.b("maximumWeight", j2);
        }
        if (this.i != -1) {
            b2.c("expireAfterWrite", this.i + "ns");
        }
        if (this.j != -1) {
            b2.c("expireAfterAccess", this.j + "ns");
        }
        k.r rVar = this.g;
        if (rVar != null) {
            b2.c("keyStrength", com.nytimes.android.external.cache.c.b(rVar.toString()));
        }
        k.r rVar2 = this.h;
        if (rVar2 != null) {
            b2.c("valueStrength", com.nytimes.android.external.cache.c.b(rVar2.toString()));
        }
        if (this.l != null) {
            b2.g("keyEquivalence");
        }
        if (this.m != null) {
            b2.g("valueEquivalence");
        }
        if (this.n != null) {
            b2.g("removalListener");
        }
        return b2.toString();
    }
}
