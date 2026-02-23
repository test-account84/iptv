package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class yh {
    private final Handler a;
    private final yi b;

    public yh(Handler handler, yi yiVar) {
        this.a = yiVar == null ? null : handler;
        this.b = yiVar;
    }

    public final void a(String str, long j, long j2) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new yf(this, str, j, j2));
        }
    }

    public final void b(String str) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new ye(this, str, 4));
        }
    }

    public final void c(ep epVar) {
        epVar.a();
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new ye(this, epVar, 2));
        }
    }

    public final void d(int i, long j) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new yd(this, i, j, 1));
        }
    }

    public final void e(ep epVar) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new ye(this, epVar, 0));
        }
    }

    public final void f(s sVar, eq eqVar) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new yg(this, sVar, eqVar));
        }
    }

    public final /* synthetic */ void g(String str, long j, long j2) {
        yi yiVar = this.b;
        int i = cq.a;
        yiVar.o(str, j, j2);
    }

    public final /* synthetic */ void h(String str) {
        yi yiVar = this.b;
        int i = cq.a;
        yiVar.p(str);
    }

    public final /* synthetic */ void i(ep epVar) {
        epVar.a();
        yi yiVar = this.b;
        int i = cq.a;
        yiVar.q(epVar);
    }

    public final /* synthetic */ void j(int i, long j) {
        yi yiVar = this.b;
        int i2 = cq.a;
        yiVar.k(i, j);
    }

    public final /* synthetic */ void k(ep epVar) {
        yi yiVar = this.b;
        int i = cq.a;
        yiVar.r(epVar);
    }

    public final /* synthetic */ void l(s sVar, eq eqVar) {
        int i = cq.a;
        this.b.t(sVar, eqVar);
    }

    public final /* synthetic */ void m(Object obj, long j) {
        yi yiVar = this.b;
        int i = cq.a;
        yiVar.l(obj, j);
    }

    public final /* synthetic */ void n(long j, int i) {
        yi yiVar = this.b;
        int i2 = cq.a;
        yiVar.s(j, i);
    }

    public final /* synthetic */ void o(Exception exc) {
        yi yiVar = this.b;
        int i = cq.a;
        yiVar.n(exc);
    }

    public final /* synthetic */ void p(bl blVar) {
        yi yiVar = this.b;
        int i = cq.a;
        yiVar.u(blVar);
    }

    public final void q(Object obj) {
        if (this.a != null) {
            this.a.post(new yc(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    public final void r(long j, int i) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new yd(this, j, i, 0));
        }
    }

    public final void s(Exception exc) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new ye(this, exc, 1));
        }
    }

    public final void t(bl blVar) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new ye(this, blVar, 3));
        }
    }
}
