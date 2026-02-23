package com.amplifyframework.storage.s3.operation;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.operation.StorageListOperation;
import com.amplifyframework.storage.result.StorageListResult;
import com.amplifyframework.storage.s3.CognitoAuthProvider;
import com.amplifyframework.storage.s3.configuration.AWSS3StoragePluginConfiguration;
import com.amplifyframework.storage.s3.request.AWSS3StorageListRequest;
import com.amplifyframework.storage.s3.service.StorageService;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageListOperation extends StorageListOperation {
    private final AWSS3StoragePluginConfiguration awsS3StoragePluginConfiguration;
    private final CognitoAuthProvider cognitoAuthProvider;
    private final ExecutorService executorService;
    private final Consumer onError;
    private final Consumer onSuccess;
    private final StorageService storageService;

    public AWSS3StorageListOperation(StorageService storageService, ExecutorService executorService, CognitoAuthProvider cognitoAuthProvider, AWSS3StorageListRequest aWSS3StorageListRequest, AWSS3StoragePluginConfiguration aWSS3StoragePluginConfiguration, Consumer consumer, Consumer consumer2) {
        super(aWSS3StorageListRequest);
        this.storageService = storageService;
        this.executorService = executorService;
        this.cognitoAuthProvider = cognitoAuthProvider;
        this.onSuccess = consumer;
        this.onError = consumer2;
        this.awsS3StoragePluginConfiguration = aWSS3StoragePluginConfiguration;
    }

    public static /* synthetic */ void a(AWSS3StorageListOperation aWSS3StorageListOperation) {
        aWSS3StorageListOperation.lambda$start$1();
    }

    public static /* synthetic */ void b(AWSS3StorageListOperation aWSS3StorageListOperation, String str) {
        aWSS3StorageListOperation.lambda$null$0(str);
    }

    private /* synthetic */ void lambda$null$0(String str) {
        try {
            this.onSuccess.accept(StorageListResult.fromItems(this.storageService.listFiles(str.concat(((AWSS3StorageListRequest) getRequest()).getPath()), str)));
        } catch (Exception e) {
            this.onError.accept(new StorageException("Something went wrong with your AWS S3 Storage list operation", e, "See attached exception for more information and suggestions"));
        }
    }

    private /* synthetic */ void lambda$start$1() {
        this.awsS3StoragePluginConfiguration.getAWSS3PluginPrefixResolver(this.cognitoAuthProvider).resolvePrefix(((AWSS3StorageListRequest) getRequest()).getAccessLevel(), ((AWSS3StorageListRequest) getRequest()).getTargetIdentityId(), new e(this), this.onError);
    }

    public void start() {
        this.executorService.submit(new d(this));
    }
}
