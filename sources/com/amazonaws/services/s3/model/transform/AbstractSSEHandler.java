package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
abstract class AbstractSSEHandler extends AbstractHandler implements ServerSideEncryptionResult {
    public String getSSEAlgorithm() {
        ServerSideEncryptionResult sseResult = sseResult();
        if (sseResult == null) {
            return null;
        }
        return sseResult.getSSEAlgorithm();
    }

    public String getSSECustomerAlgorithm() {
        ServerSideEncryptionResult sseResult = sseResult();
        if (sseResult == null) {
            return null;
        }
        return sseResult.getSSECustomerAlgorithm();
    }

    public String getSSECustomerKeyMd5() {
        ServerSideEncryptionResult sseResult = sseResult();
        if (sseResult == null) {
            return null;
        }
        return sseResult.getSSECustomerKeyMd5();
    }

    public final void setSSEAlgorithm(String str) {
        ServerSideEncryptionResult sseResult = sseResult();
        if (sseResult != null) {
            sseResult.setSSEAlgorithm(str);
        }
    }

    public final void setSSECustomerAlgorithm(String str) {
        ServerSideEncryptionResult sseResult = sseResult();
        if (sseResult != null) {
            sseResult.setSSECustomerAlgorithm(str);
        }
    }

    public final void setSSECustomerKeyMd5(String str) {
        ServerSideEncryptionResult sseResult = sseResult();
        if (sseResult != null) {
            sseResult.setSSECustomerKeyMd5(str);
        }
    }

    public abstract ServerSideEncryptionResult sseResult();
}
