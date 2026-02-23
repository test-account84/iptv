package com.google.android.exoplayer2.extractor;

import O2.l1;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import d3.j;
import d3.s;
import d4.L;
import d4.M;
import java.util.Arrays;
import java.util.List;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class d {

    public static final class a {
        public FlacStreamMetadata a;

        public a(FlacStreamMetadata flacStreamMetadata) {
            this.a = flacStreamMetadata;
        }
    }

    public static boolean a(j jVar) {
        M m = new M(4);
        jVar.s(m.e(), 0, 4);
        return m.J() == 1716281667;
    }

    public static int b(j jVar) {
        jVar.f();
        M m = new M(2);
        jVar.s(m.e(), 0, 2);
        int N = m.N();
        int i = N >> 2;
        jVar.f();
        if (i == 16382) {
            return N;
        }
        throw l1.a("First frame does not start with sync code.", null);
    }

    public static q3.a c(j jVar, boolean z) {
        q3.a a2 = new s().a(jVar, z ? null : v3.h.b);
        if (a2 == null || a2.f() == 0) {
            return null;
        }
        return a2;
    }

    public static q3.a d(j jVar, boolean z) {
        jVar.f();
        long k = jVar.k();
        q3.a c = c(jVar, z);
        jVar.q((int) (jVar.k() - k));
        return c;
    }

    public static boolean e(j jVar, a aVar) {
        FlacStreamMetadata copyWithPictureFrames;
        jVar.f();
        L l = new L(new byte[4]);
        jVar.s(l.a, 0, 4);
        boolean g = l.g();
        int h = l.h(7);
        int h2 = l.h(24) + 4;
        if (h == 0) {
            copyWithPictureFrames = h(jVar);
        } else {
            FlacStreamMetadata flacStreamMetadata = aVar.a;
            if (flacStreamMetadata == null) {
                throw new IllegalArgumentException();
            }
            if (h == 3) {
                copyWithPictureFrames = flacStreamMetadata.copyWithSeekTable(f(jVar, h2));
            } else if (h == 4) {
                copyWithPictureFrames = flacStreamMetadata.copyWithVorbisComments(j(jVar, h2));
            } else {
                if (h != 6) {
                    jVar.q(h2);
                    return g;
                }
                M m = new M(h2);
                jVar.m(m.e(), 0, h2);
                m.V(4);
                copyWithPictureFrames = flacStreamMetadata.copyWithPictureFrames(y.A(PictureFrame.fromPictureBlock(m)));
            }
        }
        aVar.a = copyWithPictureFrames;
        return g;
    }

    public static FlacStreamMetadata.a f(j jVar, int i) {
        M m = new M(i);
        jVar.m(m.e(), 0, i);
        return g(m);
    }

    public static FlacStreamMetadata.a g(M m) {
        m.V(1);
        int K = m.K();
        long f = m.f() + K;
        int i = K / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long A = m.A();
            if (A == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = A;
            jArr2[i2] = m.A();
            m.V(2);
            i2++;
        }
        m.V((int) (f - m.f()));
        return new FlacStreamMetadata.a(jArr, jArr2);
    }

    public static FlacStreamMetadata h(j jVar) {
        byte[] bArr = new byte[38];
        jVar.m(bArr, 0, 38);
        return new FlacStreamMetadata(bArr, 4);
    }

    public static void i(j jVar) {
        M m = new M(4);
        jVar.m(m.e(), 0, 4);
        if (m.J() != 1716281667) {
            throw l1.a("Failed to read FLAC stream marker.", null);
        }
    }

    public static List j(j jVar, int i) {
        M m = new M(i);
        jVar.m(m.e(), 0, i);
        m.V(4);
        return Arrays.asList(h.i(m, false, false).b);
    }
}
