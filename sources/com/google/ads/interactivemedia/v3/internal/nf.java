package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class nf implements ns {
    final /* synthetic */ nj a;
    private final nn c;
    private nm d;
    private boolean e;

    public nf(nj njVar, nn nnVar) {
        this.a = njVar;
        this.c = nnVar;
    }

    public final /* synthetic */ void a(s sVar) {
        nj njVar = this.a;
        if (nj.a(njVar) == 0 || this.e) {
            return;
        }
        Looper e = nj.e(njVar);
        af.s(e);
        this.d = nj.t(njVar, e, this.c, sVar);
        nj.m(this.a).add(this);
    }

    public final /* synthetic */ void b() {
        if (this.e) {
            return;
        }
        nm nmVar = this.d;
        if (nmVar != null) {
            nmVar.m(this.c);
        }
        nj.m(this.a).remove(this);
        this.e = true;
    }

    public final void c() {
        Handler d = nj.d(this.a);
        af.s(d);
        cq.at(d, new nd(this));
    }
}
