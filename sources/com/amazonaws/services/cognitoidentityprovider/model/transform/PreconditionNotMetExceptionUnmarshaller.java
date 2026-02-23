package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.PreconditionNotMetException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PreconditionNotMetExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public PreconditionNotMetExceptionUnmarshaller() {
        super(PreconditionNotMetException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("PreconditionNotMetException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        PreconditionNotMetException preconditionNotMetException = (PreconditionNotMetException) super.unmarshall(jsonErrorResponse);
        preconditionNotMetException.setErrorCode("PreconditionNotMetException");
        return preconditionNotMetException;
    }
}
