package com.google.ads.interactivemedia.v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class hr extends BroadcastReceiver {
    final /* synthetic */ hs a;

    public /* synthetic */ hr(hs hsVar) {
        this.a = hsVar;
    }

    public final void onReceive(Context context, Intent intent) {
        hs hsVar = this.a;
        hs.c(hsVar).post(new hq(hsVar));
    }
}
