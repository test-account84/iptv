package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetAccessKeyInfoRequestMarshaller implements Marshaller {
    public Request marshall(GetAccessKeyInfoRequest getAccessKeyInfoRequest) {
        if (getAccessKeyInfoRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(GetAccessKeyInfoRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(getAccessKeyInfoRequest, "AWSSecurityTokenService");
        defaultRequest.addParameter("Action", "GetAccessKeyInfo");
        defaultRequest.addParameter("Version", "2011-06-15");
        if (getAccessKeyInfoRequest.getAccessKeyId() != null) {
            defaultRequest.addParameter("AccessKeyId", StringUtils.fromString(getAccessKeyInfoRequest.getAccessKeyId()));
        }
        return defaultRequest;
    }
}
