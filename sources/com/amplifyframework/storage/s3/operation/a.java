package com.amplifyframework.storage.s3.operation;

import com.amplifyframework.core.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ AWSS3StorageDownloadFileOperation a;

    public /* synthetic */ a(AWSS3StorageDownloadFileOperation aWSS3StorageDownloadFileOperation) {
        this.a = aWSS3StorageDownloadFileOperation;
    }

    public final void accept(Object obj) {
        AWSS3StorageDownloadFileOperation.a(this.a, (String) obj);
    }
}
