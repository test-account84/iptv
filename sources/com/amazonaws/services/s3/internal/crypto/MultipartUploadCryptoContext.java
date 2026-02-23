package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class MultipartUploadCryptoContext extends MultipartUploadContext {
    private final ContentCryptoMaterial cekMaterial;
    private int partNumber;
    private volatile boolean partUploadInProgress;

    public MultipartUploadCryptoContext(String str, String str2, ContentCryptoMaterial contentCryptoMaterial) {
        super(str, str2);
        this.cekMaterial = contentCryptoMaterial;
    }

    public void beginPartUpload(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("part number must be at least 1");
        }
        if (this.partUploadInProgress) {
            throw new AmazonClientException("Parts are required to be uploaded in series");
        }
        synchronized (this) {
            try {
                if (i - this.partNumber > 1) {
                    throw new AmazonClientException("Parts are required to be uploaded in series (partNumber=" + this.partNumber + ", nextPartNumber=" + i + ")");
                }
                this.partNumber = i;
                this.partUploadInProgress = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void endPartUpload() {
        this.partUploadInProgress = false;
    }

    public CipherLite getCipherLite() {
        return this.cekMaterial.getCipherLite();
    }

    public ContentCryptoMaterial getContentCryptoMaterial() {
        return this.cekMaterial;
    }
}
