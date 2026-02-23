package com.facebook.ads.internal.util.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.facebook.ads.internal.shield.NoAutoExceptionHandling;
import j$.util.DesugarCollections;
import java.util.Map;
import java.util.WeakHashMap;

@NoAutoExceptionHandling
@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ANActivityLifecycleCallbacksListener implements Application.ActivityLifecycleCallbacks {
    public static final int ACTIVITY_CREATED = 1;
    public static final int ACTIVITY_DESTROYED = 6;
    public static final int ACTIVITY_PAUSED = 4;
    public static final int ACTIVITY_RESUMED = 3;
    public static final int ACTIVITY_STARTED = 2;
    public static final int ACTIVITY_STOPPED = 5;
    private static ANActivityLifecycleCallbacksListener sANActivityLifecycleCallbacksListener;
    private static final Map sActivityStateMap = DesugarCollections.synchronizedMap(new WeakHashMap());

    public static synchronized ANActivityLifecycleCallbacksListener getANActivityLifecycleCallbacksListener() {
        ANActivityLifecycleCallbacksListener aNActivityLifecycleCallbacksListener;
        synchronized (ANActivityLifecycleCallbacksListener.class) {
            aNActivityLifecycleCallbacksListener = sANActivityLifecycleCallbacksListener;
        }
        return aNActivityLifecycleCallbacksListener;
    }

    public static void registerActivityCallbacks(Context context) {
        Application applicationContext = context.getApplicationContext();
        synchronized (ANActivityLifecycleCallbacksListener.class) {
            try {
                if ((applicationContext instanceof Application) && sANActivityLifecycleCallbacksListener == null) {
                    ANActivityLifecycleCallbacksListener aNActivityLifecycleCallbacksListener = new ANActivityLifecycleCallbacksListener();
                    sANActivityLifecycleCallbacksListener = aNActivityLifecycleCallbacksListener;
                    applicationContext.registerActivityLifecycleCallbacks(aNActivityLifecycleCallbacksListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void unregisterActivityCallbacks(Context context) {
        Application applicationContext = context.getApplicationContext();
        synchronized (ANActivityLifecycleCallbacksListener.class) {
            try {
                if (applicationContext instanceof Application) {
                    applicationContext.unregisterActivityLifecycleCallbacks(sANActivityLifecycleCallbacksListener);
                    sANActivityLifecycleCallbacksListener = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Map getActivityStateMap() {
        return sActivityStateMap;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        sActivityStateMap.put(activity, 1);
    }

    public void onActivityDestroyed(Activity activity) {
        sActivityStateMap.put(activity, 6);
    }

    public void onActivityPaused(Activity activity) {
        sActivityStateMap.put(activity, 4);
    }

    public void onActivityResumed(Activity activity) {
        sActivityStateMap.put(activity, 3);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        sActivityStateMap.put(activity, 2);
    }

    public void onActivityStopped(Activity activity) {
        sActivityStateMap.put(activity, 5);
    }
}
