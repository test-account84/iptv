package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidLambdaResponseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InvalidLambdaResponseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidLambdaResponseExceptionUnmarshaller() {
        super(InvalidLambdaResponseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidLambdaResponseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidLambdaResponseException invalidLambdaResponseException = (InvalidLambdaResponseException) super.unmarshall(jsonErrorResponse);
        invalidLambdaResponseException.setErrorCode("InvalidLambdaResponseException");
        return invalidLambdaResponseException;
    }
}
