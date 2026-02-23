package com.amplifyframework.storage.s3.operation;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.operation.StorageRemoveOperation;
import com.amplifyframework.storage.result.StorageRemoveResult;
import com.amplifyframework.storage.s3.CognitoAuthProvider;
import com.amplifyframework.storage.s3.configuration.AWSS3StoragePluginConfiguration;
import com.amplifyframework.storage.s3.request.AWSS3StorageRemoveRequest;
import com.amplifyframework.storage.s3.service.StorageService;
import j$.util.Objects;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageRemoveOperation extends StorageRemoveOperation {
    private final AWSS3StoragePluginConfiguration awsS3StoragePluginConfiguration;
    private final CognitoAuthProvider cognitoAuthProvider;
    private final ExecutorService executorService;
    private final Consumer onError;
    private final Consumer onSuccess;
    private final StorageService storageService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSS3StorageRemoveOperation(StorageService storageService, ExecutorService executorService, CognitoAuthProvider cognitoAuthProvider, AWSS3StorageRemoveRequest aWSS3StorageRemoveRequest, AWSS3StoragePluginConfiguration aWSS3StoragePluginConfiguration, Consumer consumer, Consumer consumer2) {
        super(aWSS3StorageRemoveRequest);
        Objects.requireNonNull(aWSS3StorageRemoveRequest);
        Objects.requireNonNull(storageService);
        this.storageService = storageService;
        Objects.requireNonNull(executorService);
        this.executorService = executorService;
        this.cognitoAuthProvider = cognitoAuthProvider;
        Objects.requireNonNull(consumer);
        this.onSuccess = consumer;
        Objects.requireNonNull(consumer2);
        this.onError = consumer2;
        this.awsS3StoragePluginConfiguration = aWSS3StoragePluginConfiguration;
    }

    public static /* synthetic */ void a(AWSS3StorageRemoveOperation aWSS3StorageRemoveOperation, String str) {
        aWSS3StorageRemoveOperation.lambda$null$0(str);
    }

    public static /* synthetic */ void b(AWSS3StorageRemoveOperation aWSS3StorageRemoveOperation) {
        aWSS3StorageRemoveOperation.lambda$start$1();
    }

    private /* synthetic */ void lambda$null$0(String str) {
        try {
            this.storageService.deleteObject(str.concat(((AWSS3StorageRemoveRequest) getRequest()).getKey()));
            this.onSuccess.accept(StorageRemoveResult.fromKey(((AWSS3StorageRemoveRequest) getRequest()).getKey()));
        } catch (Exception e) {
            this.onError.accept(new StorageException("Something went wrong with your AWS S3 Storage remove operation", e, "See attached exception for more information and suggestions"));
        }
    }

    private /* synthetic */ void lambda$start$1() {
        this.awsS3StoragePluginConfiguration.getAWSS3PluginPrefixResolver(this.cognitoAuthProvider).resolvePrefix(((AWSS3StorageRemoveRequest) getRequest()).getAccessLevel(), ((AWSS3StorageRemoveRequest) getRequest()).getTargetIdentityId(), new f(this), this.onError);
    }

    public void start() {
        this.executorService.submit(new g(this));
    }
}
