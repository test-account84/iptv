package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ams implements amv {
    private static ams b;
    private final Context c;
    private final asr d;
    private final asv e;
    private final asx f;
    private final ans g;
    private final aru h;
    private final Executor i;
    private final asu j;
    private final aof l;
    private final anx m;
    private volatile boolean o;
    private volatile boolean p;
    private final int q;
    volatile long a = 0;
    private final Object n = new Object();
    private final CountDownLatch k = new CountDownLatch(1);

    public ams(Context context, aru aruVar, asr asrVar, asv asvVar, asx asxVar, ans ansVar, Executor executor, arl arlVar, int i, aof aofVar, anx anxVar) {
        this.p = false;
        this.c = context;
        this.h = aruVar;
        this.d = asrVar;
        this.e = asvVar;
        this.f = asxVar;
        this.g = ansVar;
        this.i = executor;
        this.q = i;
        this.l = aofVar;
        this.m = anxVar;
        this.p = false;
        this.j = new amr(arlVar);
    }

    public static synchronized ams a(String str, Context context, boolean z, boolean z2) {
        ams b2;
        synchronized (ams.class) {
            b2 = b(str, context, Executors.newCachedThreadPool(), z, z2);
        }
        return b2;
    }

    @Deprecated
    public static synchronized ams b(String str, Context context, Executor executor, boolean z, boolean z2) {
        ams amsVar;
        synchronized (ams.class) {
            try {
                if (b == null) {
                    arv a = arw.a();
                    a.b(str);
                    a.d(z);
                    arw a2 = a.a();
                    aru a3 = aru.a(context, executor, z2);
                    anh c = ((Boolean) aqo.x.f()).booleanValue() ? anh.c(context) : null;
                    aof d = ((Boolean) aqo.y.f()).booleanValue() ? aof.d(context, executor) : null;
                    anx anxVar = ((Boolean) aqo.p.f()).booleanValue() ? new anx() : null;
                    asg e = asg.e(context, executor, a3, a2);
                    anr anrVar = new anr(context);
                    ans ansVar = new ans(a2, e, new aod(context, anrVar), anrVar, c, d, anxVar);
                    int d2 = com.google.ads.interactivemedia.v3.impl.data.aq.d(context, a3);
                    arl arlVar = new arl();
                    ams amsVar2 = new ams(context, a3, new asr(context, d2), new asv(context, d2, new amz(a3, 1), ((Boolean) aqo.b.f()).booleanValue()), new asx(context, ansVar, a3, arlVar), ansVar, executor, arlVar, d2, d, anxVar);
                    b = amsVar2;
                    amsVar2.m();
                    b.o();
                }
                amsVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return amsVar;
    }

    public static /* bridge */ /* synthetic */ aru c(ams amsVar) {
        return amsVar.h;
    }

    public static /* bridge */ /* synthetic */ Object d(ams amsVar) {
        return amsVar.n;
    }

    public static /* bridge */ /* synthetic */ void i(ams amsVar, boolean z) {
        amsVar.o = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6 A[Catch: all -> 0x0096, bqw -> 0x0099, TryCatch #1 {bqw -> 0x0099, blocks: (B:5:0x001e, B:7:0x002c, B:10:0x0031, B:11:0x003d, B:13:0x004b, B:15:0x0059, B:18:0x0066, B:21:0x009c, B:25:0x00b1, B:27:0x00ca, B:31:0x00dc, B:33:0x00e2, B:35:0x00ea, B:36:0x00ec, B:39:0x00bb, B:40:0x00c2, B:41:0x006d, B:43:0x0083, B:46:0x00f6, B:48:0x0103, B:49:0x0110), top: B:4:0x001e, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* bridge */ /* synthetic */ void j(com.google.ads.interactivemedia.v3.internal.ams r8) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ams.j(com.google.ads.interactivemedia.v3.internal.ams):void");
    }

    public static /* bridge */ /* synthetic */ boolean p(ams amsVar) {
        return amsVar.o;
    }

    private final void t() {
        aof aofVar = this.l;
        if (aofVar != null) {
            aofVar.h();
        }
    }

    private final asq u(int i) {
        if (com.google.ads.interactivemedia.v3.impl.data.aq.c(this.q)) {
            return ((Boolean) aqo.a.f()).booleanValue() ? this.e.c(1) : this.d.d(1);
        }
        return null;
    }

    public final String e(Context context, String str, View view, Activity activity) {
        t();
        if (((Boolean) aqo.p.f()).booleanValue()) {
            this.m.i();
        }
        o();
        arx a = this.f.a();
        if (a == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = a.a(context, str, view, activity);
        this.h.f(5000, System.currentTimeMillis() - currentTimeMillis, a2);
        return a2;
    }

    public final String f(Context context) {
        t();
        if (((Boolean) aqo.p.f()).booleanValue()) {
            this.m.j();
        }
        o();
        arx a = this.f.a();
        if (a == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String c = a.c(context);
        this.h.f(5001, System.currentTimeMillis() - currentTimeMillis, c);
        return c;
    }

    public final String g(Context context, byte[] bArr) {
        throw null;
    }

    public final String h(Context context, View view, Activity activity) {
        t();
        if (((Boolean) aqo.p.f()).booleanValue()) {
            this.m.k(context, view);
        }
        o();
        arx a = this.f.a();
        if (a == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String b2 = a.b(context, view, activity);
        this.h.f(5002, System.currentTimeMillis() - currentTimeMillis, b2);
        return b2;
    }

    public final void k(MotionEvent motionEvent) {
        arx a = this.f.a();
        if (a != null) {
            try {
                a.d(motionEvent);
            } catch (asw e) {
                this.h.c(e.a(), -1L, e);
            }
        }
    }

    public final void l(int i, int i2, int i3) {
    }

    public final synchronized void m() {
        long currentTimeMillis = System.currentTimeMillis();
        asq u = u(1);
        if (u == null) {
            this.h.d(4013, System.currentTimeMillis() - currentTimeMillis);
        } else if (this.f.c(u)) {
            this.p = true;
            this.k.countDown();
        }
    }

    public final void n(View view) {
        this.g.d(view);
    }

    public final void o() {
        if (this.o) {
            return;
        }
        synchronized (this.n) {
            try {
                if (!this.o) {
                    if ((System.currentTimeMillis() / 1000) - this.a < 3600) {
                        return;
                    }
                    asq b2 = this.f.b();
                    if ((b2 == null || b2.d()) && com.google.ads.interactivemedia.v3.impl.data.aq.c(this.q)) {
                        this.i.execute(new amt(this, 1));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean q() {
        return r();
    }

    public final synchronized boolean r() {
        return this.p;
    }

    public final boolean s() {
        try {
            this.k.await();
        } catch (InterruptedException unused) {
        }
        return r();
    }
}
