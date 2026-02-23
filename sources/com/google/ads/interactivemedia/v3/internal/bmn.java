package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bmn implements bkm {
    private final bof a;
    private final boolean b;
    private final bke c;
    private final bjx d;

    public bmn(Object obj, bof bofVar, boolean z) {
        bke bkeVar = obj instanceof bke ? (bke) obj : null;
        this.c = bkeVar;
        bjx bjxVar = obj instanceof bjx ? (bjx) obj : null;
        this.d = bjxVar;
        boolean z2 = true;
        if (bkeVar == null && bjxVar == null) {
            z2 = false;
        }
        bjh.d(z2);
        this.a = bofVar;
        this.b = z;
    }

    public final bkl a(bjt bjtVar, bof bofVar) {
        if (this.a.equals(bofVar) || (this.b && this.a.d() == bofVar.c())) {
            return new bmo(this.c, this.d, bjtVar, bofVar, this, true);
        }
        return null;
    }
}
