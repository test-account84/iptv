package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class ti implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    private final /* synthetic */ int e;

    public /* synthetic */ ti(alm almVar, azd azdVar, com.google.ads.interactivemedia.v3.impl.data.bi biVar, com.google.ads.interactivemedia.v3.impl.data.bj bjVar, int i) {
        this.e = i;
        this.a = almVar;
        this.b = azdVar;
        this.d = biVar;
        this.c = bjVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, java.util.concurrent.Future] */
    public final void run() {
        int i = this.e;
        if (i == 0) {
            Object obj = this.a;
            this.b.aj(((tj) obj).a, (te) this.c, (tb) this.d);
            return;
        }
        if (i == 1) {
            Object obj2 = this.a;
            tj tjVar = (tj) obj2;
            this.b.af(tjVar.a, tjVar.b, (sw) this.d, (tb) this.c);
            return;
        }
        if (i == 2) {
            Object obj3 = this.a;
            tj tjVar2 = (tj) obj3;
            this.b.ai(tjVar2.a, tjVar2.b, (sw) this.d, (tb) this.c);
            return;
        }
        if (i == 3) {
            Object obj4 = this.a;
            tj tjVar3 = (tj) obj4;
            this.b.ag(tjVar3.a, tjVar3.b, (sw) this.d, (tb) this.c);
            return;
        }
        Object obj5 = this.a;
        ?? r1 = this.b;
        Object obj6 = this.d;
        Object obj7 = this.c;
        try {
            azh.e(r1, Exception.class);
        } catch (Exception e) {
            com.google.ads.interactivemedia.v3.impl.data.m.b("Exception in " + String.valueOf(obj6) + "." + String.valueOf(obj7), e);
            ((alm) obj5).b((com.google.ads.interactivemedia.v3.impl.data.bi) obj6, (com.google.ads.interactivemedia.v3.impl.data.bj) obj7, e);
        }
    }

    public /* synthetic */ ti(tj tjVar, tk tkVar, sw swVar, tb tbVar, int i) {
        this.e = i;
        this.a = tjVar;
        this.b = tkVar;
        this.d = swVar;
        this.c = tbVar;
    }

    public /* synthetic */ ti(tj tjVar, tk tkVar, te teVar, tb tbVar, int i) {
        this.e = i;
        this.a = tjVar;
        this.b = tkVar;
        this.c = teVar;
        this.d = tbVar;
    }
}
