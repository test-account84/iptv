package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class anm implements ann {
    final /* synthetic */ Activity a;
    final /* synthetic */ Bundle b;
    private final /* synthetic */ int c;

    public anm(Activity activity, Bundle bundle, int i) {
        this.c = i;
        this.a = activity;
        this.b = bundle;
    }

    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (this.c != 0) {
            activityLifecycleCallbacks.onActivityCreated(this.a, this.b);
        } else {
            activityLifecycleCallbacks.onActivitySaveInstanceState(this.a, this.b);
        }
    }
}
