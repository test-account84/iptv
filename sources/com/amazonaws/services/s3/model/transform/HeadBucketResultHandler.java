package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.internal.AbstractS3ResponseHandler;
import com.amazonaws.services.s3.model.HeadBucketResult;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class HeadBucketResultHandler extends AbstractS3ResponseHandler {
    public AmazonWebServiceResponse handle(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse amazonWebServiceResponse = new AmazonWebServiceResponse();
        HeadBucketResult headBucketResult = new HeadBucketResult();
        headBucketResult.setBucketRegion((String) httpResponse.getHeaders().get("x-amz-bucket-region"));
        amazonWebServiceResponse.setResult(headBucketResult);
        return amazonWebServiceResponse;
    }
}
