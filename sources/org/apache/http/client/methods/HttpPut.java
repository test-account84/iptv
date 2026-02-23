package org.apache.http.client.methods;

import java.net.URI;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpPut extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "PUT";

    public HttpPut() {
    }

    public String getMethod() {
        return "PUT";
    }

    public HttpPut(String str) {
        setURI(URI.create(str));
    }

    public HttpPut(URI uri) {
        setURI(uri);
    }
}
