package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.CodeMismatchException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CodeMismatchExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CodeMismatchExceptionUnmarshaller() {
        super(CodeMismatchException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("CodeMismatchException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        CodeMismatchException codeMismatchException = (CodeMismatchException) super.unmarshall(jsonErrorResponse);
        codeMismatchException.setErrorCode("CodeMismatchException");
        return codeMismatchException;
    }
}
