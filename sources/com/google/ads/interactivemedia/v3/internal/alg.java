package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class alg implements Application.ActivityLifecycleCallbacks {
    private final Application a;
    private final List b = new ArrayList();

    public alg(Application application) {
        this.a = application;
        application.registerActivityLifecycleCallbacks(this);
    }

    public final void a(alf alfVar) {
        this.b.add(alfVar);
    }

    public final void b() {
        this.a.unregisterActivityLifecycleCallbacks(this);
        this.b.clear();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((alf) it.next()).d();
        }
    }

    public final void onActivityResumed(Activity activity) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((alf) it.next()).e();
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
