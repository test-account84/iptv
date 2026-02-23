package com.amplifyframework.analytics;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.plugin.Plugin;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AnalyticsPlugin implements AnalyticsCategoryBehavior, Plugin {
    public final CategoryType getCategoryType() {
        return CategoryType.ANALYTICS;
    }

    public void initialize(Context context) throws AmplifyException {
    }
}
