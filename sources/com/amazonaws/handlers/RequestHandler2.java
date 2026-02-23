package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class RequestHandler2 {
    public static RequestHandler2 adapt(RequestHandler requestHandler) {
        return new RequestHandler2Adaptor(requestHandler);
    }

    public abstract void afterError(Request request, Response response, Exception exc);

    public abstract void afterResponse(Request request, Response response);

    public abstract void beforeRequest(Request request);
}
