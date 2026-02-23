package o3;

import O2.l1;
import android.util.Pair;
import d3.j;
import d4.B;
import d4.M;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class d {

    public static final class a {
        public final int a;
        public final long b;

        public a(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public static a a(j jVar, M m) {
            jVar.s(m.e(), 0, 8);
            m.U(0);
            return new a(m.q(), m.x());
        }
    }

    public static boolean a(j jVar) {
        M m = new M(8);
        int i = a.a(jVar, m).a;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        jVar.s(m.e(), 0, 4);
        m.U(0);
        int q = m.q();
        if (q == 1463899717) {
            return true;
        }
        B.d("WavHeaderReader", "Unsupported form type: " + q);
        return false;
    }

    public static c b(j jVar) {
        byte[] bArr;
        M m = new M(16);
        a d = d(1718449184, jVar, m);
        d4.a.g(d.b >= 16);
        jVar.s(m.e(), 0, 16);
        m.U(0);
        int z = m.z();
        int z2 = m.z();
        int y = m.y();
        int y2 = m.y();
        int z3 = m.z();
        int z4 = m.z();
        int i = ((int) d.b) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            jVar.s(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = k0.f;
        }
        jVar.q((int) (jVar.k() - jVar.getPosition()));
        return new c(z, z2, y, y2, z3, z4, bArr);
    }

    public static long c(j jVar) {
        M m = new M(8);
        a a2 = a.a(jVar, m);
        if (a2.a != 1685272116) {
            jVar.f();
            return -1L;
        }
        jVar.n(8);
        m.U(0);
        jVar.s(m.e(), 0, 8);
        long v = m.v();
        jVar.q(((int) a2.b) + 8);
        return v;
    }

    public static a d(int i, j jVar, M m) {
        while (true) {
            a a2 = a.a(jVar, m);
            if (a2.a == i) {
                return a2;
            }
            B.j("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.a);
            long j = a2.b + 8;
            if (j > 2147483647L) {
                throw l1.e("Chunk is too large (~2GB+) to skip; id: " + a2.a);
            }
            jVar.q((int) j);
        }
    }

    public static Pair e(j jVar) {
        jVar.f();
        a d = d(1684108385, jVar, new M(8));
        jVar.q(8);
        return Pair.create(Long.valueOf(jVar.getPosition()), Long.valueOf(d.b));
    }
}
