package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DecodeAuthorizationMessageRequestMarshaller implements Marshaller {
    public Request marshall(DecodeAuthorizationMessageRequest decodeAuthorizationMessageRequest) {
        if (decodeAuthorizationMessageRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(DecodeAuthorizationMessageRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(decodeAuthorizationMessageRequest, "AWSSecurityTokenService");
        defaultRequest.addParameter("Action", "DecodeAuthorizationMessage");
        defaultRequest.addParameter("Version", "2011-06-15");
        if (decodeAuthorizationMessageRequest.getEncodedMessage() != null) {
            defaultRequest.addParameter("EncodedMessage", StringUtils.fromString(decodeAuthorizationMessageRequest.getEncodedMessage()));
        }
        return defaultRequest;
    }
}
