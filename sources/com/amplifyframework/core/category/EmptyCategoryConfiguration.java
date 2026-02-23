package com.amplifyframework.core.category;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class EmptyCategoryConfiguration extends CategoryConfiguration {
    private final CategoryType categoryType;

    private EmptyCategoryConfiguration(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public static EmptyCategoryConfiguration forCategoryType(CategoryType categoryType) {
        return new EmptyCategoryConfiguration(categoryType);
    }

    public CategoryType getCategoryType() {
        return this.categoryType;
    }
}
