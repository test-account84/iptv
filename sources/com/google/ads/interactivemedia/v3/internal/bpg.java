package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bpg {
    public static final /* synthetic */ int e = 0;
    private static volatile int f = 100;
    int a;
    final int b = f;
    final int c = Integer.MAX_VALUE;
    bpi d;

    public static int F(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long G(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static bpg H(byte[] bArr, int i, int i2, boolean z) {
        bpc bpcVar = new bpc(bArr, i, i2);
        try {
            bpcVar.e(i2);
            return bpcVar;
        } catch (bqw e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract void A(int i);

    public abstract boolean C() throws IOException;

    public abstract boolean D() throws IOException;

    public abstract boolean E(int i) throws IOException;

    public abstract double b() throws IOException;

    public abstract float c() throws IOException;

    public abstract int d();

    public abstract int e(int i) throws bqw;

    public abstract int f() throws IOException;

    public abstract int g() throws IOException;

    public abstract int h() throws IOException;

    public abstract int k() throws IOException;

    public abstract int l() throws IOException;

    public abstract int m() throws IOException;

    public abstract int n() throws IOException;

    public abstract long o() throws IOException;

    public abstract long p() throws IOException;

    public abstract long t() throws IOException;

    public abstract long u() throws IOException;

    public abstract long v() throws IOException;

    public abstract bpb w() throws IOException;

    public abstract String x() throws IOException;

    public abstract String y() throws IOException;

    public abstract void z(int i) throws bqw;
}
