package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.transform.Unmarshaller;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3XmlResponseHandler extends AbstractS3ResponseHandler {
    private static final Log log = LogFactory.getLog("com.amazonaws.request");
    private Map responseHeaders;
    private Unmarshaller responseUnmarshaller;

    public S3XmlResponseHandler(Unmarshaller unmarshaller) {
        this.responseUnmarshaller = unmarshaller;
    }

    public Map getResponseHeaders() {
        return this.responseHeaders;
    }

    public AmazonWebServiceResponse handle(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse parseResponseMetadata = parseResponseMetadata(httpResponse);
        this.responseHeaders = httpResponse.getHeaders();
        if (this.responseUnmarshaller != null) {
            Log log2 = log;
            log2.trace("Beginning to parse service response XML");
            Object unmarshall = this.responseUnmarshaller.unmarshall(httpResponse.getContent());
            log2.trace("Done parsing service response XML");
            parseResponseMetadata.setResult(unmarshall);
        }
        return parseResponseMetadata;
    }
}
