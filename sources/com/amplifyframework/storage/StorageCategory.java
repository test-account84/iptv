package com.amplifyframework.storage;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
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
public final class StorageCategory extends Category implements StorageCategoryBehavior {
    public StorageDownloadFileOperation downloadFile(String str, File file, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).downloadFile(str, file, consumer, consumer2);
    }

    public CategoryType getCategoryType() {
        return CategoryType.STORAGE;
    }

    public StorageGetUrlOperation getUrl(String str, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).getUrl(str, consumer, consumer2);
    }

    public StorageListOperation list(String str, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).list(str, consumer, consumer2);
    }

    public StorageRemoveOperation remove(String str, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).remove(str, consumer, consumer2);
    }

    public StorageUploadFileOperation uploadFile(String str, File file, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).uploadFile(str, file, consumer, consumer2);
    }

    public StorageUploadInputStreamOperation uploadInputStream(String str, InputStream inputStream, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).uploadInputStream(str, inputStream, consumer, consumer2);
    }

    public StorageDownloadFileOperation downloadFile(String str, File file, StorageDownloadFileOptions storageDownloadFileOptions, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).downloadFile(str, file, storageDownloadFileOptions, consumer, consumer2);
    }

    public StorageGetUrlOperation getUrl(String str, StorageGetUrlOptions storageGetUrlOptions, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).getUrl(str, storageGetUrlOptions, consumer, consumer2);
    }

    public StorageListOperation list(String str, StorageListOptions storageListOptions, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).list(str, storageListOptions, consumer, consumer2);
    }

    public StorageRemoveOperation remove(String str, StorageRemoveOptions storageRemoveOptions, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).remove(str, storageRemoveOptions, consumer, consumer2);
    }

    public StorageUploadFileOperation uploadFile(String str, File file, StorageUploadFileOptions storageUploadFileOptions, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).uploadFile(str, file, storageUploadFileOptions, consumer, consumer2);
    }

    public StorageUploadInputStreamOperation uploadInputStream(String str, InputStream inputStream, StorageUploadInputStreamOptions storageUploadInputStreamOptions, Consumer consumer, Consumer consumer2) {
        return ((StoragePlugin) getSelectedPlugin()).uploadInputStream(str, inputStream, storageUploadInputStreamOptions, consumer, consumer2);
    }

    public StorageDownloadFileOperation downloadFile(String str, File file, StorageDownloadFileOptions storageDownloadFileOptions, Consumer consumer, Consumer consumer2, Consumer consumer3) {
        return ((StoragePlugin) getSelectedPlugin()).downloadFile(str, file, storageDownloadFileOptions, consumer, consumer2, consumer3);
    }

    public StorageUploadFileOperation uploadFile(String str, File file, StorageUploadFileOptions storageUploadFileOptions, Consumer consumer, Consumer consumer2, Consumer consumer3) {
        return ((StoragePlugin) getSelectedPlugin()).uploadFile(str, file, storageUploadFileOptions, consumer, consumer2, consumer3);
    }

    public StorageUploadInputStreamOperation uploadInputStream(String str, InputStream inputStream, StorageUploadInputStreamOptions storageUploadInputStreamOptions, Consumer consumer, Consumer consumer2, Consumer consumer3) {
        return ((StoragePlugin) getSelectedPlugin()).uploadInputStream(str, inputStream, storageUploadInputStreamOptions, consumer, consumer2, consumer3);
    }
}
