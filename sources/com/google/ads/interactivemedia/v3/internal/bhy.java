package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhy extends bqn implements brt {
    private static final bhy a;
    private int d;
    private bqt e = bqn.aF();

    static {
        bhy bhyVar = new bhy();
        a = bhyVar;
        bqn.aL(bhy.class, bhyVar);
    }

    private bhy() {
    }

    public static /* synthetic */ bhy a() {
        return a;
    }

    public static /* synthetic */ void b(bhy bhyVar, int i) {
        bhyVar.d = i;
    }

    public static /* synthetic */ void c(bhy bhyVar, bhx bhxVar) {
        bhxVar.getClass();
        bhyVar.e();
        bhyVar.e.add(bhxVar);
    }

    public static bif d() {
        return (bif) a.ay();
    }

    private final void e() {
        bqt bqtVar = this.e;
        if (bqtVar.c()) {
            return;
        }
        this.e = bqn.aG(bqtVar);
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"d", "e", bhx.class});
        }
        if (i2 == 3) {
            return new bhy();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (byte[]) null, (char[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
