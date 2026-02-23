package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bhw extends bqn implements brt {
    private static final bhw a;
    private int d;
    private bqt e = bqn.aF();

    static {
        bhw bhwVar = new bhw();
        a = bhwVar;
        bqn.aL(bhw.class, bhwVar);
    }

    private bhw() {
    }

    public static /* synthetic */ bhw c() {
        return a;
    }

    public static bhw d(byte[] bArr, bqb bqbVar) throws bqw {
        return (bhw) bqn.aD(a, bArr, bqbVar);
    }

    public final int a() {
        return this.e.size();
    }

    public final int b() {
        return this.d;
    }

    public final List e() {
        return this.e;
    }

    public final Object i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return bqn.aI(a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"d", "e", bhv.class});
        }
        if (i2 == 3) {
            return new bhw();
        }
        if (i2 == 4) {
            return new bif((byte[]) null, (char[]) null, (byte[]) null, (byte[]) null);
        }
        if (i2 != 5) {
            return null;
        }
        return a;
    }
}
