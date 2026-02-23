package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ano implements Application.ActivityLifecycleCallbacks {
    private final Application a;
    private final WeakReference b;
    private boolean c = false;

    public ano(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.b = new WeakReference(activityLifecycleCallbacks);
        this.a = application;
    }

    public final void a(ann annVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.b.get();
            if (activityLifecycleCallbacks != null) {
                annVar.a(activityLifecycleCallbacks);
            } else {
                if (this.c) {
                    return;
                }
                this.a.unregisterActivityLifecycleCallbacks(this);
                this.c = true;
            }
        } catch (Exception unused) {
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new anm(activity, bundle, 1));
    }

    public final void onActivityDestroyed(Activity activity) {
        a(new anl(activity, 4));
    }

    public final void onActivityPaused(Activity activity) {
        a(new anl(activity, 2));
    }

    public final void onActivityResumed(Activity activity) {
        a(new anl(activity, 0));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new anm(activity, bundle, 0));
    }

    public final void onActivityStarted(Activity activity) {
        a(new anl(activity, 1));
    }

    public final void onActivityStopped(Activity activity) {
        a(new anl(activity, 3));
    }
}
