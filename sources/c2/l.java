package C2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class l {
    public static void a(z2.f fVar, z2.d dVar) {
        if (!(fVar instanceof s)) {
            G2.a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", fVar);
        } else {
            u.c().e().u(((s) fVar).d().f(dVar), 1);
        }
    }
}
