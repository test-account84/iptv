package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.CustomKeyStoreNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CustomKeyStoreNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CustomKeyStoreNotFoundExceptionUnmarshaller() {
        super(CustomKeyStoreNotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("CustomKeyStoreNotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        CustomKeyStoreNotFoundException customKeyStoreNotFoundException = (CustomKeyStoreNotFoundException) super.unmarshall(jsonErrorResponse);
        customKeyStoreNotFoundException.setErrorCode("CustomKeyStoreNotFoundException");
        return customKeyStoreNotFoundException;
    }
}
