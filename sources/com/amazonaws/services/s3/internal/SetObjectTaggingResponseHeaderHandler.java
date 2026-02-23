package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.model.SetObjectTaggingResult;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SetObjectTaggingResponseHeaderHandler implements HeaderHandler {
    public void handle(SetObjectTaggingResult setObjectTaggingResult, HttpResponse httpResponse) {
        setObjectTaggingResult.setVersionId((String) httpResponse.getHeaders().get("x-amz-version-id"));
    }
}
