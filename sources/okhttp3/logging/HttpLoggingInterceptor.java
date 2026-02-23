package okhttp3.logging;

import E8.n;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import l8.p;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import org.jetbrains.annotations.NotNull;
import u8.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set headersToRedact;

    @NotNull
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            public static final class DefaultLogger implements Logger {
                public void log(@NotNull String message) {
                    l.e(message, "message");
                    Platform.log$default(Platform.Companion.get(), message, 0, null, 6, null);
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }
        }

        void log(@NotNull String str);
    }

    public HttpLoggingInterceptor() {
        this(null, 1, null);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || n.o(str, "identity", true) || n.o(str, "gzip", true)) ? false : true;
    }

    private final void logHeader(Headers headers, int i) {
        String value = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        this.logger.log(headers.name(i) + ": " + value);
    }

    @NotNull
    public final Level -deprecated_level() {
        return this.level;
    }

    @NotNull
    public final Level getLevel() {
        return this.level;
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        String str;
        String sb;
        Logger logger;
        String str2;
        Charset UTF_8;
        Logger logger2;
        StringBuilder sb2;
        String method;
        String str3;
        Charset UTF_82;
        StringBuilder sb3;
        l.e(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        RequestBody body = request.body();
        Connection connection = chain.connection();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("--> ");
        sb4.append(request.method());
        sb4.append(' ');
        sb4.append(request.url());
        sb4.append(connection != null ? " " + connection.protocol() : "");
        String sb5 = sb4.toString();
        if (!z2 && body != null) {
            sb5 = sb5 + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(sb5);
        if (z2) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType != null && headers.get("Content-Type") == null) {
                    this.logger.log("Content-Type: " + contentType);
                }
                if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log("Content-Length: " + body.contentLength());
                }
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                logHeader(headers, i);
            }
            if (!z || body == null) {
                logger2 = this.logger;
                sb2 = new StringBuilder();
                sb2.append("--> END ");
                method = request.method();
            } else if (bodyHasUnknownEncoding(request.headers())) {
                logger2 = this.logger;
                sb2 = new StringBuilder();
                sb2.append("--> END ");
                sb2.append(request.method());
                method = " (encoded body omitted)";
            } else if (body.isDuplex()) {
                logger2 = this.logger;
                sb2 = new StringBuilder();
                sb2.append("--> END ");
                sb2.append(request.method());
                method = " (duplex request body omitted)";
            } else if (body.isOneShot()) {
                logger2 = this.logger;
                sb2 = new StringBuilder();
                sb2.append("--> END ");
                sb2.append(request.method());
                method = " (one-shot body omitted)";
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                MediaType contentType2 = body.contentType();
                if (contentType2 == null || (UTF_82 = contentType2.charset(StandardCharsets.UTF_8)) == null) {
                    UTF_82 = StandardCharsets.UTF_8;
                    l.d(UTF_82, "UTF_8");
                }
                this.logger.log("");
                if (Utf8Kt.isProbablyUtf8(buffer)) {
                    this.logger.log(buffer.readString(UTF_82));
                    logger2 = this.logger;
                    sb3 = new StringBuilder();
                    sb3.append("--> END ");
                    sb3.append(request.method());
                    sb3.append(" (");
                    sb3.append(body.contentLength());
                    sb3.append("-byte body)");
                } else {
                    logger2 = this.logger;
                    sb3 = new StringBuilder();
                    sb3.append("--> END ");
                    sb3.append(request.method());
                    sb3.append(" (binary ");
                    sb3.append(body.contentLength());
                    sb3.append("-byte body omitted)");
                }
                str3 = sb3.toString();
                logger2.log(str3);
            }
            sb2.append(method);
            str3 = sb2.toString();
            logger2.log(str3);
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            l.b(body2);
            long contentLength = body2.contentLength();
            String str4 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger3 = this.logger;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("<-- ");
            sb6.append(proceed.code());
            if (proceed.message().length() == 0) {
                str = "-byte body omitted)";
                sb = "";
            } else {
                String message = proceed.message();
                StringBuilder sb7 = new StringBuilder();
                str = "-byte body omitted)";
                sb7.append(String.valueOf(' '));
                sb7.append(message);
                sb = sb7.toString();
            }
            sb6.append(sb);
            sb6.append(' ');
            sb6.append(proceed.request().url());
            sb6.append(" (");
            sb6.append(millis);
            sb6.append("ms");
            sb6.append(z2 ? "" : ", " + str4 + " body");
            sb6.append(')');
            logger3.log(sb6.toString());
            if (z2) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    logHeader(headers2, i2);
                }
                if (!z || !HttpHeaders.promisesBody(proceed)) {
                    logger = this.logger;
                    str2 = "<-- END HTTP";
                } else if (bodyHasUnknownEncoding(proceed.headers())) {
                    logger = this.logger;
                    str2 = "<-- END HTTP (encoded body omitted)";
                } else {
                    BufferedSource source = body2.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.getBuffer();
                    Long l = null;
                    if (n.o("gzip", headers2.get("Content-Encoding"), true)) {
                        Long valueOf = Long.valueOf(buffer2.size());
                        GzipSource gzipSource = new GzipSource(buffer2.clone());
                        try {
                            buffer2 = new Buffer();
                            buffer2.writeAll(gzipSource);
                            a.a(gzipSource, null);
                            l = valueOf;
                        } finally {
                        }
                    }
                    MediaType contentType3 = body2.contentType();
                    if (contentType3 == null || (UTF_8 = contentType3.charset(StandardCharsets.UTF_8)) == null) {
                        UTF_8 = StandardCharsets.UTF_8;
                        l.d(UTF_8, "UTF_8");
                    }
                    if (!Utf8Kt.isProbablyUtf8(buffer2)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + buffer2.size() + str);
                        return proceed;
                    }
                    if (contentLength != 0) {
                        this.logger.log("");
                        this.logger.log(buffer2.clone().readString(UTF_8));
                    }
                    this.logger.log(l != null ? "<-- END HTTP (" + buffer2.size() + "-byte, " + l + "-gzipped-byte body)" : "<-- END HTTP (" + buffer2.size() + "-byte body)");
                }
                logger.log(str2);
            }
            return proceed;
        } catch (Exception e) {
            this.logger.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    public final void level(@NotNull Level level) {
        l.e(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(@NotNull String name) {
        l.e(name, "name");
        TreeSet treeSet = new TreeSet(n.p(E.a));
        p.q(treeSet, this.headersToRedact);
        treeSet.add(name);
        this.headersToRedact = treeSet;
    }

    @NotNull
    public final HttpLoggingInterceptor setLevel(@NotNull Level level) {
        l.e(level, "level");
        this.level = level;
        return this;
    }

    public HttpLoggingInterceptor(@NotNull Logger logger) {
        l.e(logger, "logger");
        this.logger = logger;
        this.headersToRedact = l8.E.b();
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i, g gVar) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
