package I2;

import J2.x;
import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i implements E2.b {
    public final j8.a a;
    public final j8.a b;
    public final j8.a c;
    public final j8.a d;

    public i(j8.a aVar, j8.a aVar2, j8.a aVar3, j8.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    public static i a(j8.a aVar, j8.a aVar2, j8.a aVar3, j8.a aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static x c(Context context, K2.d dVar, J2.f fVar, M2.a aVar) {
        return (x) E2.d.c(h.a(context, dVar, fVar, aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public x get() {
        return c((Context) this.a.get(), (K2.d) this.b.get(), (J2.f) this.c.get(), (M2.a) this.d.get());
    }
}
