package K2;

import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h implements E2.b {
    public final j8.a a;

    public h(j8.a aVar) {
        this.a = aVar;
    }

    public static h a(j8.a aVar) {
        return new h(aVar);
    }

    public static String c(Context context) {
        return (String) E2.d.c(f.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.a.get());
    }
}
