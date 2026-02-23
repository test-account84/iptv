package com.amplifyframework.hub;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface HubCategoryBehavior {
    void publish(HubChannel hubChannel, HubEvent hubEvent) throws RuntimeException;

    SubscriptionToken subscribe(HubChannel hubChannel, HubEventFilter hubEventFilter, HubSubscriber hubSubscriber);

    SubscriptionToken subscribe(HubChannel hubChannel, HubSubscriber hubSubscriber);

    void unsubscribe(SubscriptionToken subscriptionToken);
}
