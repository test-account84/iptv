package com.amazonaws.mobileconnectors.appsync;

import android.util.Log;
import androidx.lifecycle.j;
import androidx.lifecycle.o;
import androidx.lifecycle.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AWSAppSyncAppLifecycleObserver implements o {
    private static final String TAG = AWSAppSyncDeltaSync.class.getSimpleName();

    @w(j.b.ON_START)
    public void startSomething() {
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Delta Sync: App is in FOREGROUND");
        AWSAppSyncDeltaSync.handleAppForeground();
    }

    @w(j.b.ON_STOP)
    public void stopSomething() {
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Delta Sync: App is in BACKGROUND");
        AWSAppSyncDeltaSync.handleAppBackground();
    }
}
