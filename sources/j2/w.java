package J2;

import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w implements E2.b {
    public final j8.a a;
    public final j8.a b;
    public final j8.a c;
    public final j8.a d;

    public w(j8.a aVar, j8.a aVar2, j8.a aVar3, j8.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    public static w a(j8.a aVar, j8.a aVar2, j8.a aVar3, j8.a aVar4) {
        return new w(aVar, aVar2, aVar3, aVar4);
    }

    public static v c(Executor executor, K2.d dVar, x xVar, L2.b bVar) {
        return new v(executor, dVar, xVar, bVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v get() {
        return c((Executor) this.a.get(), (K2.d) this.b.get(), (x) this.c.get(), (L2.b) this.d.get());
    }
}
