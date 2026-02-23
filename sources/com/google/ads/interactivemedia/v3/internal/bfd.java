package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bfd {
    public static final /* synthetic */ int a = 0;
    private static final bjj b;
    private static final ben c;
    private static final bel d;
    private static final bdy e;
    private static final bdw f;

    static {
        bjj a2 = com.google.ads.interactivemedia.v3.impl.data.p.a("type.googleapis.com/google.crypto.tink.AesCmacKey");
        b = a2;
        c = ben.a(bfn.b, bfc.class, ber.class);
        d = bel.a(bfo.b, a2, ber.class);
        e = bdy.a(bfp.b, bex.class, beq.class);
        f = bdw.a(bfq.b, a2, beq.class);
    }

    public static void a() throws GeneralSecurityException {
        bej b2 = bej.b();
        b2.f(c);
        b2.e(d);
        b2.d(e);
        b2.c(f);
    }
}
