package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aym extends ayf {
    private ayl b;

    public aym(avi aviVar, Executor executor, Callable callable) {
        super(aviVar);
        this.b = new ayk(this, callable, executor);
        q();
    }

    public static /* synthetic */ void w(aym aymVar) {
        aymVar.b = null;
    }

    public final void i() {
        ayl aylVar = this.b;
        if (aylVar != null) {
            aylVar.h();
        }
    }

    public final void p() {
        ayl aylVar = this.b;
        if (aylVar != null) {
            aylVar.f();
        }
    }

    public final void s(aye ayeVar) {
        super.s(ayeVar);
        if (ayeVar == aye.OUTPUT_FUTURE_DONE) {
            this.b = null;
        }
    }
}
