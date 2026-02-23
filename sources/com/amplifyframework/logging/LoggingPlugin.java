package com.amplifyframework.logging;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.plugin.Plugin;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class LoggingPlugin implements LoggingCategoryBehavior, Plugin {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoggingPlugin) {
            return getPluginKey().equals(((LoggingPlugin) obj).getPluginKey());
        }
        return false;
    }

    public final CategoryType getCategoryType() {
        return CategoryType.LOGGING;
    }

    public final int hashCode() {
        return getPluginKey().hashCode();
    }

    public void initialize(Context context) throws AmplifyException {
    }
}
