package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.s3.internal.S3Direct;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.CopyPartResult;
import com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutInstructionFileRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CryptoModuleDispatcher extends S3CryptoModule {
    private final S3CryptoModuleAE ae;
    private final CryptoMode defaultCryptoMode;
    private final S3CryptoModuleEO eo;

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$services$s3$model$CryptoMode;

        static {
            int[] iArr = new int[CryptoMode.values().length];
            $SwitchMap$com$amazonaws$services$s3$model$CryptoMode = iArr;
            try {
                iArr[CryptoMode.StrictAuthenticatedEncryption.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$services$s3$model$CryptoMode[CryptoMode.AuthenticatedEncryption.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$services$s3$model$CryptoMode[CryptoMode.EncryptionOnly.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CryptoModuleDispatcher(AWSKMSClient aWSKMSClient, S3Direct s3Direct, AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        S3CryptoModuleAE s3CryptoModuleAEStrict;
        CryptoConfiguration clone = cryptoConfiguration.clone();
        if (clone.getCryptoMode() == null) {
            clone.setCryptoMode(CryptoMode.EncryptionOnly);
        }
        CryptoConfiguration readOnly = clone.readOnly();
        CryptoMode cryptoMode = readOnly.getCryptoMode();
        this.defaultCryptoMode = cryptoMode;
        int i = 1.$SwitchMap$com$amazonaws$services$s3$model$CryptoMode[cryptoMode.ordinal()];
        if (i == 1) {
            s3CryptoModuleAEStrict = new S3CryptoModuleAEStrict(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, readOnly);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException();
                }
                this.eo = new S3CryptoModuleEO(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, readOnly);
                CryptoConfiguration clone2 = readOnly.clone();
                try {
                    clone2.setCryptoMode(CryptoMode.AuthenticatedEncryption);
                } catch (UnsupportedOperationException unused) {
                }
                this.ae = new S3CryptoModuleAE(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, clone2.readOnly());
                return;
            }
            s3CryptoModuleAEStrict = new S3CryptoModuleAE(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, readOnly);
        }
        this.ae = s3CryptoModuleAEStrict;
        this.eo = null;
    }

    public void abortMultipartUploadSecurely(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        (this.defaultCryptoMode == CryptoMode.EncryptionOnly ? this.eo : this.ae).abortMultipartUploadSecurely(abortMultipartUploadRequest);
    }

    public CompleteMultipartUploadResult completeMultipartUploadSecurely(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        return (this.defaultCryptoMode == CryptoMode.EncryptionOnly ? this.eo : this.ae).completeMultipartUploadSecurely(completeMultipartUploadRequest);
    }

    public CopyPartResult copyPartSecurely(CopyPartRequest copyPartRequest) {
        return (this.defaultCryptoMode == CryptoMode.EncryptionOnly ? this.eo : this.ae).copyPartSecurely(copyPartRequest);
    }

    public ObjectMetadata getObjectSecurely(GetObjectRequest getObjectRequest, File file) {
        return this.ae.getObjectSecurely(getObjectRequest, file);
    }

    public InitiateMultipartUploadResult initiateMultipartUploadSecurely(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        return (this.defaultCryptoMode == CryptoMode.EncryptionOnly ? this.eo : this.ae).initiateMultipartUploadSecurely(initiateMultipartUploadRequest);
    }

    public PutObjectResult putInstructionFileSecurely(PutInstructionFileRequest putInstructionFileRequest) {
        return (this.defaultCryptoMode == CryptoMode.EncryptionOnly ? this.eo : this.ae).putInstructionFileSecurely(putInstructionFileRequest);
    }

    public void putLocalObjectSecurely(UploadObjectRequest uploadObjectRequest, String str, OutputStream outputStream) throws IOException {
        (this.defaultCryptoMode == CryptoMode.EncryptionOnly ? this.eo : this.ae).putLocalObjectSecurely(uploadObjectRequest, str, outputStream);
    }

    public PutObjectResult putObjectSecurely(PutObjectRequest putObjectRequest) {
        return (this.defaultCryptoMode == CryptoMode.EncryptionOnly ? this.eo : this.ae).putObjectSecurely(putObjectRequest);
    }

    public UploadPartResult uploadPartSecurely(UploadPartRequest uploadPartRequest) {
        return (this.defaultCryptoMode == CryptoMode.EncryptionOnly ? this.eo : this.ae).uploadPartSecurely(uploadPartRequest);
    }

    public S3Object getObjectSecurely(GetObjectRequest getObjectRequest) {
        return this.ae.getObjectSecurely(getObjectRequest);
    }
}
