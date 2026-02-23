package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.InvalidKeyUsageException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InvalidKeyUsageExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidKeyUsageExceptionUnmarshaller() {
        super(InvalidKeyUsageException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidKeyUsageException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidKeyUsageException invalidKeyUsageException = (InvalidKeyUsageException) super.unmarshall(jsonErrorResponse);
        invalidKeyUsageException.setErrorCode("InvalidKeyUsageException");
        return invalidKeyUsageException;
    }
}
