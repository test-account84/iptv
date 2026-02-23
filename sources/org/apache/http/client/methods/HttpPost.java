package org.apache.http.client.methods;

import java.net.URI;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpPost extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "POST";

    public HttpPost() {
    }

    public String getMethod() {
        return "POST";
    }

    public HttpPost(String str) {
        setURI(URI.create(str));
    }

    public HttpPost(URI uri) {
        setURI(uri);
    }
}
