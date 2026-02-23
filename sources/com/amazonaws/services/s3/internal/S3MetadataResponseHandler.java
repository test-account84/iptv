package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.model.ObjectMetadata;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3MetadataResponseHandler extends AbstractS3ResponseHandler {
    public AmazonWebServiceResponse handle(HttpResponse httpResponse) throws Exception {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        populateObjectMetadata(httpResponse, objectMetadata);
        AmazonWebServiceResponse parseResponseMetadata = parseResponseMetadata(httpResponse);
        parseResponseMetadata.setResult(objectMetadata);
        return parseResponseMetadata;
    }
}
