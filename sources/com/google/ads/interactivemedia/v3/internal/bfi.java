package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bfi extends beb {
    public bfi() {
        super(bhg.class, new bfg(bag.class));
    }

    public static /* bridge */ /* synthetic */ void g(bhi bhiVar) {
        n(bhiVar);
    }

    public static final void h(bhg bhgVar) throws GeneralSecurityException {
        bjg.b(bhgVar.a());
        if (bhgVar.f().d() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        n(bhgVar.e());
    }

    public static /* bridge */ /* synthetic */ bdz m(int i, int i2, int i3, int i4) {
        bif h = bhh.h();
        bif g = bhi.g();
        g.D(i3);
        g.C(i2);
        h.F((bhi) g.aY());
        h.E(i);
        return new bdz((bhh) h.aY(), i4);
    }

    private static void n(bhi bhiVar) throws GeneralSecurityException {
        if (bhiVar.a() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i = bhf.a;
        int e = bhiVar.e();
        int i2 = e - 2;
        if (e == 0) {
            throw null;
        }
        if (i2 == 1) {
            if (bhiVar.a() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i2 == 2) {
            if (bhiVar.a() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i2 == 3) {
            if (bhiVar.a() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i2 == 4) {
            if (bhiVar.a() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i2 != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (bhiVar.a() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    public final bea a() {
        return new bfh(this, bhh.class);
    }

    public final bhq b() {
        return bhq.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ brs c(bpb bpbVar) throws bqw {
        return bhg.d(bpbVar, bqb.a());
    }

    public final String d() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final /* bridge */ /* synthetic */ void e(brs brsVar) throws GeneralSecurityException {
        h((bhg) brsVar);
    }

    public final int f() {
        return bch.b;
    }
}
