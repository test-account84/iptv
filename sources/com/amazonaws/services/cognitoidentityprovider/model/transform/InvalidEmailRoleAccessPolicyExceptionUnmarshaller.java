package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidEmailRoleAccessPolicyException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InvalidEmailRoleAccessPolicyExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidEmailRoleAccessPolicyExceptionUnmarshaller() {
        super(InvalidEmailRoleAccessPolicyException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidEmailRoleAccessPolicyException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidEmailRoleAccessPolicyException invalidEmailRoleAccessPolicyException = (InvalidEmailRoleAccessPolicyException) super.unmarshall(jsonErrorResponse);
        invalidEmailRoleAccessPolicyException.setErrorCode("InvalidEmailRoleAccessPolicyException");
        return invalidEmailRoleAccessPolicyException;
    }
}
