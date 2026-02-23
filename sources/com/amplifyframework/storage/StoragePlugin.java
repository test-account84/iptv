package com.amplifyframework.storage;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.plugin.Plugin;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class StoragePlugin implements StorageCategoryBehavior, Plugin {
    public final CategoryType getCategoryType() {
        return CategoryType.STORAGE;
    }

    public void initialize(Context context) throws AmplifyException {
    }
}
