package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UnexpectedLambdaException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UnexpectedLambdaExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnexpectedLambdaExceptionUnmarshaller() {
        super(UnexpectedLambdaException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UnexpectedLambdaException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UnexpectedLambdaException unexpectedLambdaException = (UnexpectedLambdaException) super.unmarshall(jsonErrorResponse);
        unexpectedLambdaException.setErrorCode("UnexpectedLambdaException");
        return unexpectedLambdaException;
    }
}
