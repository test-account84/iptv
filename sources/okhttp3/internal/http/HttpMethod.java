package okhttp3.internal.http;

import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(@NotNull String method) {
        l.e(method, "method");
        return (l.a(method, "GET") || l.a(method, "HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(@NotNull String method) {
        l.e(method, "method");
        return l.a(method, "POST") || l.a(method, "PUT") || l.a(method, "PATCH") || l.a(method, "PROPPATCH") || l.a(method, "REPORT");
    }

    public final boolean invalidatesCache(@NotNull String method) {
        l.e(method, "method");
        return l.a(method, "POST") || l.a(method, "PATCH") || l.a(method, "PUT") || l.a(method, "DELETE") || l.a(method, "MOVE");
    }

    public final boolean redirectsToGet(@NotNull String method) {
        l.e(method, "method");
        return !l.a(method, "PROPFIND");
    }

    public final boolean redirectsWithBody(@NotNull String method) {
        l.e(method, "method");
        return l.a(method, "PROPFIND");
    }
}
