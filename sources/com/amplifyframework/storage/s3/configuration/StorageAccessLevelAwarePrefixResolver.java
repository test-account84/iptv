package com.amplifyframework.storage.s3.configuration;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageAccessLevel;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.s3.CognitoAuthProvider;
import com.amplifyframework.storage.s3.utils.S3Keys;
import k8.j;
import k8.k;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class StorageAccessLevelAwarePrefixResolver implements AWSS3PluginPrefixResolver {
    private final CognitoAuthProvider cognitoAuthProvider;

    public StorageAccessLevelAwarePrefixResolver(@NotNull CognitoAuthProvider cognitoAuthProvider) {
        l.e(cognitoAuthProvider, "cognitoAuthProvider");
        this.cognitoAuthProvider = cognitoAuthProvider;
    }

    public void resolvePrefix(@NotNull StorageAccessLevel storageAccessLevel, @Nullable String str, @NotNull Consumer consumer, @NotNull Consumer consumer2) {
        Object obj;
        l.e(storageAccessLevel, "accessLevel");
        l.e(consumer, "onSuccess");
        l.e(consumer2, "onError");
        try {
            j.a aVar = j.c;
            obj = j.b(this.cognitoAuthProvider.getIdentityId());
        } catch (Throwable th) {
            j.a aVar2 = j.c;
            obj = j.b(k.a(th));
        }
        if (j.g(obj)) {
            if (str == null) {
                k.b(obj);
                str = (String) obj;
            }
            consumer.accept(S3Keys.getAccessLevelPrefix(storageAccessLevel, str));
            return;
        }
        StorageException d = j.d(obj);
        if (d == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.amplifyframework.storage.StorageException");
        }
        consumer2.accept(d);
    }
}
