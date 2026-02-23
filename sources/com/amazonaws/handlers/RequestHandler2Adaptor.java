package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.util.AWSRequestMetrics;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class RequestHandler2Adaptor extends RequestHandler2 {
    private final RequestHandler old;

    public RequestHandler2Adaptor(RequestHandler requestHandler) {
        if (requestHandler == null) {
            throw new IllegalArgumentException();
        }
        this.old = requestHandler;
    }

    public void afterError(Request request, Response response, Exception exc) {
        this.old.afterError(request, exc);
    }

    public void afterResponse(Request request, Response response) {
        AWSRequestMetrics aWSRequestMetrics = request == null ? null : request.getAWSRequestMetrics();
        this.old.afterResponse(request, response == null ? null : response.getAwsResponse(), aWSRequestMetrics != null ? aWSRequestMetrics.getTimingInfo() : null);
    }

    public void beforeRequest(Request request) {
        this.old.beforeRequest(request);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RequestHandler2Adaptor) {
            return this.old.equals(((RequestHandler2Adaptor) obj).old);
        }
        return false;
    }

    public int hashCode() {
        return this.old.hashCode();
    }
}
