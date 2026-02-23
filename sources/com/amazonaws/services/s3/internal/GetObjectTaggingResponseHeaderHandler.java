package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetObjectTaggingResponseHeaderHandler implements HeaderHandler {
    public void handle(GetObjectTaggingResult getObjectTaggingResult, HttpResponse httpResponse) {
        getObjectTaggingResult.setVersionId((String) httpResponse.getHeaders().get("x-amz-version-id"));
    }
}
