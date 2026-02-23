package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolTaggingException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserPoolTaggingExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserPoolTaggingExceptionUnmarshaller() {
        super(UserPoolTaggingException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserPoolTaggingException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserPoolTaggingException userPoolTaggingException = (UserPoolTaggingException) super.unmarshall(jsonErrorResponse);
        userPoolTaggingException.setErrorCode("UserPoolTaggingException");
        return userPoolTaggingException;
    }
}
