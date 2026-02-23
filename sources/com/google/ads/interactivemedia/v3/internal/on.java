package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class on implements oz {
    private static final zy b = new zy();
    final zh a;
    private final s c;
    private final co d;

    public on(zh zhVar, s sVar, co coVar) {
        this.a = zhVar;
        this.c = sVar;
        this.d = coVar;
    }

    public final oz a() {
        zh abyVar;
        af.w(!b());
        zh zhVar = this.a;
        if (zhVar instanceof pp) {
            abyVar = new pp(this.c.c, this.d);
        } else if (zhVar instanceof adm) {
            abyVar = new adm();
        } else if (zhVar instanceof adh) {
            abyVar = new adh();
        } else if (zhVar instanceof adk) {
            abyVar = new adk();
        } else {
            if (!(zhVar instanceof aby)) {
                throw new IllegalStateException("Unexpected extractor type for recreation: ".concat(zhVar.getClass().getSimpleName()));
            }
            abyVar = new aby();
        }
        return new on(abyVar, this.c, this.d);
    }

    public final boolean b() {
        zh zhVar = this.a;
        return (zhVar instanceof aep) || (zhVar instanceof acs);
    }

    public final boolean c(zi ziVar) throws IOException {
        return this.a.a(ziVar, b) == 0;
    }
}
