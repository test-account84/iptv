package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aen implements aei {
    final /* synthetic */ aep a;
    private final ci b = new ci(new byte[4]);

    public aen(aep aepVar) {
        this.a = aepVar;
    }

    public final void a(cj cjVar) {
        if (cjVar.i() == 0 && (cjVar.i() & 128) != 0) {
            cjVar.G(6);
            int a = cjVar.a() / 4;
            for (int i = 0; i < a; i++) {
                cjVar.z(this.b, 4);
                int c = this.b.c(16);
                this.b.i(3);
                if (c == 0) {
                    this.b.i(13);
                } else {
                    int c2 = this.b.c(13);
                    if (aep.h(this.a).get(c2) == null) {
                        aep aepVar = this.a;
                        aep.h(aepVar).put(c2, new aej(new aeo(aepVar, c2)));
                        aep aepVar2 = this.a;
                        aep.q(aepVar2, aep.g(aepVar2) + 1);
                    }
                }
            }
            aep aepVar3 = this.a;
            if (aep.f(aepVar3) != 2) {
                aep.h(aepVar3).remove(0);
            }
        }
    }

    public final void b(co coVar, zk zkVar, aet aetVar) {
    }
}
