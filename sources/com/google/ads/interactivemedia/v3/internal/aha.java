package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aha implements Application.ActivityLifecycleCallbacks {

    @SuppressLint({"StaticFieldLeak"})
    private static final aha a = new aha();
    private boolean b;
    private boolean c;
    private ahe d;

    private aha() {
    }

    public static aha a() {
        return a;
    }

    private final void e() {
        boolean z = this.c;
        Iterator it = agz.a().c().iterator();
        while (it.hasNext()) {
            ahi h = ((agt) it.next()).h();
            if (h.k()) {
                ahd.a().b(h.a(), "setState", true != z ? "foregrounded" : "backgrounded");
            }
        }
    }

    private final void f(boolean z) {
        if (this.c != z) {
            this.c = z;
            if (this.b) {
                e();
                if (this.d != null) {
                    if (!z) {
                        aht.c().h();
                    } else {
                        aht.c().g();
                    }
                }
            }
        }
    }

    public final void b() {
        this.b = true;
        this.c = false;
        e();
    }

    public final void c() {
        this.b = false;
        this.c = false;
        this.d = null;
    }

    public final void d(ahe aheVar) {
        this.d = aheVar;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        f(false);
    }

    public final void onActivityStopped(Activity activity) {
        View g;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        int i = runningAppProcessInfo.importance;
        boolean z = true;
        for (agt agtVar : agz.a().b()) {
            if (agtVar.k() && (g = agtVar.g()) != null && g.hasWindowFocus()) {
                z = false;
            }
        }
        f(i != 100 && z);
    }
}
