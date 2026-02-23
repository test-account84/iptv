package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ServerSideEncryptionHeaderHandler implements HeaderHandler {
    public void handle(ServerSideEncryptionResult serverSideEncryptionResult, HttpResponse httpResponse) {
        serverSideEncryptionResult.setSSEAlgorithm((String) httpResponse.getHeaders().get("x-amz-server-side-encryption"));
        serverSideEncryptionResult.setSSECustomerAlgorithm((String) httpResponse.getHeaders().get("x-amz-server-side-encryption-customer-algorithm"));
        serverSideEncryptionResult.setSSECustomerKeyMd5((String) httpResponse.getHeaders().get("x-amz-server-side-encryption-customer-key-MD5"));
    }
}
