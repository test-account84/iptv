package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3VersionHeaderHandler implements HeaderHandler {
    public void handle(S3VersionResult s3VersionResult, HttpResponse httpResponse) {
        s3VersionResult.setVersionId((String) httpResponse.getHeaders().get("x-amz-version-id"));
    }
}
