package j$.util.stream;

import j$.util.Optional;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class K extends L {
    static final G c;
    static final G d;

    static {
        f3 f3Var = f3.REFERENCE;
        c = new G(true, f3Var, Optional.a(), new s(4), new q(7));
        d = new G(false, f3Var, Optional.a(), new s(4), new q(7));
    }

    public final Object get() {
        if (this.a) {
            return Optional.d(this.b);
        }
        return null;
    }
}
