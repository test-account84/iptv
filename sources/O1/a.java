package o1;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a implements Interceptor {
    public static final Charset c = Charset.forName("UTF-8");
    public final b a;
    public volatile a b;

    public enum a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface b {
        public static final b a = new a();

        public class a implements b {
            public void log(String str) {
                Platform.get().log(4, str, (Throwable) null);
            }
        }

        void log(String str);
    }

    public a() {
        this(b.a);
    }

    public static boolean b(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, buffer.size() < 64 ? buffer.size() : 64L);
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public final boolean a(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity")) ? false : true;
    }

    public a c(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.b = aVar;
        return this;
    }

    public Response intercept(Interceptor.Chain chain) {
        boolean z;
        b bVar;
        String str;
        b bVar2;
        StringBuilder sb;
        String method;
        boolean z2;
        a aVar = this.b;
        Request request = chain.request();
        if (aVar == a.NONE) {
            return chain.proceed(request);
        }
        boolean z3 = aVar == a.BODY;
        boolean z4 = z3 || aVar == a.HEADERS;
        RequestBody body = request.body();
        boolean z5 = body != null;
        Connection connection = chain.connection();
        String str2 = "--> " + request.method() + ' ' + request.url() + ' ' + (connection != null ? connection.protocol() : Protocol.HTTP_1_1);
        if (!z4 && z5) {
            str2 = str2 + " (" + body.contentLength() + "-byte body)";
        }
        this.a.log(str2);
        if (z4) {
            if (z5) {
                if (body.contentType() != null) {
                    this.a.log("Content-Type: " + body.contentType());
                }
                if (body.contentLength() != -1) {
                    this.a.log("Content-Length: " + body.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i = 0;
            while (i < size) {
                String name = headers.name(i);
                int i2 = size;
                if ("Content-Type".equalsIgnoreCase(name) || "Content-Length".equalsIgnoreCase(name)) {
                    z2 = z4;
                } else {
                    z2 = z4;
                    this.a.log(name + ": " + headers.value(i));
                }
                i++;
                size = i2;
                z4 = z2;
            }
            z = z4;
            if (!z3 || !z5) {
                bVar2 = this.a;
                sb = new StringBuilder();
                sb.append("--> END ");
                method = request.method();
            } else if (a(request.headers())) {
                bVar2 = this.a;
                sb = new StringBuilder();
                sb.append("--> END ");
                sb.append(request.method());
                method = " (encoded body omitted)";
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                Charset charset = c;
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    charset = contentType.charset(charset);
                }
                this.a.log("");
                if (b(buffer)) {
                    this.a.log(buffer.readString(charset));
                    bVar2 = this.a;
                    sb = new StringBuilder();
                    sb.append("--> END ");
                    sb.append(request.method());
                    sb.append(" (");
                    sb.append(body.contentLength());
                    sb.append("-byte body)");
                } else {
                    bVar2 = this.a;
                    sb = new StringBuilder();
                    sb.append("--> END ");
                    sb.append(request.method());
                    sb.append(" (binary ");
                    sb.append(body.contentLength());
                    sb.append("-byte body omitted)");
                }
                bVar2.log(sb.toString());
            }
            sb.append(method);
            bVar2.log(sb.toString());
        } else {
            z = z4;
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            String str3 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            b bVar3 = this.a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<-- ");
            sb2.append(proceed.code());
            sb2.append(' ');
            sb2.append(proceed.message());
            sb2.append(' ');
            sb2.append(proceed.request().url());
            sb2.append(" (");
            sb2.append(millis);
            sb2.append("ms");
            sb2.append(z ? "" : ", " + str3 + " body");
            sb2.append(')');
            bVar3.log(sb2.toString());
            if (z) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.a.log(headers2.name(i3) + ": " + headers2.value(i3));
                }
                if (!z3 || !HttpHeaders.hasBody(proceed)) {
                    bVar = this.a;
                    str = "<-- END HTTP";
                } else if (a(proceed.headers())) {
                    bVar = this.a;
                    str = "<-- END HTTP (encoded body omitted)";
                } else {
                    BufferedSource source = body2.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.buffer();
                    Charset charset2 = c;
                    MediaType contentType2 = body2.contentType();
                    if (contentType2 != null) {
                        charset2 = contentType2.charset(charset2);
                    }
                    if (!b(buffer2)) {
                        this.a.log("");
                        this.a.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                        return proceed;
                    }
                    if (contentLength != 0) {
                        this.a.log("");
                        this.a.log(buffer2.clone().readString(charset2));
                    }
                    this.a.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                }
                bVar.log(str);
            }
            return proceed;
        } catch (Exception e) {
            this.a.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    public a(b bVar) {
        this.b = a.NONE;
        this.a = bVar;
    }
}
