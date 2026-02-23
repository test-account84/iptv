package d3;

import d4.B;
import d4.M;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b {
    public static void a(long j, M m, w[] wVarArr) {
        while (true) {
            if (m.a() <= 1) {
                return;
            }
            int c = c(m);
            int c2 = c(m);
            int f = m.f() + c2;
            if (c2 == -1 || c2 > m.a()) {
                B.j("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                f = m.g();
            } else if (c == 4 && c2 >= 8) {
                int H = m.H();
                int N = m.N();
                int q = N == 49 ? m.q() : 0;
                int H2 = m.H();
                if (N == 47) {
                    m.V(1);
                }
                boolean z = H == 181 && (N == 49 || N == 47) && H2 == 3;
                if (N == 49) {
                    z &= q == 1195456820;
                }
                if (z) {
                    b(j, m, wVarArr);
                }
            }
            m.U(f);
        }
    }

    public static void b(long j, M m, w[] wVarArr) {
        int H = m.H();
        if ((H & 64) != 0) {
            m.V(1);
            int i = (H & 31) * 3;
            int f = m.f();
            for (w wVar : wVarArr) {
                m.U(f);
                wVar.b(m, i);
                if (j != -9223372036854775807L) {
                    wVar.f(j, 1, i, 0, null);
                }
            }
        }
    }

    public static int c(M m) {
        int i = 0;
        while (m.a() != 0) {
            int H = m.H();
            i += H;
            if (H != 255) {
                return i;
            }
        }
        return -1;
    }
}
