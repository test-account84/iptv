package com.amplifyframework.storage.result;

import j$.util.Objects;
import java.net.URL;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class StorageGetUrlResult {
    private final URL url;

    private StorageGetUrlResult(URL url) {
        this.url = url;
    }

    public static StorageGetUrlResult fromUrl(URL url) {
        Objects.requireNonNull(url);
        return new StorageGetUrlResult(url);
    }

    public URL getUrl() {
        return this.url;
    }
}
