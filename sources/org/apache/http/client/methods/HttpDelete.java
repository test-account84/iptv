package org.apache.http.client.methods;

import java.net.URI;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpDelete extends HttpRequestBase {
    public static final String METHOD_NAME = "DELETE";

    public HttpDelete() {
    }

    public String getMethod() {
        return "DELETE";
    }

    public HttpDelete(String str) {
        setURI(URI.create(str));
    }

    public HttpDelete(URI uri) {
        setURI(uri);
    }
}
