package c4;

import java.io.IOException;
import java.io.InterruptedIOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k {
    public final c a;
    public final c4.a b;
    public final b4.s c;
    public final String d;
    public final byte[] e;
    public final a f;
    public long g;
    public long h;
    public long i;
    public volatile boolean j;

    public interface a {
        void a(long j, long j2, long j3);
    }

    public k(c cVar, b4.s sVar, byte[] bArr, a aVar) {
        this.a = cVar;
        this.b = cVar.t();
        this.c = sVar;
        this.e = bArr == null ? new byte[131072] : bArr;
        this.f = aVar;
        this.d = cVar.u().a(sVar);
        this.g = sVar.g;
    }

    public void a() {
        long j;
        g();
        c4.a aVar = this.b;
        String str = this.d;
        b4.s sVar = this.c;
        this.i = aVar.c(str, sVar.g, sVar.h);
        b4.s sVar2 = this.c;
        long j2 = sVar2.h;
        if (j2 != -1) {
            this.h = sVar2.g + j2;
        } else {
            long a2 = n.a(this.b.b(this.d));
            if (a2 == -1) {
                a2 = -1;
            }
            this.h = a2;
        }
        a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.a(c(), this.i, 0L);
        }
        while (true) {
            long j3 = this.h;
            if (j3 != -1 && this.g >= j3) {
                return;
            }
            g();
            long j4 = this.h;
            long e = this.b.e(this.d, this.g, j4 == -1 ? Long.MAX_VALUE : j4 - this.g);
            if (e > 0) {
                j = this.g;
            } else {
                long j5 = -e;
                if (j5 == Long.MAX_VALUE) {
                    j5 = -1;
                }
                j = this.g;
                e = f(j, j5);
            }
            this.g = j + e;
        }
    }

    public void b() {
        this.j = true;
    }

    public final long c() {
        long j = this.h;
        if (j == -1) {
            return -1L;
        }
        return j - this.c.g;
    }

    public final void d(long j) {
        this.i += j;
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(c(), this.i, j);
        }
    }

    public final void e(long j) {
        if (this.h == j) {
            return;
        }
        this.h = j;
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(c(), this.i, 0L);
        }
    }

    public final long f(long j, long j2) {
        long j3;
        boolean z = true;
        boolean z2 = j + j2 == this.h || j2 == -1;
        if (j2 != -1) {
            try {
                j3 = this.a.a(this.c.a().h(j).g(j2).a());
            } catch (IOException unused) {
                b4.r.a(this.a);
            }
        } else {
            j3 = -1;
            z = false;
        }
        if (!z) {
            g();
            try {
                j3 = this.a.a(this.c.a().h(j).g(-1L).a());
            } catch (IOException e) {
                b4.r.a(this.a);
                throw e;
            }
        }
        if (z2 && j3 != -1) {
            try {
                e(j3 + j);
            } catch (IOException e2) {
                b4.r.a(this.a);
                throw e2;
            }
        }
        int i = 0;
        int i2 = 0;
        while (i != -1) {
            g();
            c cVar = this.a;
            byte[] bArr = this.e;
            i = cVar.read(bArr, 0, bArr.length);
            if (i != -1) {
                d(i);
                i2 += i;
            }
        }
        if (z2) {
            e(j + i2);
        }
        this.a.close();
        return i2;
    }

    public final void g() {
        if (this.j) {
            throw new InterruptedIOException();
        }
    }
}
