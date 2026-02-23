package com.google.ads.interactivemedia.v3.internal;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class alm {
    private final Queue a;
    private final akc b;
    private int c;
    private final com.google.ads.interactivemedia.v3.impl.data.ag d;

    public alm(akc akcVar) {
        com.google.ads.interactivemedia.v3.impl.data.ag agVar = new com.google.ads.interactivemedia.v3.impl.data.ag();
        this.a = new ConcurrentLinkedQueue();
        this.c = 1;
        this.d = agVar;
        this.b = akcVar;
    }

    private final void e(com.google.ads.interactivemedia.v3.impl.data.bk bkVar) {
        ajr ajrVar = new ajr(ajp.adsLoader, ajq.nativeInstrumentation, "*", bkVar);
        int i = this.c;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            this.b.o(ajrVar);
        } else if (this.a.size() > 2) {
            this.c = 3;
        } else {
            this.a.add(ajrVar);
        }
    }

    public final void a(com.google.ads.interactivemedia.v3.impl.data.bi biVar, com.google.ads.interactivemedia.v3.impl.data.bj bjVar) {
        e(com.google.ads.interactivemedia.v3.impl.data.bk.create(System.currentTimeMillis(), biVar, bjVar));
    }

    public final void b(com.google.ads.interactivemedia.v3.impl.data.bi biVar, com.google.ads.interactivemedia.v3.impl.data.bj bjVar, Exception exc) {
        e(com.google.ads.interactivemedia.v3.impl.data.bk.create(System.currentTimeMillis(), biVar, bjVar, (Throwable) exc));
    }

    public final void c(azd azdVar, aze azeVar, com.google.ads.interactivemedia.v3.impl.data.bi biVar, com.google.ads.interactivemedia.v3.impl.data.bj bjVar) {
        azdVar.g(new ti(this, azdVar, biVar, bjVar, 4), azeVar);
    }

    public final void d(boolean z) {
        if (!z) {
            this.c = 3;
            this.a.clear();
        } else {
            this.c = 2;
            while (true) {
                ajr ajrVar = (ajr) this.a.poll();
                if (ajrVar == null) {
                    return;
                } else {
                    this.b.o(ajrVar);
                }
            }
        }
    }
}
