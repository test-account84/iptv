package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class acj implements ach {
    private final int a;
    private final int b;
    private final cj c;

    public acj(acd acdVar, s sVar) {
        cj cjVar = acdVar.a;
        this.c = cjVar;
        cjVar.F(12);
        int l = cjVar.l();
        if ("audio/raw".equals(sVar.l)) {
            int l2 = cq.l(sVar.A, sVar.y);
            if (l == 0 || l % l2 != 0) {
                cd.e("AtomParsers", "Audio sample size mismatch. stsd sample size: " + l2 + ", stsz sample size: " + l);
                l = l2;
            }
        }
        this.a = l == 0 ? -1 : l;
        this.b = cjVar.l();
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        int i = this.a;
        return i == -1 ? this.c.l() : i;
    }
}
