package x;

import x.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class j {
    public static boolean[] a = new boolean[3];

    public static void a(f fVar, w.d dVar, e eVar) {
        eVar.j = -1;
        eVar.k = -1;
        e.b bVar = fVar.M[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.M[0] == e.b.MATCH_PARENT) {
            int i = eVar.B.e;
            int N = fVar.N() - eVar.D.e;
            d dVar2 = eVar.B;
            dVar2.g = dVar.q(dVar2);
            d dVar3 = eVar.D;
            dVar3.g = dVar.q(dVar3);
            dVar.f(eVar.B.g, i);
            dVar.f(eVar.D.g, N);
            eVar.j = 2;
            eVar.h0(i, N);
        }
        if (fVar.M[1] == bVar2 || eVar.M[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i2 = eVar.C.e;
        int t = fVar.t() - eVar.E.e;
        d dVar4 = eVar.C;
        dVar4.g = dVar.q(dVar4);
        d dVar5 = eVar.E;
        dVar5.g = dVar.q(dVar5);
        dVar.f(eVar.C.g, i2);
        dVar.f(eVar.E.g, t);
        if (eVar.Y > 0 || eVar.M() == 8) {
            d dVar6 = eVar.F;
            dVar6.g = dVar.q(dVar6);
            dVar.f(eVar.F.g, eVar.Y + i2);
        }
        eVar.k = 2;
        eVar.v0(i2, t);
    }

    public static final boolean b(int i, int i2) {
        return (i & i2) == i2;
    }
}
