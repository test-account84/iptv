package I2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g implements E2.b {
    public final j8.a a;

    public g(j8.a aVar) {
        this.a = aVar;
    }

    public static J2.f a(M2.a aVar) {
        return (J2.f) E2.d.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(j8.a aVar) {
        return new g(aVar);
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public J2.f get() {
        return a((M2.a) this.a.get());
    }
}
