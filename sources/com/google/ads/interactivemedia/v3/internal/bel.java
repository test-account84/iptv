package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bel {
    private final bjj a;
    private final Object b;

    public bel(bjj bjjVar, Class cls) {
        this(bjjVar, cls, null);
    }

    public static bel a(bek bekVar, bjj bjjVar, Class cls) {
        return new bel(bjjVar, cls);
    }

    public final bjj b() {
        return this.a;
    }

    public final Class c() {
        return (Class) this.b;
    }

    public final byte[] d() {
        return this.a.c();
    }

    public final byte[] e() {
        return ((bjj) this.b).c();
    }

    public /* synthetic */ bel(bjj bjjVar, Class cls, byte[] bArr) {
        this.a = bjjVar;
        this.b = cls;
    }

    public bel(byte[] bArr, byte[] bArr2) {
        this.a = bjj.b(bArr);
        this.b = bjj.b(bArr2);
    }
}
