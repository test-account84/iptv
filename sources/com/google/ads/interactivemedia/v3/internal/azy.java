package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class azy implements baa {
    final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public azy(azv azvVar, int i) {
        this.b = i;
        this.a = azvVar;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.ads.interactivemedia.v3.internal.azv, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.google.ads.interactivemedia.v3.internal.azv, java.lang.Object] */
    public final azv a(Class cls) throws GeneralSecurityException {
        if (this.b != 0) {
            if (this.a.c().equals(cls)) {
                return this.a;
            }
            throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
        }
        try {
            return new azx((beb) this.a, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.ads.interactivemedia.v3.internal.azv, java.lang.Object] */
    public final azv b() {
        if (this.b != 0) {
            return this.a;
        }
        beb bebVar = (beb) this.a;
        return new azx(bebVar, bebVar.i());
    }

    public final Class c() {
        int i = this.b;
        return this.a.getClass();
    }

    public final Class d() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.ads.interactivemedia.v3.internal.azv, java.lang.Object] */
    public final Set e() {
        return this.b != 0 ? Collections.singleton(this.a.c()) : ((beb) this.a).l();
    }

    public azy(beb bebVar, int i) {
        this.b = i;
        this.a = bebVar;
    }
}
