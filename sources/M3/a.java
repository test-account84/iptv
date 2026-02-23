package m3;

import com.google.android.exoplayer2.extractor.g;
import d3.l;
import d3.u;
import d4.k0;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements g {
    public final f a;
    public final long b;
    public final long c;
    public final i d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    public final class b implements com.google.android.exoplayer2.extractor.g {
        public b() {
        }

        public g.a e(long j) {
            return new g.a(new u(j, k0.s((a.e(a.this) + BigInteger.valueOf(a.d(a.this).c(j)).multiply(BigInteger.valueOf(a.g(a.this) - a.e(a.this))).divide(BigInteger.valueOf(a.f(a.this))).longValue()) - 30000, a.e(a.this), a.g(a.this) - 1)));
        }

        public boolean g() {
            return true;
        }

        public long i() {
            return a.d(a.this).b(a.f(a.this));
        }

        public /* synthetic */ b(a aVar, a aVar2) {
            this();
        }
    }

    public a(i iVar, long j, long j2, long j3, long j4, boolean z) {
        d4.a.a(j >= 0 && j2 > j);
        this.d = iVar;
        this.b = j;
        this.c = j2;
        if (j3 == j2 - j || z) {
            this.f = j4;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.a = new f();
    }

    public static /* synthetic */ i d(a aVar) {
        return aVar.d;
    }

    public static /* synthetic */ long e(a aVar) {
        return aVar.b;
    }

    public static /* synthetic */ long f(a aVar) {
        return aVar.f;
    }

    public static /* synthetic */ long g(a aVar) {
        return aVar.c;
    }

    public long a(d3.j jVar) {
        int i = this.e;
        if (i == 0) {
            long position = jVar.getPosition();
            this.g = position;
            this.e = 1;
            long j = this.c - 65307;
            if (j > position) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long i2 = i(jVar);
                if (i2 != -1) {
                    return i2;
                }
                this.e = 3;
            } else if (i != 3) {
                if (i == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            k(jVar);
            this.e = 4;
            return -(this.k + 2);
        }
        this.f = j(jVar);
        this.e = 4;
        return this.g;
    }

    public void c(long j) {
        this.h = k0.s(j, 0L, this.f - 1);
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b b() {
        if (this.f != 0) {
            return new b(this, null);
        }
        return null;
    }

    public final long i(d3.j jVar) {
        if (this.i == this.j) {
            return -1L;
        }
        long position = jVar.getPosition();
        if (!this.a.d(jVar, this.j)) {
            long j = this.i;
            if (j != position) {
                return j;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.a.a(jVar, false);
        jVar.f();
        long j2 = this.h;
        f fVar = this.a;
        long j3 = fVar.c;
        long j4 = j2 - j3;
        int i = fVar.h + fVar.i;
        if (0 <= j4 && j4 < 72000) {
            return -1L;
        }
        if (j4 < 0) {
            this.j = position;
            this.l = j3;
        } else {
            this.i = jVar.getPosition() + i;
            this.k = this.a.c;
        }
        long j5 = this.j;
        long j6 = this.i;
        if (j5 - j6 < 100000) {
            this.j = j6;
            return j6;
        }
        long position2 = jVar.getPosition() - (i * (j4 <= 0 ? 2L : 1L));
        long j7 = this.j;
        long j8 = this.i;
        return k0.s(position2 + ((j4 * (j7 - j8)) / (this.l - this.k)), j8, j7 - 1);
    }

    public long j(d3.j jVar) {
        long j;
        f fVar;
        this.a.b();
        if (!this.a.c(jVar)) {
            throw new EOFException();
        }
        this.a.a(jVar, false);
        f fVar2 = this.a;
        jVar.q(fVar2.h + fVar2.i);
        do {
            j = this.a.c;
            f fVar3 = this.a;
            if ((fVar3.b & 4) == 4 || !fVar3.c(jVar) || jVar.getPosition() >= this.c || !this.a.a(jVar, true)) {
                break;
            }
            fVar = this.a;
        } while (l.e(jVar, fVar.h + fVar.i));
        return j;
    }

    public final void k(d3.j jVar) {
        while (true) {
            this.a.c(jVar);
            this.a.a(jVar, false);
            f fVar = this.a;
            if (fVar.c > this.h) {
                jVar.f();
                return;
            } else {
                jVar.q(fVar.h + fVar.i);
                this.i = jVar.getPosition();
                this.k = this.a.c;
            }
        }
    }
}
