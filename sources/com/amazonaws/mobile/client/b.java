package com.amazonaws.mobile.client;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ AWSMobileClient a;
    public final /* synthetic */ Callback c;

    public /* synthetic */ b(AWSMobileClient aWSMobileClient, Callback callback) {
        this.a = aWSMobileClient;
        this.c = callback;
    }

    public final void run() {
        AWSMobileClient.b(this.a, this.c);
    }
}
