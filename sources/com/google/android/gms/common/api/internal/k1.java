package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k1 implements Runnable {
    public final /* synthetic */ LifecycleCallback a;
    public final /* synthetic */ String c;
    public final /* synthetic */ l1 d;

    public k1(l1 l1Var, LifecycleCallback lifecycleCallback, String str) {
        this.d = l1Var;
        this.a = lifecycleCallback;
        this.c = str;
    }

    public final void run() {
        Bundle bundle;
        l1 l1Var = this.d;
        if (l1.a(l1Var) > 0) {
            LifecycleCallback lifecycleCallback = this.a;
            if (l1.b(l1Var) != null) {
                bundle = l1.b(l1Var).getBundle(this.c);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (l1.a(this.d) >= 2) {
            this.a.onStart();
        }
        if (l1.a(this.d) >= 3) {
            this.a.onResume();
        }
        if (l1.a(this.d) >= 4) {
            this.a.onStop();
        }
        if (l1.a(this.d) >= 5) {
            this.a.onDestroy();
        }
    }
}
