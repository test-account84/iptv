package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class anl implements ann {
    final /* synthetic */ Activity a;
    private final /* synthetic */ int b;

    public anl(Activity activity, int i) {
        this.b = i;
        this.a = activity;
    }

    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        int i = this.b;
        if (i == 0) {
            activityLifecycleCallbacks.onActivityResumed(this.a);
            return;
        }
        if (i == 1) {
            activityLifecycleCallbacks.onActivityStarted(this.a);
            return;
        }
        if (i == 2) {
            activityLifecycleCallbacks.onActivityPaused(this.a);
        } else if (i != 3) {
            activityLifecycleCallbacks.onActivityDestroyed(this.a);
        } else {
            activityLifecycleCallbacks.onActivityStopped(this.a);
        }
    }
}
