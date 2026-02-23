package com.amplifyframework.storage.s3.operation;

import android.annotation.SuppressLint;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.storage.StorageChannelEventName;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.operation.StorageUploadFileOperation;
import com.amplifyframework.storage.result.StorageTransferProgress;
import com.amplifyframework.storage.result.StorageUploadFileResult;
import com.amplifyframework.storage.s3.CognitoAuthProvider;
import com.amplifyframework.storage.s3.ServerSideEncryption;
import com.amplifyframework.storage.s3.configuration.AWSS3StoragePluginConfiguration;
import com.amplifyframework.storage.s3.request.AWSS3StorageUploadRequest;
import com.amplifyframework.storage.s3.service.StorageService;
import j$.util.Objects;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageUploadFileOperation extends StorageUploadFileOperation {
    private final AWSS3StoragePluginConfiguration awsS3StoragePluginConfiguration;
    private final CognitoAuthProvider cognitoAuthProvider;
    private final Consumer onError;
    private final Consumer onProgress;
    private final Consumer onSuccess;
    private final StorageService storageService;
    private TransferObserver transferObserver;

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobileconnectors$s3$transferutility$TransferState;

        static {
            int[] iArr = new int[TransferState.values().length];
            $SwitchMap$com$amazonaws$mobileconnectors$s3$transferutility$TransferState = iArr;
            try {
                iArr[TransferState.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobileconnectors$s3$transferutility$TransferState[TransferState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @SuppressLint({"SyntheticAccessor"})
    public final class UploadTransferListener implements TransferListener {
        private UploadTransferListener() {
        }

        public void onError(int i, Exception exc) {
            Amplify.Hub.publish(HubChannel.STORAGE, HubEvent.create(StorageChannelEventName.UPLOAD_ERROR, exc));
            AWSS3StorageUploadFileOperation.access$200(AWSS3StorageUploadFileOperation.this).accept(new StorageException("Something went wrong with your AWS S3 Storage upload file operation", exc, "See attached exception for more information and suggestions"));
        }

        public void onProgressChanged(int i, long j, long j2) {
            AWSS3StorageUploadFileOperation.access$100(AWSS3StorageUploadFileOperation.this).accept(new StorageTransferProgress(j, j2));
        }

        public void onStateChanged(int i, TransferState transferState) {
            Amplify.Hub.publish(HubChannel.STORAGE, HubEvent.create(StorageChannelEventName.UPLOAD_STATE, transferState.name()));
            if (1.$SwitchMap$com$amazonaws$mobileconnectors$s3$transferutility$TransferState[transferState.ordinal()] != 1) {
                return;
            }
            AWSS3StorageUploadFileOperation.access$000(AWSS3StorageUploadFileOperation.this).accept(StorageUploadFileResult.fromKey(((AWSS3StorageUploadRequest) AWSS3StorageUploadFileOperation.this.getRequest()).getKey()));
        }

        public /* synthetic */ UploadTransferListener(AWSS3StorageUploadFileOperation aWSS3StorageUploadFileOperation, 1 r2) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSS3StorageUploadFileOperation(StorageService storageService, CognitoAuthProvider cognitoAuthProvider, AWSS3StorageUploadRequest aWSS3StorageUploadRequest, AWSS3StoragePluginConfiguration aWSS3StoragePluginConfiguration, Consumer consumer, Consumer consumer2, Consumer consumer3) {
        super(aWSS3StorageUploadRequest);
        Objects.requireNonNull(aWSS3StorageUploadRequest);
        Objects.requireNonNull(storageService);
        this.storageService = storageService;
        this.cognitoAuthProvider = cognitoAuthProvider;
        Objects.requireNonNull(consumer);
        this.onProgress = consumer;
        Objects.requireNonNull(consumer2);
        this.onSuccess = consumer2;
        Objects.requireNonNull(consumer3);
        this.onError = consumer3;
        this.transferObserver = null;
        this.awsS3StoragePluginConfiguration = aWSS3StoragePluginConfiguration;
    }

    public static /* synthetic */ void a(AWSS3StorageUploadFileOperation aWSS3StorageUploadFileOperation, File file, ObjectMetadata objectMetadata, String str) {
        aWSS3StorageUploadFileOperation.lambda$start$0(file, objectMetadata, str);
    }

    public static /* synthetic */ Consumer access$000(AWSS3StorageUploadFileOperation aWSS3StorageUploadFileOperation) {
        return aWSS3StorageUploadFileOperation.onSuccess;
    }

    public static /* synthetic */ Consumer access$100(AWSS3StorageUploadFileOperation aWSS3StorageUploadFileOperation) {
        return aWSS3StorageUploadFileOperation.onProgress;
    }

    public static /* synthetic */ Consumer access$200(AWSS3StorageUploadFileOperation aWSS3StorageUploadFileOperation) {
        return aWSS3StorageUploadFileOperation.onError;
    }

    private /* synthetic */ void lambda$start$0(File file, ObjectMetadata objectMetadata, String str) {
        try {
            TransferObserver uploadFile = this.storageService.uploadFile(str.concat(((AWSS3StorageUploadRequest) getRequest()).getKey()), file, objectMetadata);
            this.transferObserver = uploadFile;
            uploadFile.setTransferListener(new UploadTransferListener(this, null));
        } catch (Exception e) {
            this.onError.accept(new StorageException("Issue uploading file.", e, "See included exception for more details and suggestions to fix."));
        }
    }

    public void cancel() {
        TransferObserver transferObserver = this.transferObserver;
        if (transferObserver != null) {
            try {
                this.storageService.cancelTransfer(transferObserver);
            } catch (Exception e) {
                this.onError.accept(new StorageException("Something went wrong while attempting to cancel your AWS S3 Storage upload file operation", e, "See attached exception for more information and suggestions"));
            }
        }
    }

    public void pause() {
        TransferObserver transferObserver = this.transferObserver;
        if (transferObserver != null) {
            try {
                this.storageService.pauseTransfer(transferObserver);
            } catch (Exception e) {
                this.onError.accept(new StorageException("Something went wrong while attempting to pause your AWS S3 Storage upload file operation", e, "See attached exception for more information and suggestions"));
            }
        }
    }

    public void resume() {
        TransferObserver transferObserver = this.transferObserver;
        if (transferObserver != null) {
            try {
                this.storageService.resumeTransfer(transferObserver);
            } catch (Exception e) {
                this.onError.accept(new StorageException("Something went wrong while attempting to resume your AWS S3 Storage upload file operation", e, "See attached exception for more information and suggestions"));
            }
        }
    }

    @SuppressLint({"SyntheticAccessor"})
    public void start() {
        if (this.transferObserver != null) {
            return;
        }
        File file = (File) ((AWSS3StorageUploadRequest) getRequest()).getLocal();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setUserMetadata(((AWSS3StorageUploadRequest) getRequest()).getMetadata());
        objectMetadata.setContentType(((AWSS3StorageUploadRequest) getRequest()).getContentType());
        ServerSideEncryption serverSideEncryption = ((AWSS3StorageUploadRequest) getRequest()).getServerSideEncryption();
        if (!ServerSideEncryption.NONE.equals(serverSideEncryption)) {
            objectMetadata.setSSEAlgorithm(serverSideEncryption.getName());
        }
        this.awsS3StoragePluginConfiguration.getAWSS3PluginPrefixResolver(this.cognitoAuthProvider).resolvePrefix(((AWSS3StorageUploadRequest) getRequest()).getAccessLevel(), ((AWSS3StorageUploadRequest) getRequest()).getTargetIdentityId(), new h(this, file, objectMetadata), this.onError);
    }
}
