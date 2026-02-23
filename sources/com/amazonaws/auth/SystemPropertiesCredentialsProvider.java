package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SystemPropertiesCredentialsProvider implements AWSCredentialsProvider {
    public AWSCredentials getCredentials() {
        if (System.getProperty("aws.accessKeyId") == null || System.getProperty("aws.secretKey") == null) {
            throw new AmazonClientException("Unable to load AWS credentials from Java system properties (aws.accessKeyId and aws.secretKey)");
        }
        return new BasicAWSCredentials(System.getProperty("aws.accessKeyId"), System.getProperty("aws.secretKey"));
    }

    public void refresh() {
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
