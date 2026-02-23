package com.amplifyframework.storage;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.operation.StorageDownloadFileOperation;
import com.amplifyframework.storage.operation.StorageGetUrlOperation;
import com.amplifyframework.storage.operation.StorageListOperation;
import com.amplifyframework.storage.operation.StorageRemoveOperation;
import com.amplifyframework.storage.operation.StorageUploadFileOperation;
import com.amplifyframework.storage.operation.StorageUploadInputStreamOperation;
import com.amplifyframework.storage.options.StorageDownloadFileOptions;
import com.amplifyframework.storage.options.StorageGetUrlOptions;
import com.amplifyframework.storage.options.StorageListOptions;
import com.amplifyframework.storage.options.StorageRemoveOptions;
import com.amplifyframework.storage.options.StorageUploadFileOptions;
import com.amplifyframework.storage.options.StorageUploadInputStreamOptions;
import java.io.File;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface StorageCategoryBehavior {
    StorageDownloadFileOperation downloadFile(String str, File file, Consumer consumer, Consumer consumer2);

    StorageDownloadFileOperation downloadFile(String str, File file, StorageDownloadFileOptions storageDownloadFileOptions, Consumer consumer, Consumer consumer2);

    StorageDownloadFileOperation downloadFile(String str, File file, StorageDownloadFileOptions storageDownloadFileOptions, Consumer consumer, Consumer consumer2, Consumer consumer3);

    StorageGetUrlOperation getUrl(String str, Consumer consumer, Consumer consumer2);

    StorageGetUrlOperation getUrl(String str, StorageGetUrlOptions storageGetUrlOptions, Consumer consumer, Consumer consumer2);

    StorageListOperation list(String str, Consumer consumer, Consumer consumer2);

    StorageListOperation list(String str, StorageListOptions storageListOptions, Consumer consumer, Consumer consumer2);

    StorageRemoveOperation remove(String str, Consumer consumer, Consumer consumer2);

    StorageRemoveOperation remove(String str, StorageRemoveOptions storageRemoveOptions, Consumer consumer, Consumer consumer2);

    StorageUploadFileOperation uploadFile(String str, File file, Consumer consumer, Consumer consumer2);

    StorageUploadFileOperation uploadFile(String str, File file, StorageUploadFileOptions storageUploadFileOptions, Consumer consumer, Consumer consumer2);

    StorageUploadFileOperation uploadFile(String str, File file, StorageUploadFileOptions storageUploadFileOptions, Consumer consumer, Consumer consumer2, Consumer consumer3);

    StorageUploadInputStreamOperation uploadInputStream(String str, InputStream inputStream, Consumer consumer, Consumer consumer2);

    StorageUploadInputStreamOperation uploadInputStream(String str, InputStream inputStream, StorageUploadInputStreamOptions storageUploadInputStreamOptions, Consumer consumer, Consumer consumer2);

    StorageUploadInputStreamOperation uploadInputStream(String str, InputStream inputStream, StorageUploadInputStreamOptions storageUploadInputStreamOptions, Consumer consumer, Consumer consumer2, Consumer consumer3);
}
