package com.amazonaws.mobileconnectors.appsync.subscription;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface SubscriptionCallback {
    void onError(String str, Exception exc);

    void onMessage(String str, String str2);
}
