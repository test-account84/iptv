package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m1 implements Runnable {
    public final /* synthetic */ LifecycleCallback a;
    public final /* synthetic */ String c;
    public final /* synthetic */ n1 d;

    public m1(n1 n1Var, LifecycleCallback lifecycleCallback, String str) {
        this.d = n1Var;
        this.a = lifecycleCallback;
        this.c = str;
    }

    public final void run() {
        Bundle bundle;
        n1 n1Var = this.d;
        if (n1.x(n1Var) > 0) {
            LifecycleCallback lifecycleCallback = this.a;
            if (n1.z(n1Var) != null) {
                bundle = n1.z(n1Var).getBundle(this.c);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (n1.x(this.d) >= 2) {
            this.a.onStart();
        }
        if (n1.x(this.d) >= 3) {
            this.a.onResume();
        }
        if (n1.x(this.d) >= 4) {
            this.a.onStop();
        }
        if (n1.x(this.d) >= 5) {
            this.a.onDestroy();
        }
    }
}
