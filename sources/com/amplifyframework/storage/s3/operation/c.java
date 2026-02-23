package com.amplifyframework.storage.s3.operation;

import com.amplifyframework.core.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class c implements Consumer {
    public final /* synthetic */ AWSS3StorageGetPresignedUrlOperation a;

    public /* synthetic */ c(AWSS3StorageGetPresignedUrlOperation aWSS3StorageGetPresignedUrlOperation) {
        this.a = aWSS3StorageGetPresignedUrlOperation;
    }

    public final void accept(Object obj) {
        AWSS3StorageGetPresignedUrlOperation.a(this.a, (String) obj);
    }
}
