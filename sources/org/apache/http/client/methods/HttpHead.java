package org.apache.http.client.methods;

import java.net.URI;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpHead extends HttpRequestBase {
    public static final String METHOD_NAME = "HEAD";

    public HttpHead() {
    }

    public String getMethod() {
        return "HEAD";
    }

    public HttpHead(String str) {
        setURI(URI.create(str));
    }

    public HttpHead(URI uri) {
        setURI(uri);
    }
}
