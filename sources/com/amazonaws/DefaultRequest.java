package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DefaultRequest implements Request {
    private InputStream content;
    private String encodedUriResourcePath;
    private URI endpoint;
    private final Map headers;
    private String hostPrefix;
    private HttpMethodName httpMethod;
    private AWSRequestMetrics metrics;
    private final AmazonWebServiceRequest originalRequest;
    private final Map parameters;
    private String resourcePath;
    private String serviceName;
    private boolean streaming;
    private long timeOffset;

    public DefaultRequest(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        this.streaming = false;
        this.parameters = new LinkedHashMap();
        this.headers = new HashMap();
        this.httpMethod = HttpMethodName.POST;
        this.serviceName = str;
        this.originalRequest = amazonWebServiceRequest;
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public void addParameter(String str, String str2) {
        this.parameters.put(str, str2);
    }

    @Deprecated
    public AWSRequestMetrics getAWSRequestMetrics() {
        return this.metrics;
    }

    public InputStream getContent() {
        return this.content;
    }

    public String getEncodedUriResourcePath() {
        return this.encodedUriResourcePath;
    }

    public URI getEndpoint() {
        return this.endpoint;
    }

    public Map getHeaders() {
        return this.headers;
    }

    public String getHostPrefix() {
        return this.hostPrefix;
    }

    public HttpMethodName getHttpMethod() {
        return this.httpMethod;
    }

    public AmazonWebServiceRequest getOriginalRequest() {
        return this.originalRequest;
    }

    public Map getParameters() {
        return this.parameters;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public long getTimeOffset() {
        return this.timeOffset;
    }

    public boolean isStreaming() {
        return this.streaming;
    }

    @Deprecated
    public void setAWSRequestMetrics(AWSRequestMetrics aWSRequestMetrics) {
        if (this.metrics != null) {
            throw new IllegalStateException("AWSRequestMetrics has already been set on this request");
        }
        this.metrics = aWSRequestMetrics;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    public void setEncodedResourcePath(String str) {
        this.encodedUriResourcePath = str;
    }

    public void setEndpoint(URI uri) {
        this.endpoint = uri;
    }

    public void setHeaders(Map map) {
        this.headers.clear();
        this.headers.putAll(map);
    }

    public void setHostPrefix(String str) {
        this.hostPrefix = str;
    }

    public void setHttpMethod(HttpMethodName httpMethodName) {
        this.httpMethod = httpMethodName;
    }

    public void setParameters(Map map) {
        this.parameters.clear();
        this.parameters.putAll(map);
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
    }

    public void setStreaming(boolean z) {
        this.streaming = z;
    }

    @Deprecated
    public void setTimeOffset(int i) {
        setTimeOffset(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getHttpMethod());
        sb.append(" ");
        sb.append(getEndpoint());
        sb.append(" ");
        String resourcePath = getResourcePath();
        if (resourcePath == null) {
            sb.append("/");
        } else {
            if (!resourcePath.startsWith("/")) {
                sb.append("/");
            }
            sb.append(resourcePath);
        }
        sb.append(" ");
        if (!getParameters().isEmpty()) {
            sb.append("Parameters: (");
            for (String str : getParameters().keySet()) {
                String str2 = (String) getParameters().get(str);
                sb.append(str);
                sb.append(": ");
                sb.append(str2);
                sb.append(", ");
            }
            sb.append(") ");
        }
        if (!getHeaders().isEmpty()) {
            sb.append("Headers: (");
            for (String str3 : getHeaders().keySet()) {
                String str4 = (String) getHeaders().get(str3);
                sb.append(str3);
                sb.append(": ");
                sb.append(str4);
                sb.append(", ");
            }
            sb.append(") ");
        }
        return sb.toString();
    }

    public Request withParameter(String str, String str2) {
        addParameter(str, str2);
        return this;
    }

    @Deprecated
    public Request withTimeOffset(int i) {
        return withTimeOffset(i);
    }

    public DefaultRequest(String str) {
        this(null, str);
    }

    public void setTimeOffset(long j) {
        this.timeOffset = j;
    }

    public Request withTimeOffset(long j) {
        setTimeOffset(j);
        return this;
    }
}
