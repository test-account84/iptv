package O3;

import N3.a;
import N3.b;
import O2.H0;
import b4.I;
import b4.o;
import b4.s;
import c4.c;
import d4.k0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import z3.G;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends G {
    public a(H0 h0, I.a aVar, c.c cVar, Executor executor, long j) {
        super(h0, aVar, cVar, executor, j);
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public List h(o oVar, N3.a aVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (a.b bVar : aVar.f) {
            for (int i = 0; i < bVar.j.length; i++) {
                for (int i2 = 0; i2 < bVar.k; i2++) {
                    arrayList.add(new G.c(bVar.e(i2), new s(bVar.a(i, i2))));
                }
            }
        }
        return arrayList;
    }

    public a(H0 h0, c.c cVar, Executor executor) {
        this(h0.b().m(k0.C(((H0.h) d4.a.e(h0.c)).a)).a(), new b(), cVar, executor, 20000L);
    }
}
