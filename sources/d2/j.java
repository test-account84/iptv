package D2;

import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j implements E2.b {
    public final j8.a a;
    public final j8.a b;
    public final j8.a c;

    public j(j8.a aVar, j8.a aVar2, j8.a aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    public static j a(j8.a aVar, j8.a aVar2, j8.a aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i c(Context context, M2.a aVar, M2.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.a.get(), (M2.a) this.b.get(), (M2.a) this.c.get());
    }
}
