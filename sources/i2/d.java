package I2;

import J2.x;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements E2.b {
    public final j8.a a;
    public final j8.a b;
    public final j8.a c;
    public final j8.a d;
    public final j8.a e;

    public d(j8.a aVar, j8.a aVar2, j8.a aVar3, j8.a aVar4, j8.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    public static d a(j8.a aVar, j8.a aVar2, j8.a aVar3, j8.a aVar4, j8.a aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, D2.e eVar, x xVar, K2.d dVar, L2.b bVar) {
        return new c(executor, eVar, xVar, dVar, bVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c((Executor) this.a.get(), (D2.e) this.b.get(), (x) this.c.get(), (K2.d) this.d.get(), (L2.b) this.e.get());
    }
}
