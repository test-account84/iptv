package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.KMSInternalException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class KMSInternalExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KMSInternalExceptionUnmarshaller() {
        super(KMSInternalException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("KMSInternalException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        KMSInternalException kMSInternalException = (KMSInternalException) super.unmarshall(jsonErrorResponse);
        kMSInternalException.setErrorCode("KMSInternalException");
        return kMSInternalException;
    }
}
