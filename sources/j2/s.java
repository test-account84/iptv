package J2;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s implements E2.b {
    public final j8.a a;
    public final j8.a b;
    public final j8.a c;
    public final j8.a d;
    public final j8.a e;
    public final j8.a f;
    public final j8.a g;
    public final j8.a h;
    public final j8.a i;

    public s(j8.a aVar, j8.a aVar2, j8.a aVar3, j8.a aVar4, j8.a aVar5, j8.a aVar6, j8.a aVar7, j8.a aVar8, j8.a aVar9) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
    }

    public static s a(j8.a aVar, j8.a aVar2, j8.a aVar3, j8.a aVar4, j8.a aVar5, j8.a aVar6, j8.a aVar7, j8.a aVar8, j8.a aVar9) {
        return new s(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static r c(Context context, D2.e eVar, K2.d dVar, x xVar, Executor executor, L2.b bVar, M2.a aVar, M2.a aVar2, K2.c cVar) {
        return new r(context, eVar, dVar, xVar, executor, bVar, aVar, aVar2, cVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r get() {
        return c((Context) this.a.get(), (D2.e) this.b.get(), (K2.d) this.c.get(), (x) this.d.get(), (Executor) this.e.get(), (L2.b) this.f.get(), (M2.a) this.g.get(), (M2.a) this.h.get(), (K2.c) this.i.get());
    }
}
