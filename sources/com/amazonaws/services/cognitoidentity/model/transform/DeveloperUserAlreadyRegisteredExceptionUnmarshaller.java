package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentity.model.DeveloperUserAlreadyRegisteredException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeveloperUserAlreadyRegisteredExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public DeveloperUserAlreadyRegisteredExceptionUnmarshaller() {
        super(DeveloperUserAlreadyRegisteredException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("DeveloperUserAlreadyRegisteredException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        DeveloperUserAlreadyRegisteredException developerUserAlreadyRegisteredException = (DeveloperUserAlreadyRegisteredException) super.unmarshall(jsonErrorResponse);
        developerUserAlreadyRegisteredException.setErrorCode("DeveloperUserAlreadyRegisteredException");
        return developerUserAlreadyRegisteredException;
    }
}
