package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserNotFoundExceptionUnmarshaller() {
        super(UserNotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserNotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserNotFoundException userNotFoundException = (UserNotFoundException) super.unmarshall(jsonErrorResponse);
        userNotFoundException.setErrorCode("UserNotFoundException");
        return userNotFoundException;
    }
}
