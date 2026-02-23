package j3;

import O2.l1;
import d3.j;
import java.util.ArrayDeque;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements c {
    public final byte[] a = new byte[8];
    public final ArrayDeque b = new ArrayDeque();
    public final g c = new g();
    public j3.b d;
    public int e;
    public int f;
    public long g;

    public static final class b {
        public final int a;
        public final long b;

        public b(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public static /* synthetic */ long a(b bVar) {
            return bVar.b;
        }

        public static /* synthetic */ int b(b bVar) {
            return bVar.a;
        }

        public /* synthetic */ b(int i, long j, a aVar) {
            this(i, j);
        }
    }

    public static String f(j jVar, int i) {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        jVar.m(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    public boolean a(j jVar) {
        d4.a.i(this.d);
        while (true) {
            b bVar = (b) this.b.peek();
            if (bVar != null && jVar.getPosition() >= b.a(bVar)) {
                this.d.a(b.b((b) this.b.pop()));
                return true;
            }
            if (this.e == 0) {
                long d = this.c.d(jVar, true, false, 4);
                if (d == -2) {
                    d = c(jVar);
                }
                if (d == -1) {
                    return false;
                }
                this.f = (int) d;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.d(jVar, false, true, 8);
                this.e = 2;
            }
            int e = this.d.e(this.f);
            if (e != 0) {
                if (e == 1) {
                    long position = jVar.getPosition();
                    this.b.push(new b(this.f, this.g + position, null));
                    this.d.h(this.f, position, this.g);
                    this.e = 0;
                    return true;
                }
                if (e == 2) {
                    long j = this.g;
                    if (j <= 8) {
                        this.d.d(this.f, e(jVar, (int) j));
                        this.e = 0;
                        return true;
                    }
                    throw l1.a("Invalid integer size: " + this.g, null);
                }
                if (e == 3) {
                    long j2 = this.g;
                    if (j2 <= 2147483647L) {
                        this.d.g(this.f, f(jVar, (int) j2));
                        this.e = 0;
                        return true;
                    }
                    throw l1.a("String element size: " + this.g, null);
                }
                if (e == 4) {
                    this.d.b(this.f, (int) this.g, jVar);
                    this.e = 0;
                    return true;
                }
                if (e != 5) {
                    throw l1.a("Invalid element type " + e, null);
                }
                long j3 = this.g;
                if (j3 == 4 || j3 == 8) {
                    this.d.c(this.f, d(jVar, (int) j3));
                    this.e = 0;
                    return true;
                }
                throw l1.a("Invalid float size: " + this.g, null);
            }
            jVar.q((int) this.g);
            this.e = 0;
        }
    }

    public void b(j3.b bVar) {
        this.d = bVar;
    }

    public final long c(j jVar) {
        jVar.f();
        while (true) {
            jVar.s(this.a, 0, 4);
            int c = g.c(this.a[0]);
            if (c != -1 && c <= 4) {
                int a2 = (int) g.a(this.a, c, false);
                if (this.d.f(a2)) {
                    jVar.q(c);
                    return a2;
                }
            }
            jVar.q(1);
        }
    }

    public final double d(j jVar, int i) {
        return i == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(jVar, i));
    }

    public final long e(j jVar, int i) {
        jVar.m(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.a[i2] & 255);
        }
        return j;
    }

    public void reset() {
        this.e = 0;
        this.b.clear();
        this.c.e();
    }
}
