package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ays implements Runnable {
    final Future a;
    final ayr b;

    public ays(Future future, ayr ayrVar) {
        this.a = future;
        this.b = ayrVar;
    }

    public final void run() {
        Throwable a;
        azm azmVar = this.a;
        if ((azmVar instanceof azm) && (a = azn.a(azmVar)) != null) {
            this.b.a(a);
            return;
        }
        try {
            this.b.b(azh.c(this.a));
        } catch (RuntimeException e) {
            e = e;
            this.b.a(e);
        } catch (ExecutionException e2) {
            this.b.a(e2.getCause());
        } catch (Error e3) {
            e = e3;
            this.b.a(e);
        }
    }

    public final String toString() {
        return atp.n(this).a(this.b).toString();
    }
}
