package com.amazonaws.transform;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class JsonUnmarshallerContext {
    private final HttpResponse httpResponse;
    private final AwsJsonReader reader;

    public JsonUnmarshallerContext(AwsJsonReader awsJsonReader) {
        this(awsJsonReader, null);
    }

    public String getHeader(String str) {
        HttpResponse httpResponse = this.httpResponse;
        if (httpResponse == null) {
            return null;
        }
        return (String) httpResponse.getHeaders().get(str);
    }

    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }

    public AwsJsonReader getReader() {
        return this.reader;
    }

    public JsonUnmarshallerContext(AwsJsonReader awsJsonReader, HttpResponse httpResponse) {
        this.reader = awsJsonReader;
        this.httpResponse = httpResponse;
    }
}
