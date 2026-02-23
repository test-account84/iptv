package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ch {
    private static ch a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    private final Object d = new Object();
    private int e = 0;

    private ch(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        cq.au(context, new cg(this), intentFilter);
    }

    public static synchronized ch b(Context context) {
        ch chVar;
        synchronized (ch.class) {
            try {
                if (a == null) {
                    a = new ch(context);
                }
                chVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return chVar;
    }

    public static /* bridge */ /* synthetic */ void c(ch chVar, int i) {
        synchronized (chVar.d) {
            try {
                if (chVar.e == i) {
                    return;
                }
                chVar.e = i;
                Iterator it = chVar.c.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    xv xvVar = (xv) weakReference.get();
                    if (xvVar != null) {
                        xvVar.b(i);
                    } else {
                        chVar.c.remove(weakReference);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int a() {
        int i;
        synchronized (this.d) {
            i = this.e;
        }
        return i;
    }

    public final void d(xv xvVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                this.c.remove(weakReference);
            }
        }
        this.c.add(new WeakReference(xvVar));
        this.b.post(new jc(this, xvVar, 1, (byte[]) null));
    }
}
