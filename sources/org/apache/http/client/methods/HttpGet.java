package org.apache.http.client.methods;

import java.net.URI;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpGet extends HttpRequestBase {
    public static final String METHOD_NAME = "GET";

    public HttpGet() {
    }

    public String getMethod() {
        return "GET";
    }

    public HttpGet(String str) {
        setURI(URI.create(str));
    }

    public HttpGet(URI uri) {
        setURI(uri);
    }
}
