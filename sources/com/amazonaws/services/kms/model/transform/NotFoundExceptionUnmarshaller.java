package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.NotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public NotFoundExceptionUnmarshaller() {
        super(NotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("NotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        NotFoundException notFoundException = (NotFoundException) super.unmarshall(jsonErrorResponse);
        notFoundException.setErrorCode("NotFoundException");
        return notFoundException;
    }
}
