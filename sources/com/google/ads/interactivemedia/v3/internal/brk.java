package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class brk implements brq {
    private final brq[] a;

    public brk(brq... brqVarArr) {
        this.a = brqVarArr;
    }

    public final brp a(Class cls) {
        brq[] brqVarArr = this.a;
        for (int i = 0; i < 2; i++) {
            brq brqVar = brqVarArr[i];
            if (brqVar.b(cls)) {
                return brqVar.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean b(Class cls) {
        brq[] brqVarArr = this.a;
        for (int i = 0; i < 2; i++) {
            if (brqVarArr[i].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
