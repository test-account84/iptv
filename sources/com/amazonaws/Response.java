package com.amazonaws;

import com.amazonaws.http.HttpResponse;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Response {
    private final HttpResponse httpResponse;
    private final Object response;

    public Response(Object obj, HttpResponse httpResponse) {
        this.response = obj;
        this.httpResponse = httpResponse;
    }

    public Object getAwsResponse() {
        return this.response;
    }

    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }
}
