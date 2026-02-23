package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.l;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Internal {
    @NotNull
    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder builder, @NotNull String line) {
        l.e(builder, "builder");
        l.e(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final void applyConnectionSpec(@NotNull ConnectionSpec connectionSpec, @NotNull SSLSocket sslSocket, boolean z) {
        l.e(connectionSpec, "connectionSpec");
        l.e(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z);
    }

    @Nullable
    public static final Response cacheGet(@NotNull Cache cache, @NotNull Request request) {
        l.e(cache, "cache");
        l.e(request, "request");
        return cache.get$okhttp(request);
    }

    @NotNull
    public static final String cookieToString(@NotNull Cookie cookie, boolean z) {
        l.e(cookie, "cookie");
        return cookie.toString$okhttp(z);
    }

    @Nullable
    public static final Cookie parseCookie(long j, @NotNull HttpUrl url, @NotNull String setCookie) {
        l.e(url, "url");
        l.e(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j, url, setCookie);
    }

    @NotNull
    public static final Headers.Builder addHeaderLenient(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        l.e(builder, "builder");
        l.e(name, "name");
        l.e(value, "value");
        return builder.addLenient$okhttp(name, value);
    }
}
