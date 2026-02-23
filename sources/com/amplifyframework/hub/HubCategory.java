package com.amplifyframework.hub;

import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class HubCategory extends Category implements HubCategoryBehavior {
    private final HubPlugin defaultPlugin = new AWSHubPlugin();

    private HubPlugin getHubPlugin() {
        return (!super.isInitialized() || super.getPlugins().isEmpty()) ? this.defaultPlugin : (HubPlugin) super.getSelectedPlugin();
    }

    public CategoryType getCategoryType() {
        return CategoryType.HUB;
    }

    public void publish(HubChannel hubChannel, HubEvent hubEvent) {
        getHubPlugin().publish(hubChannel, hubEvent);
    }

    public SubscriptionToken subscribe(HubChannel hubChannel, HubEventFilter hubEventFilter, HubSubscriber hubSubscriber) {
        return getHubPlugin().subscribe(hubChannel, hubEventFilter, hubSubscriber);
    }

    public void unsubscribe(SubscriptionToken subscriptionToken) {
        getHubPlugin().unsubscribe(subscriptionToken);
    }

    public SubscriptionToken subscribe(HubChannel hubChannel, HubSubscriber hubSubscriber) {
        return getHubPlugin().subscribe(hubChannel, hubSubscriber);
    }
}
