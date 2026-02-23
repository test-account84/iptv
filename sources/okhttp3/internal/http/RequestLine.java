package okhttp3.internal.http;

import java.net.Proxy;
import kotlin.jvm.internal.l;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RequestLine {
    public static final RequestLine INSTANCE = new RequestLine();

    private RequestLine() {
    }

    private final boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        return !request.isHttps() && type == Proxy.Type.HTTP;
    }

    @NotNull
    public final String get(@NotNull Request request, @NotNull Proxy.Type proxyType) {
        l.e(request, "request");
        l.e(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        RequestLine requestLine = INSTANCE;
        boolean includeAuthorityInRequestLine = requestLine.includeAuthorityInRequestLine(request, proxyType);
        HttpUrl url = request.url();
        if (includeAuthorityInRequestLine) {
            sb.append(url);
        } else {
            sb.append(requestLine.requestPath(url));
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        l.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String requestPath(@NotNull HttpUrl url) {
        l.e(url, "url");
        String encodedPath = url.encodedPath();
        String encodedQuery = url.encodedQuery();
        if (encodedQuery == null) {
            return encodedPath;
        }
        return encodedPath + '?' + encodedQuery;
    }
}
