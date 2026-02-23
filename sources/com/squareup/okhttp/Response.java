package com.squareup.okhttp;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.internal.http.OkHeaders;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Response {
    private final ResponseBody body;
    private volatile CacheControl cacheControl;
    private Response cacheResponse;
    private final int code;
    private final Handshake handshake;
    private final Headers headers;
    private final String message;
    private Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final Request request;

    public static class Builder {
        private ResponseBody body;
        private Response cacheResponse;
        private int code;
        private Handshake handshake;
        private Headers.Builder headers;
        private String message;
        private Response networkResponse;
        private Response priorResponse;
        private Protocol protocol;
        private Request request;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Request access$000(Builder builder) {
            return builder.request;
        }

        public static /* synthetic */ Protocol access$100(Builder builder) {
            return builder.protocol;
        }

        public static /* synthetic */ int access$200(Builder builder) {
            return builder.code;
        }

        public static /* synthetic */ String access$300(Builder builder) {
            return builder.message;
        }

        public static /* synthetic */ Handshake access$400(Builder builder) {
            return builder.handshake;
        }

        public static /* synthetic */ Headers.Builder access$500(Builder builder) {
            return builder.headers;
        }

        public static /* synthetic */ ResponseBody access$600(Builder builder) {
            return builder.body;
        }

        public static /* synthetic */ Response access$700(Builder builder) {
            return builder.networkResponse;
        }

        public static /* synthetic */ Response access$800(Builder builder) {
            return builder.cacheResponse;
        }

        public static /* synthetic */ Response access$900(Builder builder) {
            return builder.priorResponse;
        }

        private void checkPriorResponse(Response response) {
            if (Response.access$1700(response) != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void checkSupportResponse(String str, Response response) {
            if (Response.access$1700(response) != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (Response.access$1800(response) != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (Response.access$1900(response) != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (Response.access$2000(response) == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            if (this.request == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.code >= 0) {
                return new Response(this, null);
            }
            throw new IllegalStateException("code < 0: " + this.code);
        }

        public Builder cacheResponse(Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public Builder handshake(Handshake handshake) {
            this.handshake = handshake;
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder networkResponse(Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public Builder priorResponse(Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder request(Request request) {
            this.request = request;
            return this;
        }

        private Builder(Response response) {
            this.code = -1;
            this.request = Response.access$1100(response);
            this.protocol = Response.access$1200(response);
            this.code = Response.access$1300(response);
            this.message = Response.access$1400(response);
            this.handshake = Response.access$1500(response);
            this.headers = Response.access$1600(response).newBuilder();
            this.body = Response.access$1700(response);
            this.networkResponse = Response.access$1800(response);
            this.cacheResponse = Response.access$1900(response);
            this.priorResponse = Response.access$2000(response);
        }

        public /* synthetic */ Builder(Response response, 1 r2) {
            this(response);
        }
    }

    private Response(Builder builder) {
        this.request = Builder.access$000(builder);
        this.protocol = Builder.access$100(builder);
        this.code = Builder.access$200(builder);
        this.message = Builder.access$300(builder);
        this.handshake = Builder.access$400(builder);
        this.headers = Builder.access$500(builder).build();
        this.body = Builder.access$600(builder);
        this.networkResponse = Builder.access$700(builder);
        this.cacheResponse = Builder.access$800(builder);
        this.priorResponse = Builder.access$900(builder);
    }

    public static /* synthetic */ Request access$1100(Response response) {
        return response.request;
    }

    public static /* synthetic */ Protocol access$1200(Response response) {
        return response.protocol;
    }

    public static /* synthetic */ int access$1300(Response response) {
        return response.code;
    }

    public static /* synthetic */ String access$1400(Response response) {
        return response.message;
    }

    public static /* synthetic */ Handshake access$1500(Response response) {
        return response.handshake;
    }

    public static /* synthetic */ Headers access$1600(Response response) {
        return response.headers;
    }

    public static /* synthetic */ ResponseBody access$1700(Response response) {
        return response.body;
    }

    public static /* synthetic */ Response access$1800(Response response) {
        return response.networkResponse;
    }

    public static /* synthetic */ Response access$1900(Response response) {
        return response.cacheResponse;
    }

    public static /* synthetic */ Response access$2000(Response response) {
        return response.priorResponse;
    }

    public ResponseBody body() {
        return this.body;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.headers);
        this.cacheControl = parse;
        return parse;
    }

    public Response cacheResponse() {
        return this.cacheResponse;
    }

    public List challenges() {
        String str;
        int i = this.code;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                return Collections.emptyList();
            }
            str = "Proxy-Authenticate";
        }
        return OkHeaders.parseChallenges(headers(), str);
    }

    public int code() {
        return this.code;
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public String header(String str) {
        return header(str, null);
    }

    public Headers headers() {
        return this.headers;
    }

    public boolean isRedirect() {
        int i = this.code;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean isSuccessful() {
        int i = this.code;
        return i >= 200 && i < 300;
    }

    public String message() {
        return this.message;
    }

    public Response networkResponse() {
        return this.networkResponse;
    }

    public Builder newBuilder() {
        return new Builder(this, null);
    }

    public Response priorResponse() {
        return this.priorResponse;
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public Request request() {
        return this.request;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.urlString() + '}';
    }

    public /* synthetic */ Response(Builder builder, 1 r2) {
        this(builder);
    }

    public String header(String str, String str2) {
        String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    public List headers(String str) {
        return this.headers.values(str);
    }
}
