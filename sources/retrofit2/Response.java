package retrofit2;

import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Response {
    private final Object body;
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    private Response(okhttp3.Response response, Object obj, ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = obj;
        this.errorBody = responseBody;
    }

    public static Response error(int i, ResponseBody responseBody) {
        if (i >= 400) {
            return error(responseBody, new Response.Builder().code(i).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i);
    }

    public static Response success(int i, Object obj) {
        if (i >= 200 && i < 300) {
            return success(obj, new Response.Builder().code(i).message("Response.success()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: " + i);
    }

    public Object body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.code();
    }

    public ResponseBody errorBody() {
        return this.errorBody;
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public okhttp3.Response raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static Response error(ResponseBody responseBody, okhttp3.Response response) {
        Utils.checkNotNull(responseBody, "body == null");
        Utils.checkNotNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new Response(response, null, responseBody);
    }

    public static Response success(Object obj) {
        return success(obj, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static Response success(Object obj, Headers headers) {
        Utils.checkNotNull(headers, "headers == null");
        return success(obj, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static Response success(Object obj, okhttp3.Response response) {
        Utils.checkNotNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new Response(response, obj, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
