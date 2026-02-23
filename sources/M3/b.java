package m3;

import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import d3.p;
import d4.M;
import d4.k0;
import java.util.Arrays;
import m3.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends i {
    public FlacStreamMetadata n;
    public a o;

    public static final class a implements g {
        public FlacStreamMetadata a;
        public FlacStreamMetadata.a b;
        public long c = -1;
        public long d = -1;

        public a(FlacStreamMetadata flacStreamMetadata, FlacStreamMetadata.a aVar) {
            this.a = flacStreamMetadata;
            this.b = aVar;
        }

        public long a(d3.j jVar) {
            long j = this.d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.d = -1L;
            return j2;
        }

        public com.google.android.exoplayer2.extractor.g b() {
            d4.a.g(this.c != -1);
            return new com.google.android.exoplayer2.extractor.e(this.a, this.c);
        }

        public void c(long j) {
            long[] jArr = this.b.a;
            this.d = jArr[k0.i(jArr, j, true, true)];
        }

        public void d(long j) {
            this.c = j;
        }
    }

    public static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(M m) {
        return m.a() >= 5 && m.H() == 127 && m.J() == 1179402563;
    }

    public long f(M m) {
        if (o(m.e())) {
            return n(m);
        }
        return -1L;
    }

    public boolean i(M m, long j, i.b bVar) {
        byte[] e = m.e();
        FlacStreamMetadata flacStreamMetadata = this.n;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(e, 17);
            this.n = flacStreamMetadata2;
            bVar.a = flacStreamMetadata2.getFormat(Arrays.copyOfRange(e, 9, m.g()), null);
            return true;
        }
        if ((e[0] & Byte.MAX_VALUE) == 3) {
            FlacStreamMetadata.a g = com.google.android.exoplayer2.extractor.d.g(m);
            FlacStreamMetadata copyWithSeekTable = flacStreamMetadata.copyWithSeekTable(g);
            this.n = copyWithSeekTable;
            this.o = new a(copyWithSeekTable, g);
            return true;
        }
        if (!o(e)) {
            return true;
        }
        a aVar = this.o;
        if (aVar != null) {
            aVar.d(j);
            bVar.b = this.o;
        }
        d4.a.e(bVar.a);
        return false;
    }

    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }

    public final int n(M m) {
        int i = (m.e()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            m.V(4);
            m.O();
        }
        int j = p.j(m, i);
        m.U(0);
        return j;
    }
}
