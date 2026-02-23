package C2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w implements E2.b {
    public final j8.a a;
    public final j8.a b;
    public final j8.a c;
    public final j8.a d;
    public final j8.a e;

    public w(j8.a aVar, j8.a aVar2, j8.a aVar3, j8.a aVar4, j8.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    public static w a(j8.a aVar, j8.a aVar2, j8.a aVar3, j8.a aVar4, j8.a aVar5) {
        return new w(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static u c(M2.a aVar, M2.a aVar2, I2.e eVar, J2.r rVar, J2.v vVar) {
        return new u(aVar, aVar2, eVar, rVar, vVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c((M2.a) this.a.get(), (M2.a) this.b.get(), (I2.e) this.c.get(), (J2.r) this.d.get(), (J2.v) this.e.get());
    }
}
