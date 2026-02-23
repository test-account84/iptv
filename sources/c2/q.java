package C2;

import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q implements z2.g {
    public final Set a;
    public final p b;
    public final t c;

    public q(Set set, p pVar, t tVar) {
        this.a = set;
        this.b = pVar;
        this.c = tVar;
    }

    public z2.f a(String str, Class cls, z2.b bVar, z2.e eVar) {
        if (this.a.contains(bVar)) {
            return new s(this.b, str, bVar, eVar, this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{bVar, this.a}));
    }
}
