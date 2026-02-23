package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class HttpRequestFactory {
    private static final String DEFAULT_ENCODING = "UTF-8";

    private void configureHeaders(Map map, Request request, ExecutionContext executionContext, ClientConfiguration clientConfiguration) {
        URI endpoint = request.getEndpoint();
        String host = endpoint.getHost();
        if (HttpUtils.isUsingNonDefaultPort(endpoint)) {
            host = host + ":" + endpoint.getPort();
        }
        map.put("Host", host);
        for (Map.Entry entry : request.getHeaders().entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        if (map.get("Content-Type") == null || ((String) map.get("Content-Type")).isEmpty()) {
            map.put("Content-Type", "application/x-www-form-urlencoded; charset=" + StringUtils.lowerCase("UTF-8"));
        }
        if (executionContext == null || executionContext.getContextUserAgent() == null) {
            return;
        }
        map.put("User-Agent", createUserAgentString(clientConfiguration, executionContext.getContextUserAgent()));
    }

    private String createUserAgentString(ClientConfiguration clientConfiguration, String str) {
        if (clientConfiguration.getUserAgent().contains(str)) {
            return clientConfiguration.getUserAgent();
        }
        return clientConfiguration.getUserAgent() + " " + str;
    }

    public HttpRequest createHttpRequest(Request request, ClientConfiguration clientConfiguration, ExecutionContext executionContext) {
        URI endpoint = request.getEndpoint();
        String encodedUriResourcePath = request.getEncodedUriResourcePath();
        boolean z = true;
        String uri = endpoint.toString();
        String appendUriEncoded = encodedUriResourcePath != null ? HttpUtils.appendUriEncoded(uri, request.getEncodedUriResourcePath()) : HttpUtils.appendUri(uri, request.getResourcePath(), true);
        String encodeParameters = HttpUtils.encodeParameters(request);
        HttpMethodName httpMethod = request.getHttpMethod();
        boolean z2 = request.getContent() != null;
        HttpMethodName httpMethodName = HttpMethodName.POST;
        if (httpMethod == httpMethodName && !z2) {
            z = false;
        }
        if (encodeParameters != null && z) {
            appendUriEncoded = appendUriEncoded + "?" + encodeParameters;
        }
        HashMap hashMap = new HashMap();
        configureHeaders(hashMap, request, executionContext, clientConfiguration);
        InputStream content = request.getContent();
        HttpMethodName httpMethodName2 = HttpMethodName.PATCH;
        if (httpMethod == httpMethodName2) {
            hashMap.put("X-HTTP-Method-Override", httpMethodName2.toString());
            httpMethod = httpMethodName;
        }
        if (httpMethod == httpMethodName && request.getContent() == null && encodeParameters != null) {
            byte[] bytes = encodeParameters.getBytes(StringUtils.UTF8);
            InputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            hashMap.put("Content-Length", String.valueOf(bytes.length));
            content = byteArrayInputStream;
        }
        hashMap.put("Accept-Encoding", (clientConfiguration.isEnableGzip() && hashMap.get("Accept-Encoding") == null) ? "gzip" : "identity");
        HttpRequest httpRequest = new HttpRequest(httpMethod.toString(), URI.create(appendUriEncoded), hashMap, content);
        httpRequest.setStreaming(request.isStreaming());
        return httpRequest;
    }
}
