package com.amplifyframework.storage.s3.operation;

import com.amplifyframework.core.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class f implements Consumer {
    public final /* synthetic */ AWSS3StorageRemoveOperation a;

    public /* synthetic */ f(AWSS3StorageRemoveOperation aWSS3StorageRemoveOperation) {
        this.a = aWSS3StorageRemoveOperation;
    }

    public final void accept(Object obj) {
        AWSS3StorageRemoveOperation.a(this.a, (String) obj);
    }
}
