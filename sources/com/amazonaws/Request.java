package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface Request {
    void addHeader(String str, String str2);

    void addParameter(String str, String str2);

    AWSRequestMetrics getAWSRequestMetrics();

    InputStream getContent();

    String getEncodedUriResourcePath();

    URI getEndpoint();

    Map getHeaders();

    String getHostPrefix();

    HttpMethodName getHttpMethod();

    AmazonWebServiceRequest getOriginalRequest();

    Map getParameters();

    @Deprecated
    String getResourcePath();

    String getServiceName();

    long getTimeOffset();

    boolean isStreaming();

    void setAWSRequestMetrics(AWSRequestMetrics aWSRequestMetrics);

    void setContent(InputStream inputStream);

    void setEncodedResourcePath(String str);

    void setEndpoint(URI uri);

    void setHeaders(Map map);

    void setHostPrefix(String str);

    void setHttpMethod(HttpMethodName httpMethodName);

    void setParameters(Map map);

    @Deprecated
    void setResourcePath(String str);

    void setStreaming(boolean z);

    @Deprecated
    void setTimeOffset(int i);

    void setTimeOffset(long j);

    Request withParameter(String str, String str2);

    @Deprecated
    Request withTimeOffset(int i);

    Request withTimeOffset(long j);
}
