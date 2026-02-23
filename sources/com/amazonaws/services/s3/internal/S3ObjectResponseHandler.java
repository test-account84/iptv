package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3ObjectResponseHandler extends AbstractS3ResponseHandler {
    public AmazonWebServiceResponse handle(HttpResponse httpResponse) throws Exception {
        S3Object s3Object = new S3Object();
        AmazonWebServiceResponse parseResponseMetadata = parseResponseMetadata(httpResponse);
        if (httpResponse.getHeaders().get("x-amz-website-redirect-location") != null) {
            s3Object.setRedirectLocation((String) httpResponse.getHeaders().get("x-amz-website-redirect-location"));
        }
        if (httpResponse.getHeaders().get("x-amz-request-charged") != null) {
            s3Object.setRequesterCharged(true);
        }
        if (httpResponse.getHeaders().get("x-amz-tagging-count") != null) {
            s3Object.setTaggingCount(Integer.valueOf(Integer.parseInt((String) httpResponse.getHeaders().get("x-amz-tagging-count"))));
        }
        populateObjectMetadata(httpResponse, s3Object.getObjectMetadata());
        s3Object.setObjectContent(new S3ObjectInputStream(httpResponse.getContent()));
        parseResponseMetadata.setResult(s3Object);
        return parseResponseMetadata;
    }

    public boolean needsConnectionLeftOpen() {
        return true;
    }
}
