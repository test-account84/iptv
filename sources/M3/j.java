package m3;

import O2.l1;
import O2.z0;
import com.google.android.exoplayer2.extractor.h;
import d4.M;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import m3.i;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j extends i {
    public a n;
    public int o;
    public boolean p;
    public h.c q;
    public h.a r;

    public static final class a {
        public final h.c a;
        public final h.a b;
        public final byte[] c;
        public final h.b[] d;
        public final int e;

        public a(h.c cVar, h.a aVar, byte[] bArr, h.b[] bVarArr, int i) {
            this.a = cVar;
            this.b = aVar;
            this.c = bArr;
            this.d = bVarArr;
            this.e = i;
        }
    }

    public static void n(M m, long j) {
        if (m.b() < m.g() + 4) {
            m.R(Arrays.copyOf(m.e(), m.g() + 4));
        } else {
            m.T(m.g() + 4);
        }
        byte[] e = m.e();
        e[m.g() - 4] = (byte) (j & 255);
        e[m.g() - 3] = (byte) ((j >>> 8) & 255);
        e[m.g() - 2] = (byte) ((j >>> 16) & 255);
        e[m.g() - 1] = (byte) ((j >>> 24) & 255);
    }

    public static int o(byte b, a aVar) {
        return !aVar.d[p(b, aVar.e, 1)].a ? aVar.a.g : aVar.a.h;
    }

    public static int p(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    public static boolean r(M m) {
        try {
            return com.google.android.exoplayer2.extractor.h.m(1, m, true);
        } catch (l1 unused) {
            return false;
        }
    }

    public void e(long j) {
        super.e(j);
        this.p = j != 0;
        h.c cVar = this.q;
        this.o = cVar != null ? cVar.g : 0;
    }

    public long f(M m) {
        if ((m.e()[0] & 1) == 1) {
            return -1L;
        }
        int o = o(m.e()[0], (a) d4.a.i(this.n));
        long j = this.p ? (this.o + o) / 4 : 0;
        n(m, j);
        this.p = true;
        this.o = o;
        return j;
    }

    public boolean i(M m, long j, i.b bVar) {
        if (this.n != null) {
            d4.a.e(bVar.a);
            return false;
        }
        a q = q(m);
        this.n = q;
        if (q == null) {
            return true;
        }
        h.c cVar = q.a;
        List arrayList = new ArrayList();
        arrayList.add(cVar.j);
        arrayList.add(q.c);
        bVar.a = new z0.b().g0("audio/vorbis").I(cVar.e).b0(cVar.d).J(cVar.b).h0(cVar.c).V(arrayList).Z(com.google.android.exoplayer2.extractor.h.c(y.s(q.b.b))).G();
        return true;
    }

    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    public a q(M m) {
        h.c cVar = this.q;
        if (cVar == null) {
            this.q = com.google.android.exoplayer2.extractor.h.j(m);
            return null;
        }
        h.a aVar = this.r;
        if (aVar == null) {
            this.r = com.google.android.exoplayer2.extractor.h.h(m);
            return null;
        }
        byte[] bArr = new byte[m.g()];
        System.arraycopy(m.e(), 0, bArr, 0, m.g());
        return new a(cVar, aVar, bArr, com.google.android.exoplayer2.extractor.h.k(m, cVar.b), com.google.android.exoplayer2.extractor.h.a(r4.length - 1));
    }
}
