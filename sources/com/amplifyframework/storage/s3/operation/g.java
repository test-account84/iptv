package com.amplifyframework.storage.s3.operation;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ AWSS3StorageRemoveOperation a;

    public /* synthetic */ g(AWSS3StorageRemoveOperation aWSS3StorageRemoveOperation) {
        this.a = aWSS3StorageRemoveOperation;
    }

    public final void run() {
        AWSS3StorageRemoveOperation.b(this.a);
    }
}
