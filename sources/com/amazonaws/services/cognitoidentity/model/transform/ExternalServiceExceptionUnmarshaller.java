package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentity.model.ExternalServiceException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ExternalServiceExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ExternalServiceExceptionUnmarshaller() {
        super(ExternalServiceException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ExternalServiceException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ExternalServiceException externalServiceException = (ExternalServiceException) super.unmarshall(jsonErrorResponse);
        externalServiceException.setErrorCode("ExternalServiceException");
        return externalServiceException;
    }
}
