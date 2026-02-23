package com.amplifyframework.hub;

import com.amplifyframework.hub.AWSHubPlugin;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ AWSHubPlugin.Subscription a;
    public final /* synthetic */ HubEvent c;

    public /* synthetic */ b(AWSHubPlugin.Subscription subscription, HubEvent hubEvent) {
        this.a = subscription;
        this.c = hubEvent;
    }

    public final void run() {
        AWSHubPlugin.a(this.a, this.c);
    }
}
