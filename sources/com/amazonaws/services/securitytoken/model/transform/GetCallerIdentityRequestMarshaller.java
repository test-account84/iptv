package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest;
import com.amazonaws.transform.Marshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetCallerIdentityRequestMarshaller implements Marshaller {
    public Request marshall(GetCallerIdentityRequest getCallerIdentityRequest) {
        if (getCallerIdentityRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(GetCallerIdentityRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(getCallerIdentityRequest, "AWSSecurityTokenService");
        defaultRequest.addParameter("Action", "GetCallerIdentity");
        defaultRequest.addParameter("Version", "2011-06-15");
        return defaultRequest;
    }
}
