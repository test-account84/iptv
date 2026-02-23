package com.amplifyframework.storage.s3.operation;

import android.annotation.SuppressLint;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.storage.StorageChannelEventName;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.operation.StorageDownloadFileOperation;
import com.amplifyframework.storage.result.StorageDownloadFileResult;
import com.amplifyframework.storage.result.StorageTransferProgress;
import com.amplifyframework.storage.s3.CognitoAuthProvider;
import com.amplifyframework.storage.s3.configuration.AWSS3StoragePluginConfiguration;
import com.amplifyframework.storage.s3.request.AWSS3StorageDownloadFileRequest;
import com.amplifyframework.storage.s3.service.StorageService;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AWSS3StorageDownloadFileOperation extends StorageDownloadFileOperation {
    private final AWSS3StoragePluginConfiguration awsS3StoragePluginConfiguration;
    private final CognitoAuthProvider cognitoAuthProvider;
    private File file;
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
    public final class DownloadTransferListener implements TransferListener {
        private DownloadTransferListener() {
        }

        public void onError(int i, Exception exc) {
            Amplify.Hub.publish(HubChannel.STORAGE, HubEvent.create(StorageChannelEventName.DOWNLOAD_ERROR, exc));
            AWSS3StorageDownloadFileOperation.access$300(AWSS3StorageDownloadFileOperation.this).accept(new StorageException("Something went wrong with your AWS S3 Storage download file operation", exc, "See attached exception for more information and suggestions"));
        }

        public void onProgressChanged(int i, long j, long j2) {
            AWSS3StorageDownloadFileOperation.access$200(AWSS3StorageDownloadFileOperation.this).accept(new StorageTransferProgress(j, j2));
        }

        public void onStateChanged(int i, TransferState transferState) {
            Amplify.Hub.publish(HubChannel.STORAGE, HubEvent.create(StorageChannelEventName.DOWNLOAD_STATE, transferState.name()));
            if (1.$SwitchMap$com$amazonaws$mobileconnectors$s3$transferutility$TransferState[transferState.ordinal()] != 1) {
                return;
            }
            AWSS3StorageDownloadFileOperation.access$100(AWSS3StorageDownloadFileOperation.this).accept(StorageDownloadFileResult.fromFile(AWSS3StorageDownloadFileOperation.access$000(AWSS3StorageDownloadFileOperation.this)));
        }

        public /* synthetic */ DownloadTransferListener(AWSS3StorageDownloadFileOperation aWSS3StorageDownloadFileOperation, 1 r2) {
            this();
        }
    }

    public AWSS3StorageDownloadFileOperation(StorageService storageService, CognitoAuthProvider cognitoAuthProvider, AWSS3StorageDownloadFileRequest aWSS3StorageDownloadFileRequest, AWSS3StoragePluginConfiguration aWSS3StoragePluginConfiguration, Consumer consumer, Consumer consumer2, Consumer consumer3) {
        super(aWSS3StorageDownloadFileRequest);
        this.storageService = storageService;
        this.cognitoAuthProvider = cognitoAuthProvider;
        this.onProgress = consumer;
        this.onSuccess = consumer2;
        this.onError = consumer3;
        this.transferObserver = null;
        this.file = null;
        this.awsS3StoragePluginConfiguration = aWSS3StoragePluginConfiguration;
    }

    public static /* synthetic */ void a(AWSS3StorageDownloadFileOperation aWSS3StorageDownloadFileOperation, String str) {
        aWSS3StorageDownloadFileOperation.lambda$start$0(str);
    }

    public static /* synthetic */ File access$000(AWSS3StorageDownloadFileOperation aWSS3StorageDownloadFileOperation) {
        return aWSS3StorageDownloadFileOperation.file;
    }

    public static /* synthetic */ Consumer access$100(AWSS3StorageDownloadFileOperation aWSS3StorageDownloadFileOperation) {
        return aWSS3StorageDownloadFileOperation.onSuccess;
    }

    public static /* synthetic */ Consumer access$200(AWSS3StorageDownloadFileOperation aWSS3StorageDownloadFileOperation) {
        return aWSS3StorageDownloadFileOperation.onProgress;
    }

    public static /* synthetic */ Consumer access$300(AWSS3StorageDownloadFileOperation aWSS3StorageDownloadFileOperation) {
        return aWSS3StorageDownloadFileOperation.onError;
    }

    private /* synthetic */ void lambda$start$0(String str) {
        try {
            TransferObserver downloadToFile = this.storageService.downloadToFile(str.concat(((AWSS3StorageDownloadFileRequest) getRequest()).getKey()), this.file);
            this.transferObserver = downloadToFile;
            downloadToFile.setTransferListener(new DownloadTransferListener(this, null));
        } catch (Exception e) {
            this.onError.accept(new StorageException("Issue downloading file", e, "See included exception for more details and suggestions to fix."));
        }
    }

    public void cancel() {
        TransferObserver transferObserver = this.transferObserver;
        if (transferObserver != null) {
            try {
                this.storageService.cancelTransfer(transferObserver);
            } catch (Exception e) {
                this.onError.accept(new StorageException("Something went wrong while attempting to cancel your AWS S3 Storage download file operation", e, "See attached exception for more information and suggestions"));
            }
        }
    }

    public void pause() {
        TransferObserver transferObserver = this.transferObserver;
        if (transferObserver != null) {
            try {
                this.storageService.pauseTransfer(transferObserver);
            } catch (Exception e) {
                this.onError.accept(new StorageException("Something went wrong while attempting to pause your AWS S3 Storage download file operation", e, "See attached exception for more information and suggestions"));
            }
        }
    }

    public void resume() {
        TransferObserver transferObserver = this.transferObserver;
        if (transferObserver != null) {
            try {
                this.storageService.resumeTransfer(transferObserver);
            } catch (Exception e) {
                this.onError.accept(new StorageException("Something went wrong while attempting to resume your AWS S3 Storage download file operation", e, "See attached exception for more information and suggestions"));
            }
        }
    }

    @SuppressLint({"SyntheticAccessor"})
    public void start() {
        if (this.transferObserver != null) {
            return;
        }
        this.file = ((AWSS3StorageDownloadFileRequest) getRequest()).getLocal();
        this.awsS3StoragePluginConfiguration.getAWSS3PluginPrefixResolver(this.cognitoAuthProvider).resolvePrefix(((AWSS3StorageDownloadFileRequest) getRequest()).getAccessLevel(), ((AWSS3StorageDownloadFileRequest) getRequest()).getTargetIdentityId(), new a(this), this.onError);
    }
}
