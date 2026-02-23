package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final c f = new c();
    public final AtomicBoolean a = new AtomicBoolean();
    public final AtomicBoolean c = new AtomicBoolean();
    public final ArrayList d = new ArrayList();
    public boolean e = false;

    public interface a {
        void a(boolean z);
    }

    public static c b() {
        return f;
    }

    public static void c(Application application) {
        c cVar = f;
        synchronized (cVar) {
            try {
                if (!cVar.e) {
                    application.registerActivityLifecycleCallbacks(cVar);
                    application.registerComponentCallbacks(cVar);
                    cVar.e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(a aVar) {
        synchronized (f) {
            this.d.add(aVar);
        }
    }

    public boolean d() {
        return this.a.get();
    }

    public boolean e(boolean z) {
        if (!this.c.get()) {
            if (!C4.m.b()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.a.set(true);
            }
        }
        return d();
    }

    public final void f(boolean z) {
        synchronized (f) {
            try {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.c;
        boolean compareAndSet = this.a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.c;
        boolean compareAndSet = this.a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.a.compareAndSet(false, true)) {
            this.c.set(true);
            f(true);
        }
    }
}
