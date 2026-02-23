package com.amplifyframework.storage.result;

import j$.util.Objects;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class StorageDownloadFileResult {
    private final File file;

    private StorageDownloadFileResult(File file) {
        this.file = file;
    }

    public static StorageDownloadFileResult fromFile(File file) {
        Objects.requireNonNull(file);
        return new StorageDownloadFileResult(file);
    }

    public File getFile() {
        return this.file;
    }
}
