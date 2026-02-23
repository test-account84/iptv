package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserNotConfirmedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserNotConfirmedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserNotConfirmedExceptionUnmarshaller() {
        super(UserNotConfirmedException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserNotConfirmedException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserNotConfirmedException userNotConfirmedException = (UserNotConfirmedException) super.unmarshall(jsonErrorResponse);
        userNotConfirmedException.setErrorCode("UserNotConfirmedException");
        return userNotConfirmedException;
    }
}
