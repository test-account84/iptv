package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.util.StringUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class CredentialsStaxMarshaller {
    private static CredentialsStaxMarshaller instance;

    public static CredentialsStaxMarshaller getInstance() {
        if (instance == null) {
            instance = new CredentialsStaxMarshaller();
        }
        return instance;
    }

    public void marshall(Credentials credentials, Request request, String str) {
        if (credentials.getAccessKeyId() != null) {
            request.addParameter(str + "AccessKeyId", StringUtils.fromString(credentials.getAccessKeyId()));
        }
        if (credentials.getSecretAccessKey() != null) {
            request.addParameter(str + "SecretAccessKey", StringUtils.fromString(credentials.getSecretAccessKey()));
        }
        if (credentials.getSessionToken() != null) {
            request.addParameter(str + "SessionToken", StringUtils.fromString(credentials.getSessionToken()));
        }
        if (credentials.getExpiration() != null) {
            request.addParameter(str + "Expiration", StringUtils.fromDate(credentials.getExpiration()));
        }
    }
}
