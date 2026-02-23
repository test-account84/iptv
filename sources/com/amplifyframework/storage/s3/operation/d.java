package com.amplifyframework.storage.s3.operation;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ AWSS3StorageListOperation a;

    public /* synthetic */ d(AWSS3StorageListOperation aWSS3StorageListOperation) {
        this.a = aWSS3StorageListOperation;
    }

    public final void run() {
        AWSS3StorageListOperation.a(this.a);
    }
}
