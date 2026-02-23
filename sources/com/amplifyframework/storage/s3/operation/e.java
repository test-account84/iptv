package com.amplifyframework.storage.s3.operation;

import com.amplifyframework.core.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class e implements Consumer {
    public final /* synthetic */ AWSS3StorageListOperation a;

    public /* synthetic */ e(AWSS3StorageListOperation aWSS3StorageListOperation) {
        this.a = aWSS3StorageListOperation;
    }

    public final void accept(Object obj) {
        AWSS3StorageListOperation.b(this.a, (String) obj);
    }
}
