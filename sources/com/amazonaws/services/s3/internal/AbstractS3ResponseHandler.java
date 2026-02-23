package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.DateUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AbstractS3ResponseHandler implements HttpResponseHandler {
    private static final Set IGNORED_HEADERS;
    private static final Log log = LogFactory.getLog(S3MetadataResponseHandler.class);

    static {
        HashSet hashSet = new HashSet();
        IGNORED_HEADERS = hashSet;
        hashSet.add("Date");
        hashSet.add("Server");
        hashSet.add("x-amz-request-id");
        hashSet.add("x-amz-id-2");
        hashSet.add("X-Amz-Cf-Id");
        hashSet.add("Connection");
    }

    public boolean needsConnectionLeftOpen() {
        return false;
    }

    public AmazonWebServiceResponse parseResponseMetadata(HttpResponse httpResponse) {
        AmazonWebServiceResponse amazonWebServiceResponse = new AmazonWebServiceResponse();
        String str = (String) httpResponse.getHeaders().get("x-amz-request-id");
        String str2 = (String) httpResponse.getHeaders().get("x-amz-id-2");
        String str3 = (String) httpResponse.getHeaders().get("X-Amz-Cf-Id");
        HashMap hashMap = new HashMap();
        hashMap.put("AWS_REQUEST_ID", str);
        hashMap.put("HOST_ID", str2);
        hashMap.put("CLOUD_FRONT_ID", str3);
        amazonWebServiceResponse.setResponseMetadata(new S3ResponseMetadata((Map) hashMap));
        return amazonWebServiceResponse;
    }

    public void populateObjectMetadata(HttpResponse httpResponse, ObjectMetadata objectMetadata) {
        Object removeQuotes;
        Log log2;
        StringBuilder sb;
        String str;
        for (Map.Entry entry : httpResponse.getHeaders().entrySet()) {
            String str2 = (String) entry.getKey();
            if (str2.startsWith("x-amz-meta-")) {
                objectMetadata.addUserMetadata(str2.substring(11), (String) entry.getValue());
            } else if (IGNORED_HEADERS.contains(str2)) {
                log.debug(String.format("%s is ignored.", new Object[]{str2}));
            } else if (str2.equalsIgnoreCase("Last-Modified")) {
                try {
                    objectMetadata.setHeader(str2, ServiceUtils.parseRfc822Date((String) entry.getValue()));
                } catch (Exception e) {
                    e = e;
                    log2 = log;
                    sb = new StringBuilder();
                    str = "Unable to parse last modified date: ";
                    sb.append(str);
                    sb.append((String) entry.getValue());
                    log2.warn(sb.toString(), e);
                }
            } else if (str2.equalsIgnoreCase("Content-Length")) {
                try {
                    objectMetadata.setHeader(str2, Long.valueOf(Long.parseLong((String) entry.getValue())));
                } catch (NumberFormatException e2) {
                    e = e2;
                    log2 = log;
                    sb = new StringBuilder();
                    str = "Unable to parse content length: ";
                    sb.append(str);
                    sb.append((String) entry.getValue());
                    log2.warn(sb.toString(), e);
                }
            } else {
                if (str2.equalsIgnoreCase("ETag")) {
                    removeQuotes = ServiceUtils.removeQuotes((String) entry.getValue());
                } else if (str2.equalsIgnoreCase("Expires")) {
                    try {
                        objectMetadata.setHttpExpiresDate(DateUtils.parseRFC822Date((String) entry.getValue()));
                    } catch (Exception e3) {
                        e = e3;
                        log2 = log;
                        sb = new StringBuilder();
                        str = "Unable to parse http expiration date: ";
                        sb.append(str);
                        sb.append((String) entry.getValue());
                        log2.warn(sb.toString(), e);
                    }
                } else if (str2.equalsIgnoreCase("x-amz-expiration")) {
                    new ObjectExpirationHeaderHandler().handle((ObjectExpirationResult) objectMetadata, httpResponse);
                } else if (str2.equalsIgnoreCase("x-amz-restore")) {
                    new ObjectRestoreHeaderHandler().handle((ObjectRestoreResult) objectMetadata, httpResponse);
                } else if (str2.equalsIgnoreCase("x-amz-request-charged")) {
                    new S3RequesterChargedHeaderHandler().handle((S3RequesterChargedResult) objectMetadata, httpResponse);
                } else if (str2.equalsIgnoreCase("x-amz-mp-parts-count")) {
                    try {
                        objectMetadata.setHeader(str2, Integer.valueOf(Integer.parseInt((String) entry.getValue())));
                    } catch (NumberFormatException e4) {
                        throw new AmazonClientException("Unable to parse part count. Header x-amz-mp-parts-count has corrupted data" + e4.getMessage(), e4);
                    }
                } else {
                    removeQuotes = entry.getValue();
                }
                objectMetadata.setHeader(str2, removeQuotes);
            }
        }
    }
}
