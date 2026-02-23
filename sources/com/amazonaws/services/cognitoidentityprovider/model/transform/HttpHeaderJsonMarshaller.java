package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.HttpHeader;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class HttpHeaderJsonMarshaller {
    private static HttpHeaderJsonMarshaller instance;

    public static HttpHeaderJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new HttpHeaderJsonMarshaller();
        }
        return instance;
    }

    public void marshall(HttpHeader httpHeader, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (httpHeader.getHeaderName() != null) {
            String headerName = httpHeader.getHeaderName();
            awsJsonWriter.name("headerName");
            awsJsonWriter.value(headerName);
        }
        if (httpHeader.getHeaderValue() != null) {
            String headerValue = httpHeader.getHeaderValue();
            awsJsonWriter.name("headerValue");
            awsJsonWriter.value(headerValue);
        }
        awsJsonWriter.endObject();
    }
}
