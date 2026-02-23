package com.amplifyframework.api;

import com.amplifyframework.core.async.AmplifyOperation;
import com.amplifyframework.core.async.Cancelable;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class ApiOperation extends AmplifyOperation implements Cancelable {
    public ApiOperation(Object obj) {
        super(CategoryType.API, obj);
    }
}
