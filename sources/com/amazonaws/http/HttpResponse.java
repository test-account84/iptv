package com.amazonaws.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class HttpResponse {
    private InputStream content;
    private final Map headers;
    private final InputStream rawContent;
    private final int statusCode;
    private final String statusText;

    public static class Builder {
        private InputStream content;
        private final Map headers = new HashMap();
        private int statusCode;
        private String statusText;

        public HttpResponse build() {
            return new HttpResponse(this.statusText, this.statusCode, Collections.unmodifiableMap(this.headers), this.content, null);
        }

        public Builder content(InputStream inputStream) {
            this.content = inputStream;
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.put(str, str2);
            return this;
        }

        public Builder statusCode(int i) {
            this.statusCode = i;
            return this;
        }

        public Builder statusText(String str) {
            this.statusText = str;
            return this;
        }
    }

    private HttpResponse(String str, int i, Map map, InputStream inputStream) {
        this.statusText = str;
        this.statusCode = i;
        this.headers = map;
        this.rawContent = inputStream;
    }

    public static Builder builder() {
        return new Builder();
    }

    public InputStream getContent() throws IOException {
        if (this.content == null) {
            synchronized (this) {
                try {
                    this.content = (this.rawContent == null || !"gzip".equals(this.headers.get("Content-Encoding"))) ? this.rawContent : new GZIPInputStream(this.rawContent);
                } finally {
                }
            }
        }
        return this.content;
    }

    public Map getHeaders() {
        return this.headers;
    }

    public InputStream getRawContent() throws IOException {
        return this.rawContent;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public /* synthetic */ HttpResponse(String str, int i, Map map, InputStream inputStream, 1 r5) {
        this(str, i, map, inputStream);
    }
}
