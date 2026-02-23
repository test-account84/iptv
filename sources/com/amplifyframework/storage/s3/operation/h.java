package com.amplifyframework.storage.s3.operation;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amplifyframework.core.Consumer;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class h implements Consumer {
    public final /* synthetic */ AWSS3StorageUploadFileOperation a;
    public final /* synthetic */ File b;
    public final /* synthetic */ ObjectMetadata c;

    public /* synthetic */ h(AWSS3StorageUploadFileOperation aWSS3StorageUploadFileOperation, File file, ObjectMetadata objectMetadata) {
        this.a = aWSS3StorageUploadFileOperation;
        this.b = file;
        this.c = objectMetadata;
    }

    public final void accept(Object obj) {
        AWSS3StorageUploadFileOperation.a(this.a, this.b, this.c, (String) obj);
    }
}
