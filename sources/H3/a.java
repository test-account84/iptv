package h3;

import O2.z0;
import Q2.a;
import d3.w;
import d4.M;
import h3.e;
import java.util.Collections;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends e {
    public static final int[] e = {5512, 11025, 22050, 44100};
    public boolean b;
    public boolean c;
    public int d;

    public a(w wVar) {
        super(wVar);
    }

    public boolean b(M m) {
        z0.b h0;
        if (this.b) {
            m.V(1);
        } else {
            int H = m.H();
            int i = (H >> 4) & 15;
            this.d = i;
            if (i == 2) {
                h0 = new z0.b().g0("audio/mpeg").J(1).h0(e[(H >> 2) & 3]);
            } else if (i == 7 || i == 8) {
                h0 = new z0.b().g0(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").J(1).h0(8000);
            } else {
                if (i != 10) {
                    throw new e.a("Audio format not supported: " + this.d);
                }
                this.b = true;
            }
            this.a.d(h0.G());
            this.c = true;
            this.b = true;
        }
        return true;
    }

    public boolean c(M m, long j) {
        if (this.d == 2) {
            int a = m.a();
            this.a.b(m, a);
            this.a.f(j, 1, a, 0, null);
            return true;
        }
        int H = m.H();
        if (H != 0 || this.c) {
            if (this.d == 10 && H != 1) {
                return false;
            }
            int a2 = m.a();
            this.a.b(m, a2);
            this.a.f(j, 1, a2, 0, null);
            return true;
        }
        int a3 = m.a();
        byte[] bArr = new byte[a3];
        m.l(bArr, 0, a3);
        a.b f = Q2.a.f(bArr);
        this.a.d(new z0.b().g0("audio/mp4a-latm").K(f.c).J(f.b).h0(f.a).V(Collections.singletonList(bArr)).G());
        this.c = true;
        return false;
    }
}
