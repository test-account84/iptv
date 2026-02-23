package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class brj implements brq {
    private static final brj b = new brj(1, null);
    private final /* synthetic */ int a;

    public brj(int i) {
        this.a = i;
    }

    public static brj c() {
        return b;
    }

    public final brp a(Class cls) {
        if (this.a == 0) {
            throw new IllegalStateException("This should never be called.");
        }
        if (!bqn.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (brp) bqn.az(cls.asSubclass(bqn.class)).aP(3);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    public final boolean b(Class cls) {
        if (this.a != 0) {
            return bqn.class.isAssignableFrom(cls);
        }
        return false;
    }

    private brj(int i, byte[] bArr) {
        this.a = i;
    }
}
