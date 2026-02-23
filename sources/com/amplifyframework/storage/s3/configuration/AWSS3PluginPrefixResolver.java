package com.amplifyframework.storage.s3.configuration;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageAccessLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AWSS3PluginPrefixResolver {
    void resolvePrefix(@NotNull StorageAccessLevel storageAccessLevel, @Nullable String str, @NotNull Consumer consumer, @NotNull Consumer consumer2);
}
