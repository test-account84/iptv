package com.amazonaws.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class JsonErrorUnmarshaller extends AbstractErrorUnmarshaller {
    public JsonErrorUnmarshaller() {
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return true;
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        String message = jsonErrorResponse.getMessage();
        String errorCode = jsonErrorResponse.getErrorCode();
        if ((message == null || message.isEmpty()) && (errorCode == null || errorCode.isEmpty())) {
            throw new AmazonClientException("Neither error message nor error code is found in the error response payload.");
        }
        AmazonServiceException newException = newException(message);
        newException.setErrorCode(errorCode);
        return newException;
    }

    public JsonErrorUnmarshaller(Class cls) {
        super(cls);
    }
}
