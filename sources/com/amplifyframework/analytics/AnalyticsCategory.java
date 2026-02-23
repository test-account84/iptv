package com.amplifyframework.analytics;

import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AnalyticsCategory extends Category implements AnalyticsCategoryBehavior {
    private boolean enabled = true;

    public void disable() {
        this.enabled = false;
        ((AnalyticsPlugin) getSelectedPlugin()).disable();
    }

    public void enable() {
        this.enabled = true;
        ((AnalyticsPlugin) getSelectedPlugin()).enable();
    }

    public void flushEvents() {
        if (this.enabled) {
            ((AnalyticsPlugin) getSelectedPlugin()).flushEvents();
        }
    }

    public CategoryType getCategoryType() {
        return CategoryType.ANALYTICS;
    }

    public void identifyUser(String str, UserProfile userProfile) {
        if (this.enabled) {
            ((AnalyticsPlugin) getSelectedPlugin()).identifyUser(str, userProfile);
        }
    }

    public void recordEvent(AnalyticsEventBehavior analyticsEventBehavior) {
        if (this.enabled) {
            ((AnalyticsPlugin) getSelectedPlugin()).recordEvent(analyticsEventBehavior);
        }
    }

    public void registerGlobalProperties(AnalyticsProperties analyticsProperties) {
        ((AnalyticsPlugin) getSelectedPlugin()).registerGlobalProperties(analyticsProperties);
    }

    public void unregisterGlobalProperties(String... strArr) {
        ((AnalyticsPlugin) getSelectedPlugin()).unregisterGlobalProperties(strArr);
    }

    public void recordEvent(String str) {
        if (this.enabled) {
            ((AnalyticsPlugin) getSelectedPlugin()).recordEvent(str);
        }
    }
}
