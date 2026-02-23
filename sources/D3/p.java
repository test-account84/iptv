package d3;

import O2.l1;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import d4.M;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class p {

    public static final class a {
        public long a;
    }

    public static boolean a(M m, FlacStreamMetadata flacStreamMetadata, int i) {
        int j = j(m, i);
        return j != -1 && j <= flacStreamMetadata.maxBlockSizeSamples;
    }

    public static boolean b(M m, int i) {
        return m.H() == k0.v(m.e(), i, m.f() - 1, 0);
    }

    public static boolean c(M m, FlacStreamMetadata flacStreamMetadata, boolean z, a aVar) {
        try {
            long O = m.O();
            if (!z) {
                O *= flacStreamMetadata.maxBlockSizeSamples;
            }
            aVar.a = O;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(M m, FlacStreamMetadata flacStreamMetadata, int i, a aVar) {
        int f = m.f();
        long J = m.J();
        long j = J >>> 16;
        if (j != i) {
            return false;
        }
        return g((int) (15 & (J >> 4)), flacStreamMetadata) && f((int) ((J >> 1) & 7), flacStreamMetadata) && !(((J & 1) > 1L ? 1 : ((J & 1) == 1L ? 0 : -1)) == 0) && c(m, flacStreamMetadata, ((j & 1) > 1L ? 1 : ((j & 1) == 1L ? 0 : -1)) == 0, aVar) && a(m, flacStreamMetadata, (int) ((J >> 12) & 15)) && e(m, flacStreamMetadata, (int) ((J >> 8) & 15)) && b(m, f);
    }

    public static boolean e(M m, FlacStreamMetadata flacStreamMetadata, int i) {
        int i2 = flacStreamMetadata.sampleRate;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == flacStreamMetadata.sampleRateLookupKey;
        }
        if (i == 12) {
            return m.H() * 1000 == i2;
        }
        if (i > 14) {
            return false;
        }
        int N = m.N();
        if (i == 14) {
            N *= 10;
        }
        return N == i2;
    }

    public static boolean f(int i, FlacStreamMetadata flacStreamMetadata) {
        return i == 0 || i == flacStreamMetadata.bitsPerSampleLookupKey;
    }

    public static boolean g(int i, FlacStreamMetadata flacStreamMetadata) {
        return i <= 7 ? i == flacStreamMetadata.channels - 1 : i <= 10 && flacStreamMetadata.channels == 2;
    }

    public static boolean h(j jVar, FlacStreamMetadata flacStreamMetadata, int i, a aVar) {
        long k = jVar.k();
        byte[] bArr = new byte[2];
        jVar.s(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            jVar.f();
            jVar.n((int) (k - jVar.getPosition()));
            return false;
        }
        M m = new M(16);
        System.arraycopy(bArr, 0, m.e(), 0, 2);
        m.T(l.c(jVar, m.e(), 2, 14));
        jVar.f();
        jVar.n((int) (k - jVar.getPosition()));
        return d(m, flacStreamMetadata, i, aVar);
    }

    public static long i(j jVar, FlacStreamMetadata flacStreamMetadata) {
        jVar.f();
        jVar.n(1);
        byte[] bArr = new byte[1];
        jVar.s(bArr, 0, 1);
        boolean z = (bArr[0] & 1) == 1;
        jVar.n(2);
        int i = z ? 7 : 6;
        M m = new M(i);
        m.T(l.c(jVar, m.e(), 0, i));
        jVar.f();
        a aVar = new a();
        if (c(m, flacStreamMetadata, z, aVar)) {
            return aVar.a;
        }
        throw l1.a(null, null);
    }

    public static int j(M m, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return m.H() + 1;
            case 7:
                return m.N() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
