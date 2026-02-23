package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.transform.Unmarshaller;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ResponseHeaderHandlerChain extends S3XmlResponseHandler {
    private final List headerHandlers;

    public ResponseHeaderHandlerChain(Unmarshaller unmarshaller, HeaderHandler... headerHandlerArr) {
        super(unmarshaller);
        this.headerHandlers = Arrays.asList(headerHandlerArr);
    }

    public AmazonWebServiceResponse handle(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse handle = super.handle(httpResponse);
        Object result = handle.getResult();
        if (result != null) {
            Iterator it = this.headerHandlers.iterator();
            while (it.hasNext()) {
                ((HeaderHandler) it.next()).handle(result, httpResponse);
            }
        }
        return handle;
    }
}
