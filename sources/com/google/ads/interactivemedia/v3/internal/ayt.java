package com.google.ads.interactivemedia.v3.internal;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ayt {
    private final Object a;

    public ayt() {
        this.a = new HashMap();
    }

    public final azd a(Callable callable, Executor executor) {
        return new aym((avi) this.a, executor, callable);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.Map] */
    public final AtomicReference b(String str) {
        synchronized (this) {
            try {
                if (!this.a.containsKey(str)) {
                    this.a.put(str, new AtomicReference());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return (AtomicReference) this.a.get(str);
    }

    public /* synthetic */ ayt(avo avoVar) {
        this.a = avoVar;
    }
}
