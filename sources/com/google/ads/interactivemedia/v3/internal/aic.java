package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aic implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ aid a;

    public aic(aid aidVar) {
        this.a = aidVar;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        aid aidVar = this.a;
        if (aid.a(aidVar) == activity) {
            aid.e(aidVar, null);
            this.a.k();
        }
    }

    public final void onActivityPaused(Activity activity) {
        aid aidVar = this.a;
        if (aid.a(aidVar) == null || aid.a(aidVar) == activity) {
            aid.e(aidVar, activity);
            aid.b(this.a).o(new ajr(ajp.activityMonitor, ajq.appStateChanged, aid.d(this.a), this.a.c("", "", "inactive")));
        }
    }

    public final void onActivityResumed(Activity activity) {
        aid aidVar = this.a;
        if (aid.a(aidVar) == activity) {
            aid.b(this.a).o(new ajr(ajp.activityMonitor, ajq.appStateChanged, aid.d(this.a), aidVar.c("", "", "active")));
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
