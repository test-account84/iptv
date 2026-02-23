package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class azz implements baa {
    final /* synthetic */ bep a;
    final /* synthetic */ beb b;

    public azz(bep bepVar, beb bebVar) {
        this.a = bepVar;
        this.b = bebVar;
    }

    public final azv a(Class cls) throws GeneralSecurityException {
        try {
            return new azx(this.a, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final azv b() {
        bep bepVar = this.a;
        return new azx(bepVar, bepVar.i());
    }

    public final Class c() {
        return this.a.getClass();
    }

    public final Class d() {
        return this.b.getClass();
    }

    public final Set e() {
        return this.a.l();
    }
}
