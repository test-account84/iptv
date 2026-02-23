package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidUserPoolConfigurationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InvalidUserPoolConfigurationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidUserPoolConfigurationExceptionUnmarshaller() {
        super(InvalidUserPoolConfigurationException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidUserPoolConfigurationException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidUserPoolConfigurationException invalidUserPoolConfigurationException = (InvalidUserPoolConfigurationException) super.unmarshall(jsonErrorResponse);
        invalidUserPoolConfigurationException.setErrorCode("InvalidUserPoolConfigurationException");
        return invalidUserPoolConfigurationException;
    }
}
