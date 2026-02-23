package com.amplifyframework.storage.s3.operation;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amplifyframework.core.Consumer;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class i implements Consumer {
    public final /* synthetic */ AWSS3StorageUploadInputStreamOperation a;
    public final /* synthetic */ InputStream b;
    public final /* synthetic */ ObjectMetadata c;

    public /* synthetic */ i(AWSS3StorageUploadInputStreamOperation aWSS3StorageUploadInputStreamOperation, InputStream inputStream, ObjectMetadata objectMetadata) {
        this.a = aWSS3StorageUploadInputStreamOperation;
        this.b = inputStream;
        this.c = objectMetadata;
    }

    public final void accept(Object obj) {
        AWSS3StorageUploadInputStreamOperation.a(this.a, this.b, this.c, (String) obj);
    }
}
