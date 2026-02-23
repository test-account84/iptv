package org.apache.http.client.methods;

import java.net.URI;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpPatch extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "PATCH";

    public HttpPatch() {
    }

    public String getMethod() {
        return "PATCH";
    }

    public HttpPatch(String str) {
        setURI(URI.create(str));
    }

    public HttpPatch(URI uri) {
        setURI(uri);
    }
}
