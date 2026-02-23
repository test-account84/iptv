package org.apache.http.client.methods;

import java.net.URI;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpTrace extends HttpRequestBase {
    public static final String METHOD_NAME = "TRACE";

    public HttpTrace() {
    }

    public String getMethod() {
        return "TRACE";
    }

    public HttpTrace(String str) {
        setURI(URI.create(str));
    }

    public HttpTrace(URI uri) {
        setURI(uri);
    }
}
