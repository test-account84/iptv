package com.amplifyframework.logging;

import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.util.Environment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class LoggingCategory extends Category implements LoggingCategoryBehavior {
    private final LoggingPlugin defaultPlugin;

    public LoggingCategory() {
        this(Environment.isJUnitTest() ? new JavaLoggingPlugin() : new AndroidLoggingPlugin());
    }

    public Logger forNamespace(String str) {
        HashSet hashSet = new HashSet(getPlugins());
        hashSet.add(this.defaultPlugin);
        ArrayList arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((LoggingPlugin) it.next()).forNamespace(str));
        }
        return new BroadcastLogger(arrayList);
    }

    public CategoryType getCategoryType() {
        return CategoryType.LOGGING;
    }

    public LoggingCategory(LoggingPlugin loggingPlugin) {
        this.defaultPlugin = loggingPlugin;
    }

    public LoggingPlugin getSelectedPlugin() throws IllegalStateException {
        throw new UnsupportedOperationException("Getting the selected logging plugin is not supported.");
    }
}
