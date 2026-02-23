package com.amplifyframework.hub;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ AWSHubPlugin a;
    public final /* synthetic */ HubChannel c;
    public final /* synthetic */ HubEvent d;

    public /* synthetic */ a(AWSHubPlugin aWSHubPlugin, HubChannel hubChannel, HubEvent hubEvent) {
        this.a = aWSHubPlugin;
        this.c = hubChannel;
        this.d = hubEvent;
    }

    public final void run() {
        AWSHubPlugin.b(this.a, this.c, this.d);
    }
}
