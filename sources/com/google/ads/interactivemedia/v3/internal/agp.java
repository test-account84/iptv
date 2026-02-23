package com.google.ads.interactivemedia.v3.internal;

import android.app.Application;
import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class agp {
    private boolean a;

    public agp() {
    }

    public final void a(Context context) {
        com.google.ads.interactivemedia.v3.impl.data.i.e(context, "Application Context cannot be null");
        if (this.a) {
            return;
        }
        this.a = true;
        ahe.b().c(context);
        aha a = aha.a();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(a);
        }
        ahn.g(context);
        ahb.b().c(context);
    }

    public final boolean b() {
        return this.a;
    }

    public final synchronized void c() throws InterruptedException {
        while (!this.a) {
            wait();
        }
    }

    public final synchronized void d() {
        boolean z = false;
        while (!this.a) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean e() {
        return this.a;
    }

    public final synchronized boolean f() {
        if (this.a) {
            return false;
        }
        this.a = true;
        notifyAll();
        return true;
    }

    public final synchronized void g() {
        this.a = false;
    }

    public agp(byte[] bArr) {
    }
}
