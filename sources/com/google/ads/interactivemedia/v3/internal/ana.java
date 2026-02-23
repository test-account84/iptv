package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.Hide;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ana implements Runnable, amv {
    private Context c;
    private final aru d;
    private final Executor e;
    private final aff f;
    private final boolean g;
    private final AtomicReference b = new AtomicReference();
    final CountDownLatch a = new CountDownLatch(1);
    private final List h = new ArrayList();

    public ana(Context context, Executor executor, aff affVar) {
        this.f = affVar;
        this.c = context;
        this.e = executor;
        aqo.a(context);
        boolean z = ((Boolean) aqo.c.f()).booleanValue() && affVar.d();
        this.g = z;
        this.d = aru.a(context, executor, z);
        executor.execute(this);
    }

    public static /* bridge */ /* synthetic */ aru b(ana anaVar) {
        return anaVar.d;
    }

    private final void d() {
        if (this.h.isEmpty() || this.b.get() == null) {
            return;
        }
        for (Object[] objArr : this.h) {
            int length = objArr.length;
            if (length == 1) {
                ((amv) this.b.get()).k((MotionEvent) objArr[0]);
            } else if (length == 3) {
                ((amv) this.b.get()).l(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.h.clear();
    }

    private static final Context i(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final void j() {
        this.b.set(anc.j(this.f.b(), i(this.c), this.f.c()));
    }

    public final amv a() {
        return (amv) this.b.get();
    }

    public final /* synthetic */ void c() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ams.a(this.f.b(), i(this.c), this.f.c(), this.g).o();
        } catch (NullPointerException e) {
            this.d.c(2027, System.currentTimeMillis() - currentTimeMillis, e);
        }
    }

    @Deprecated
    public final String e(Context context, String str, View view, Activity activity) {
        if (!s()) {
            return "";
        }
        d();
        return ((amv) this.b.get()).e(i(context), str, view, activity);
    }

    public final String f(Context context) {
        return g(context, null);
    }

    public final String g(Context context, byte[] bArr) {
        if (!s()) {
            return "";
        }
        d();
        return ((amv) this.b.get()).f(i(context));
    }

    public final String h(Context context, View view, Activity activity) {
        return s() ? ((amv) this.b.get()).h(context, view, activity) : "";
    }

    public final void k(MotionEvent motionEvent) {
        if (this.b.get() == null) {
            this.h.add(new Object[]{motionEvent});
        } else {
            d();
            ((amv) this.b.get()).k(motionEvent);
        }
    }

    public final void l(int i, int i2, int i3) {
        if (this.b.get() == null) {
            this.h.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            d();
            ((amv) this.b.get()).l(i, i2, i3);
        }
    }

    public final void n(View view) {
        if (this.b.get() != null) {
            ((amv) this.b.get()).n(view);
        }
    }

    public final boolean q() {
        return this.a.getCount() == 0 && this.b.get() != null && ((amv) this.b.get()).q();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9 A[Catch: all -> 0x0018, NullPointerException -> 0x001b, TRY_ENTER, TryCatch #0 {NullPointerException -> 0x001b, blocks: (B:4:0x0005, B:8:0x0015, B:9:0x0050, B:17:0x0059, B:19:0x007e, B:21:0x0086, B:22:0x008a, B:24:0x0097, B:25:0x00a9, B:26:0x001e, B:28:0x0045, B:31:0x004e, B:32:0x00aa), top: B:3:0x0005, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            int r3 = com.google.ads.interactivemedia.v3.internal.afg.a     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            com.google.ads.interactivemedia.v3.internal.aff r3 = r10.f     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            int r3 = r3.j()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            int r4 = r3 + (-1)
            if (r3 == 0) goto Laa
            r3 = 1
            r5 = 2
            if (r4 == r5) goto L1e
        L15:
            int r4 = com.google.ads.interactivemedia.v3.internal.afg.b     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            goto L50
        L18:
            r0 = move-exception
            goto Lc3
        L1b:
            r3 = move-exception
            goto Lab
        L1e:
            android.content.Context r4 = r10.c     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            com.google.ads.interactivemedia.v3.internal.aru r6 = r10.d     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            com.google.ads.interactivemedia.v3.internal.amz r7 = new com.google.ads.interactivemedia.v3.internal.amz     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            r8 = 0
            r7.<init>(r10, r8)     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            com.google.ads.interactivemedia.v3.internal.asv r8 = new com.google.ads.interactivemedia.v3.internal.asv     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            android.content.Context r9 = r10.c     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            int r4 = com.google.ads.interactivemedia.v3.impl.data.aq.d(r4, r6)     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            com.google.ads.interactivemedia.v3.internal.aqj r6 = com.google.ads.interactivemedia.v3.internal.aqo.b     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            java.lang.Object r6 = r6.f()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            r8.<init>(r9, r4, r7, r6)     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            boolean r4 = r8.d(r3)     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            if (r4 != 0) goto L4e
            com.google.ads.interactivemedia.v3.internal.aff r4 = r10.f     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            boolean r4 = r4.e()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            if (r4 == 0) goto L4e
            goto L15
        L4e:
            int r4 = com.google.ads.interactivemedia.v3.internal.afg.c     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
        L50:
            int r6 = r4 + (-1)
            if (r4 == 0) goto La9
            if (r6 == r3) goto L8a
            if (r6 == r5) goto L59
            goto La1
        L59:
            com.google.ads.interactivemedia.v3.internal.aff r3 = r10.f     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            java.lang.String r3 = r3.b()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            android.content.Context r4 = r10.c     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            android.content.Context r4 = i(r4)     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            java.util.concurrent.Executor r5 = r10.e     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            com.google.ads.interactivemedia.v3.internal.aff r6 = r10.f     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            boolean r6 = r6.c()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            boolean r7 = r10.g     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            com.google.ads.interactivemedia.v3.internal.ams r3 = com.google.ads.interactivemedia.v3.internal.ams.b(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            java.util.concurrent.atomic.AtomicReference r4 = r10.b     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            r4.set(r3)     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            boolean r3 = r3.r()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            if (r3 != 0) goto La1
            com.google.ads.interactivemedia.v3.internal.aff r3 = r10.f     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            boolean r3 = r3.e()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            if (r3 == 0) goto La1
            r10.j()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            goto La1
        L8a:
            r10.j()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            com.google.ads.interactivemedia.v3.internal.aff r3 = r10.f     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            int r3 = r3.j()     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            int r4 = com.google.ads.interactivemedia.v3.internal.afg.c     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            if (r3 != r4) goto La1
            java.util.concurrent.Executor r3 = r10.e     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            com.google.ads.interactivemedia.v3.internal.amy r4 = new com.google.ads.interactivemedia.v3.internal.amy     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            r4.<init>(r10)     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
            r3.execute(r4)     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
        La1:
            r10.c = r2
            java.util.concurrent.CountDownLatch r0 = r10.a
            r0.countDown()
            return
        La9:
            throw r2     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
        Laa:
            throw r2     // Catch: java.lang.Throwable -> L18 java.lang.NullPointerException -> L1b
        Lab:
            com.google.ads.interactivemedia.v3.internal.aff r4 = r10.f     // Catch: java.lang.Throwable -> L18
            boolean r4 = r4.e()     // Catch: java.lang.Throwable -> L18
            if (r4 == 0) goto Lb6
            r10.j()     // Catch: java.lang.Throwable -> L18
        Lb6:
            com.google.ads.interactivemedia.v3.internal.aru r4 = r10.d     // Catch: java.lang.Throwable -> L18
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L18
            long r5 = r5 - r0
            r0 = 2031(0x7ef, float:2.846E-42)
            r4.c(r0, r5, r3)     // Catch: java.lang.Throwable -> L18
            goto La1
        Lc3:
            r10.c = r2
            java.util.concurrent.CountDownLatch r1 = r10.a
            r1.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ana.run():void");
    }

    public final boolean s() {
        try {
            this.a.await();
            if (this.b.get() != null) {
                return ((amv) this.b.get()).s();
            }
            return false;
        } catch (InterruptedException unused) {
            return false;
        }
    }
}
