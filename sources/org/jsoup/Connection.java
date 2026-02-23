package org.jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Connection {

    public interface Base {
        String cookie(String str);

        Base cookie(String str, String str2);

        Map cookies();

        boolean hasCookie(String str);

        boolean hasHeader(String str);

        boolean hasHeaderWithValue(String str, String str2);

        String header(String str);

        Base header(String str, String str2);

        Map headers();

        Base method(Method method);

        Method method();

        Base removeCookie(String str);

        Base removeHeader(String str);

        URL url();

        Base url(URL url);
    }

    public interface KeyVal {
        boolean hasInputStream();

        InputStream inputStream();

        KeyVal inputStream(InputStream inputStream);

        String key();

        KeyVal key(String str);

        String value();

        KeyVal value(String str);
    }

    public enum Method {
        GET(false),
        POST(true),
        PUT(true),
        DELETE(false),
        PATCH(true);

        private final boolean hasBody;

        Method(boolean z) {
            this.hasBody = z;
        }

        public final boolean hasBody() {
            return this.hasBody;
        }
    }

    public interface Request extends Base {
        Collection data();

        Request data(KeyVal keyVal);

        Request followRedirects(boolean z);

        boolean followRedirects();

        Request ignoreContentType(boolean z);

        boolean ignoreContentType();

        Request ignoreHttpErrors(boolean z);

        boolean ignoreHttpErrors();

        int maxBodySize();

        Request maxBodySize(int i);

        Request parser(Parser parser);

        Parser parser();

        String postDataCharset();

        Request postDataCharset(String str);

        int timeout();

        Request timeout(int i);

        void validateTLSCertificates(boolean z);

        boolean validateTLSCertificates();
    }

    public interface Response extends Base {
        String body();

        byte[] bodyAsBytes();

        String charset();

        String contentType();

        Document parse() throws IOException;

        int statusCode();

        String statusMessage();
    }

    Connection cookie(String str, String str2);

    Connection cookies(Map map);

    Connection data(String str, String str2);

    Connection data(String str, String str2, InputStream inputStream);

    Connection data(Collection collection);

    Connection data(Map map);

    Connection data(String... strArr);

    Response execute() throws IOException;

    Connection followRedirects(boolean z);

    Document get() throws IOException;

    Connection header(String str, String str2);

    Connection ignoreContentType(boolean z);

    Connection ignoreHttpErrors(boolean z);

    Connection maxBodySize(int i);

    Connection method(Method method);

    Connection parser(Parser parser);

    Document post() throws IOException;

    Connection postDataCharset(String str);

    Connection referrer(String str);

    Request request();

    Connection request(Request request);

    Response response();

    Connection response(Response response);

    Connection timeout(int i);

    Connection url(String str);

    Connection url(URL url);

    Connection userAgent(String str);

    Connection validateTLSCertificates(boolean z);
}
