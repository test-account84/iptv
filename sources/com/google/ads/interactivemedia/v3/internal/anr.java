package com.google.ads.interactivemedia.v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class anr extends BroadcastReceiver {
    private boolean a = true;

    public anr(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(this, intentFilter);
    }

    public final boolean a() {
        return this.a;
    }

    public final void onReceive(Context context, Intent intent) {
        boolean z;
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            z = true;
        } else if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            return;
        } else {
            z = false;
        }
        this.a = z;
    }
}
