package com.amazonaws.mobileconnectors.appsync.subscription;

import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface SubscriptionClient {
    void close();

    void connect(SubscriptionClientCallback subscriptionClientCallback);

    Set getTopics();

    void setTransmitting(boolean z);

    void subscribe(String str, int i, SubscriptionCallback subscriptionCallback);

    void unsubscribe(String str);
}
