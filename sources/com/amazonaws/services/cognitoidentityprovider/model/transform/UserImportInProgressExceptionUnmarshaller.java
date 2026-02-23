package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserImportInProgressException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserImportInProgressExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserImportInProgressExceptionUnmarshaller() {
        super(UserImportInProgressException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserImportInProgressException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserImportInProgressException userImportInProgressException = (UserImportInProgressException) super.unmarshall(jsonErrorResponse);
        userImportInProgressException.setErrorCode("UserImportInProgressException");
        return userImportInProgressException;
    }
}
