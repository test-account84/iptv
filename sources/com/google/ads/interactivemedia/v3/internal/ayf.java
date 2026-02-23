package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Future;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class ayf extends ayj {
    private static final Logger b = Logger.getLogger(ayf.class.getName());
    private avi c;

    public ayf(avi aviVar) {
        super(aviVar.size());
        atp.k(aviVar);
        this.c = aviVar;
    }

    public final String e() {
        avi aviVar = this.c;
        if (aviVar == null) {
            return super.e();
        }
        aviVar.toString();
        return "futures=".concat(aviVar.toString());
    }

    public final void h() {
        avi aviVar = this.c;
        s(aye.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (aviVar != null)) {
            boolean k = k();
            axq it = aviVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(k);
            }
        }
    }

    public abstract void p();

    public final void q() {
        avi aviVar = this.c;
        aviVar.getClass();
        if (aviVar.isEmpty()) {
            p();
            return;
        }
        ayd aydVar = new ayd(this, null);
        axq it = this.c.iterator();
        while (it.hasNext()) {
            ((azd) it.next()).g(aydVar, ayn.a);
        }
    }

    public final /* synthetic */ void r(avi aviVar) {
        int u = u();
        atp.i(u >= 0, "Less than 0 remaining futures");
        if (u == 0) {
            v();
            p();
            s(aye.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    public void s(aye ayeVar) {
        atp.k(ayeVar);
        this.c = null;
    }
}
