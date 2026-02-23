package com.amazonaws.services.s3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface ServerSideEncryptionResult {
    String getSSEAlgorithm();

    String getSSECustomerAlgorithm();

    String getSSECustomerKeyMd5();

    void setSSEAlgorithm(String str);

    void setSSECustomerAlgorithm(String str);

    void setSSECustomerKeyMd5(String str);
}
