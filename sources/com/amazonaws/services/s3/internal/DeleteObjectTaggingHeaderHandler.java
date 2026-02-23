package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.model.DeleteObjectTaggingResult;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeleteObjectTaggingHeaderHandler implements HeaderHandler {
    public void handle(DeleteObjectTaggingResult deleteObjectTaggingResult, HttpResponse httpResponse) {
        deleteObjectTaggingResult.setVersionId((String) httpResponse.getHeaders().get("x-amz-version-id"));
    }
}
