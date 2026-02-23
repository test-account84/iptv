package com.amazonaws.mobile.client;

import com.amazonaws.mobile.client.internal.InternalCallback;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ AWSMobileClient a;
    public final /* synthetic */ InternalCallback c;

    public /* synthetic */ a(AWSMobileClient aWSMobileClient, InternalCallback internalCallback) {
        this.a = aWSMobileClient;
        this.c = internalCallback;
    }

    public final void run() {
        AWSMobileClient.a(this.a, this.c);
    }
}
