package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.CloudHsmClusterNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CloudHsmClusterNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CloudHsmClusterNotFoundExceptionUnmarshaller() {
        super(CloudHsmClusterNotFoundException.class);
    }

    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("CloudHsmClusterNotFoundException");
    }

    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        CloudHsmClusterNotFoundException cloudHsmClusterNotFoundException = (CloudHsmClusterNotFoundException) super.unmarshall(jsonErrorResponse);
        cloudHsmClusterNotFoundException.setErrorCode("CloudHsmClusterNotFoundException");
        return cloudHsmClusterNotFoundException;
    }
}
