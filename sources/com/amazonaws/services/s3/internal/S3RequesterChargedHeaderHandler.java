package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3RequesterChargedHeaderHandler implements HeaderHandler {
    public void handle(S3RequesterChargedResult s3RequesterChargedResult, HttpResponse httpResponse) {
        s3RequesterChargedResult.setRequesterCharged(httpResponse.getHeaders().get("x-amz-request-charged") != null);
    }
}
