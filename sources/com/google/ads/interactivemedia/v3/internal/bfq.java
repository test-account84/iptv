package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class bfq implements bdv {
    private final /* synthetic */ int c;
    public static final /* synthetic */ bfq b = new bfq(1);
    public static final /* synthetic */ bfq a = new bfq(0);

    private /* synthetic */ bfq(int i) {
        this.c = i;
    }

    public final azu a(bes besVar, bap bapVar) {
        bfk bfkVar;
        bfl bflVar;
        bfb bfbVar;
        if (this.c != 0) {
            int i = bfd.a;
            if (!((beq) besVar).g().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
                throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
            }
            try {
                bge c = bge.c(((beq) besVar).e(), bqb.a());
                if (c.a() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                }
                bfe bfeVar = new bfe(null, null);
                bfeVar.e(c.e().d());
                bfeVar.f(c.d().a());
                bid c2 = ((beq) besVar).c();
                bid bidVar = bid.a;
                int ordinal = c2.ordinal();
                if (ordinal == 1) {
                    bfbVar = bfb.a;
                } else if (ordinal == 2) {
                    bfbVar = bfb.c;
                } else if (ordinal == 3) {
                    bfbVar = bfb.d;
                } else {
                    if (ordinal != 4) {
                        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + c2.getNumber());
                    }
                    bfbVar = bfb.b;
                }
                bfeVar.g(bfbVar);
                bfc d = bfeVar.d();
                bfe bfeVar2 = new bfe(null, null, null);
                bfeVar2.j(d);
                bfeVar2.l(vk.e(c.e().B()));
                bfeVar2.i(((beq) besVar).f());
                return bfeVar2.h();
            } catch (bqw | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        }
        int i2 = bfr.a;
        if (!((beq) besVar).g().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacParameters.parseParameters");
        }
        try {
            bhg d2 = bhg.d(((beq) besVar).e(), bqb.a());
            if (d2.a() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            bfj bfjVar = new bfj(null);
            bfjVar.c(d2.f().d());
            bfjVar.d(d2.e().a());
            int e = d2.e().e();
            bid bidVar2 = bid.a;
            int i3 = bhf.a;
            int i4 = e - 2;
            if (e == 0) {
                throw null;
            }
            if (i4 == 1) {
                bfkVar = bfk.a;
            } else if (i4 == 2) {
                bfkVar = bfk.d;
            } else if (i4 == 3) {
                bfkVar = bfk.c;
            } else if (i4 == 4) {
                bfkVar = bfk.e;
            } else {
                if (i4 != 5) {
                    throw new GeneralSecurityException("Unable to parse HashType: " + bhf.a(e));
                }
                bfkVar = bfk.b;
            }
            bfjVar.b(bfkVar);
            bid c3 = ((beq) besVar).c();
            int ordinal2 = c3.ordinal();
            if (ordinal2 == 1) {
                bflVar = bfl.a;
            } else if (ordinal2 == 2) {
                bflVar = bfl.c;
            } else if (ordinal2 == 3) {
                bflVar = bfl.d;
            } else {
                if (ordinal2 != 4) {
                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + c3.getNumber());
                }
                bflVar = bfl.b;
            }
            bfjVar.e(bflVar);
            bfm a2 = bfjVar.a();
            bfe bfeVar3 = new bfe(null);
            bfeVar3.c(a2);
            bfeVar3.k(vk.e(d2.f().B()));
            bfeVar3.b(((beq) besVar).f());
            return bfeVar3.a();
        } catch (bqw | IllegalArgumentException unused2) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }
}
