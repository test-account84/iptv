package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.MFAMethodNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MFAMethodNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public MFAMethodNotFoundExceptionUnmarshaller() {
        super(MFAMethodNotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("MFAMethodNotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        MFAMethodNotFoundException mFAMethodNotFoundException = (MFAMethodNotFoundException) super.unmarshall(jsonErrorResponse);
        mFAMethodNotFoundException.setErrorCode("MFAMethodNotFoundException");
        return mFAMethodNotFoundException;
    }
}
