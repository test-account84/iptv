package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SSEAwsKeyManagementParams implements Serializable {
    private final String awsKmsKeyId;

    public SSEAwsKeyManagementParams() {
        this.awsKmsKeyId = null;
    }

    public String getAwsKmsKeyId() {
        return this.awsKmsKeyId;
    }

    public String getEncryption() {
        return SSEAlgorithm.KMS.getAlgorithm();
    }

    public SSEAwsKeyManagementParams(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("AWS Key Management System Key id cannot be null");
        }
        this.awsKmsKeyId = str;
    }
}
