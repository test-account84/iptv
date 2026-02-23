package com.amazonaws;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AmazonWebServiceResponse {
    private ResponseMetadata responseMetadata;
    private Object result;

    public String getRequestId() {
        ResponseMetadata responseMetadata = this.responseMetadata;
        if (responseMetadata == null) {
            return null;
        }
        return responseMetadata.getRequestId();
    }

    public ResponseMetadata getResponseMetadata() {
        return this.responseMetadata;
    }

    public Object getResult() {
        return this.result;
    }

    public void setResponseMetadata(ResponseMetadata responseMetadata) {
        this.responseMetadata = responseMetadata;
    }

    public void setResult(Object obj) {
        this.result = obj;
    }
}
