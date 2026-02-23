package m3;

import O2.z0;
import Q2.d0;
import d4.M;
import java.util.Arrays;
import java.util.List;
import m3.i;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h extends i {
    public static final byte[] o = {79, 112, 117, 115, 72, 101, 97, 100};
    public static final byte[] p = {79, 112, 117, 115, 84, 97, 103, 115};
    public boolean n;

    public static boolean n(M m, byte[] bArr) {
        if (m.a() < bArr.length) {
            return false;
        }
        int f = m.f();
        byte[] bArr2 = new byte[bArr.length];
        m.l(bArr2, 0, bArr.length);
        m.U(f);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean o(M m) {
        return n(m, o);
    }

    public long f(M m) {
        return c(d0.e(m.e()));
    }

    public boolean i(M m, long j, i.b bVar) {
        z0.b Z;
        if (n(m, o)) {
            byte[] copyOf = Arrays.copyOf(m.e(), m.g());
            int c = d0.c(copyOf);
            List a = d0.a(copyOf);
            if (bVar.a != null) {
                return true;
            }
            Z = new z0.b().g0("audio/opus").J(c).h0(48000).V(a);
        } else {
            byte[] bArr = p;
            if (!n(m, bArr)) {
                d4.a.i(bVar.a);
                return false;
            }
            d4.a.i(bVar.a);
            if (this.n) {
                return true;
            }
            this.n = true;
            m.V(bArr.length);
            q3.a c2 = com.google.android.exoplayer2.extractor.h.c(y.s(com.google.android.exoplayer2.extractor.h.i(m, false, false).b));
            if (c2 == null) {
                return true;
            }
            Z = bVar.a.b().Z(c2.c(bVar.a.k));
        }
        bVar.a = Z.G();
        return true;
    }

    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = false;
        }
    }
}
