package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.ConcurrentModificationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ConcurrentModificationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ConcurrentModificationExceptionUnmarshaller() {
        super(ConcurrentModificationException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ConcurrentModificationException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ConcurrentModificationException concurrentModificationException = (ConcurrentModificationException) super.unmarshall(jsonErrorResponse);
        concurrentModificationException.setErrorCode("ConcurrentModificationException");
        return concurrentModificationException;
    }
}
