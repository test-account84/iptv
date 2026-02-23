package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class jg implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    private final /* synthetic */ int d;

    public /* synthetic */ jg(ji jiVar, s sVar, eq eqVar, int i) {
        this.d = i;
        this.a = jiVar;
        this.b = sVar;
        this.c = eqVar;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.ads.interactivemedia.v3.internal.no, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    public final void run() {
        int i = this.d;
        if (i == 0) {
            Object obj = this.a;
            ji jiVar = (ji) obj;
            jiVar.n((s) this.b, (eq) this.c);
            return;
        }
        if (i != 1) {
            Object obj2 = this.c;
            tj tjVar = (tj) obj2;
            this.a.ae(tjVar.a, tjVar.b, (tb) this.b);
            return;
        }
        Object obj3 = this.b;
        nn nnVar = (nn) obj3;
        this.c.an(nnVar.a, nnVar.b, (Exception) this.a);
    }

    public /* synthetic */ jg(nn nnVar, no noVar, Exception exc, int i) {
        this.d = i;
        this.b = nnVar;
        this.c = noVar;
        this.a = exc;
    }

    public /* synthetic */ jg(tj tjVar, tk tkVar, tb tbVar, int i) {
        this.d = i;
        this.c = tjVar;
        this.a = tkVar;
        this.b = tbVar;
    }
}
