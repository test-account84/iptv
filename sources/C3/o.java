package C3;

import B3.s;
import O2.Q1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o extends s {
    public final b h;

    public o(Q1 q1, b bVar) {
        super(q1);
        d4.a.g(q1.n() == 1);
        d4.a.g(q1.u() == 1);
        this.h = bVar;
    }

    public Q1.b l(int i, Q1.b bVar, boolean z) {
        this.g.l(i, bVar, z);
        long j = bVar.e;
        if (j == -9223372036854775807L) {
            j = this.h.e;
        }
        bVar.z(bVar.a, bVar.c, bVar.d, j, bVar.t(), this.h, bVar.g);
        return bVar;
    }
}
