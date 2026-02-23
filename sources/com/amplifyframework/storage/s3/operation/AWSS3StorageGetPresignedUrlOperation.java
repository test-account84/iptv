package com.amplifyframework.storage.s3.operation;

import android.annotation.SuppressLint;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.operation.StorageGetUrlOperation;
import com.amplifyframework.storage.result.StorageGetUrlResult;
import com.amplifyframework.storage.s3.CognitoAuthProvider;
import com.amplifyframework.storage.s3.configuration.AWSS3StoragePluginConfiguration;
import com.amplifyframework.storage.s3.request.AWSS3StorageGetPresignedUrlRequest;
import com.amplifyframework.storage.s3.service.StorageService;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageGetPresignedUrlOperation extends StorageGetUrlOperation {
    private final AWSS3StoragePluginConfiguration awsS3StoragePluginConfiguration;
    private final CognitoAuthProvider cognitoAuthProvider;
    private final ExecutorService executorService;
    private final Consumer onError;
    private final Consumer onSuccess;
    private final StorageService storageService;

    public AWSS3StorageGetPresignedUrlOperation(StorageService storageService, ExecutorService executorService, CognitoAuthProvider cognitoAuthProvider, AWSS3StorageGetPresignedUrlRequest aWSS3StorageGetPresignedUrlRequest, AWSS3StoragePluginConfiguration aWSS3StoragePluginConfiguration, Consumer consumer, Consumer consumer2) {
        super(aWSS3StorageGetPresignedUrlRequest);
        this.storageService = storageService;
        this.executorService = executorService;
        this.cognitoAuthProvider = cognitoAuthProvider;
        this.awsS3StoragePluginConfiguration = aWSS3StoragePluginConfiguration;
        this.onSuccess = consumer;
        this.onError = consumer2;
    }

    public static /* synthetic */ void a(AWSS3StorageGetPresignedUrlOperation aWSS3StorageGetPresignedUrlOperation, String str) {
        aWSS3StorageGetPresignedUrlOperation.lambda$null$0(str);
    }

    public static /* synthetic */ void b(AWSS3StorageGetPresignedUrlOperation aWSS3StorageGetPresignedUrlOperation) {
        aWSS3StorageGetPresignedUrlOperation.lambda$start$1();
    }

    private /* synthetic */ void lambda$null$0(String str) {
        try {
            this.onSuccess.accept(StorageGetUrlResult.fromUrl(this.storageService.getPresignedUrl(str.concat(((AWSS3StorageGetPresignedUrlRequest) getRequest()).getKey()), ((AWSS3StorageGetPresignedUrlRequest) getRequest()).getExpires())));
        } catch (Exception e) {
            this.onError.accept(new StorageException("Encountered an issue while generating pre-signed URL", e, "See included exception for more details and suggestions to fix."));
        }
    }

    private /* synthetic */ void lambda$start$1() {
        this.awsS3StoragePluginConfiguration.getAWSS3PluginPrefixResolver(this.cognitoAuthProvider).resolvePrefix(((AWSS3StorageGetPresignedUrlRequest) getRequest()).getAccessLevel(), ((AWSS3StorageGetPresignedUrlRequest) getRequest()).getTargetIdentityId(), new c(this), this.onError);
    }

    @SuppressLint({"SyntheticAccessor"})
    public void start() {
        this.executorService.submit(new b(this));
    }
}
