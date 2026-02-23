package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bmh implements bkm {
    final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public bmh(bkj bkjVar, int i) {
        this.b = i;
        this.a = bkjVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.ads.interactivemedia.v3.internal.bkj, java.lang.Object] */
    public final bkl a(bjt bjtVar, bof bofVar) {
        if (this.b != 0) {
            if (bofVar.c() == Number.class) {
                return (bkl) this.a;
            }
            return null;
        }
        if (bofVar.c() == Object.class) {
            return new bmi(bjtVar, this.a);
        }
        return null;
    }

    public bmh(bmg bmgVar, int i) {
        this.b = i;
        this.a = bmgVar;
    }
}
