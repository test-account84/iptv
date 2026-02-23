package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class cm implements bv {
    private static final List a = new ArrayList(50);
    private final Handler b;

    public cm(Handler handler) {
        this.b = handler;
    }

    public static /* bridge */ /* synthetic */ void k(cl clVar) {
        List list = a;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(clVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static cl l() {
        cl clVar;
        List list = a;
        synchronized (list) {
            try {
                clVar = list.isEmpty() ? new cl(null) : (cl) list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return clVar;
    }

    public final bu a(int i) {
        cl l = l();
        l.c(this.b.obtainMessage(i));
        return l;
    }

    public final bu b(int i, Object obj) {
        cl l = l();
        l.c(this.b.obtainMessage(i, obj));
        return l;
    }

    public final boolean c() {
        return this.b.hasMessages(0);
    }

    public final bu d(int i, int i2) {
        cl l = l();
        l.c(this.b.obtainMessage(1, i, i2));
        return l;
    }

    public final void e(Runnable runnable) {
        this.b.post(runnable);
    }

    public final void f() {
        this.b.removeCallbacksAndMessages((Object) null);
    }

    public final void g() {
        this.b.removeMessages(2);
    }

    public final void h(int i) {
        this.b.sendEmptyMessage(i);
    }

    public final void i(long j) {
        this.b.sendEmptyMessageAtTime(2, j);
    }

    public final void j(bu buVar) {
        ((cl) buVar).b(this.b);
    }
}
