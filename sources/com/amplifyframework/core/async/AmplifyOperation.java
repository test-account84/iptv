package com.amplifyframework.core.async;

import com.amplifyframework.core.category.CategoryType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AmplifyOperation {
    private final CategoryType categoryType;
    private final Object request;

    public AmplifyOperation(CategoryType categoryType, Object obj) {
        this.categoryType = categoryType;
        this.request = obj;
    }

    public final CategoryType getCategoryType() {
        return this.categoryType;
    }

    public Object getRequest() {
        return this.request;
    }

    public abstract void start();
}
