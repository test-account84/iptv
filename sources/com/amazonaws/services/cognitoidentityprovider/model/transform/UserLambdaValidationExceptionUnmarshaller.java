package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserLambdaValidationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserLambdaValidationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserLambdaValidationExceptionUnmarshaller() {
        super(UserLambdaValidationException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserLambdaValidationException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserLambdaValidationException userLambdaValidationException = (UserLambdaValidationException) super.unmarshall(jsonErrorResponse);
        userLambdaValidationException.setErrorCode("UserLambdaValidationException");
        return userLambdaValidationException;
    }
}
