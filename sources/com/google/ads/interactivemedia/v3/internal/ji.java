package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ji {
    private final Handler a;
    private final jj b;

    public ji(Handler handler, jj jjVar) {
        this.a = jjVar == null ? null : handler;
        this.b = jjVar;
    }

    public final void a(Exception exc) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new jc(this, exc, 0));
        }
    }

    public final void b(Exception exc) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new jc(this, exc, 4));
        }
    }

    public final void c(String str, long j, long j2) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new jf(this, str, j, j2));
        }
    }

    public final void d(String str) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new jc(this, str, 5));
        }
    }

    public final void e(ep epVar) {
        epVar.a();
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new jc(this, epVar, 2));
        }
    }

    public final void f(ep epVar) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new jc(this, epVar, 3));
        }
    }

    public final void g(s sVar, eq eqVar) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new jg(this, sVar, eqVar, 0));
        }
    }

    public final /* synthetic */ void h(Exception exc) {
        jj jjVar = this.b;
        int i = cq.a;
        jjVar.b(exc);
    }

    public final /* synthetic */ void i(Exception exc) {
        jj jjVar = this.b;
        int i = cq.a;
        jjVar.i(exc);
    }

    public final /* synthetic */ void j(String str, long j, long j2) {
        jj jjVar = this.b;
        int i = cq.a;
        jjVar.c(str, j, j2);
    }

    public final /* synthetic */ void k(String str) {
        jj jjVar = this.b;
        int i = cq.a;
        jjVar.d(str);
    }

    public final /* synthetic */ void l(ep epVar) {
        epVar.a();
        jj jjVar = this.b;
        int i = cq.a;
        jjVar.e(epVar);
    }

    public final /* synthetic */ void m(ep epVar) {
        jj jjVar = this.b;
        int i = cq.a;
        jjVar.f(epVar);
    }

    public final /* synthetic */ void n(s sVar, eq eqVar) {
        int i = cq.a;
        this.b.g(sVar, eqVar);
    }

    public final /* synthetic */ void o(long j) {
        jj jjVar = this.b;
        int i = cq.a;
        jjVar.h(j);
    }

    public final /* synthetic */ void p(boolean z) {
        jj jjVar = this.b;
        int i = cq.a;
        jjVar.m(z);
    }

    public final /* synthetic */ void q(int i, long j, long j2) {
        jj jjVar = this.b;
        int i2 = cq.a;
        jjVar.j(i, j, j2);
    }

    public final void r(long j) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new jd(this, j));
        }
    }

    public final void s(boolean z) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new je(this, z));
        }
    }

    public final void t(int i, long j, long j2) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new jh(this, i, j, j2));
        }
    }
}
