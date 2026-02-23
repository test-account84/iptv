package com.amplifyframework.storage.operation;

import com.amplifyframework.core.async.AmplifyOperation;
import com.amplifyframework.core.async.Cancelable;
import com.amplifyframework.core.async.Resumable;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class StorageUploadOperation extends AmplifyOperation implements Resumable, Cancelable {
    public StorageUploadOperation(Object obj) {
        super(CategoryType.STORAGE, obj);
    }
}
