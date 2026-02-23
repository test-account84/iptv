package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.CloudHsmClusterInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CloudHsmClusterInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CloudHsmClusterInUseExceptionUnmarshaller() {
        super(CloudHsmClusterInUseException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("CloudHsmClusterInUseException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        CloudHsmClusterInUseException cloudHsmClusterInUseException = (CloudHsmClusterInUseException) super.unmarshall(jsonErrorResponse);
        cloudHsmClusterInUseException.setErrorCode("CloudHsmClusterInUseException");
        return cloudHsmClusterInUseException;
    }
}
