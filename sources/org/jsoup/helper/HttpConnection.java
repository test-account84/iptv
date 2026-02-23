package org.jsoup.helper;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class HttpConnection implements Connection {
    public static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded";
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private Connection.Request req = new Request(null);
    private Connection.Response res = new Response();

    public static abstract class Base implements Connection.Base {
        Map cookies;
        Map headers;
        Connection.Method method;
        URL url;

        private Base() {
            this.headers = new LinkedHashMap();
            this.cookies = new LinkedHashMap();
        }

        private String getHeaderCaseInsensitive(String str) {
            Map.Entry scanHeaders;
            Validate.notNull(str, "Header name must not be null");
            String str2 = (String) this.headers.get(str);
            if (str2 == null) {
                str2 = (String) this.headers.get(str.toLowerCase());
            }
            return (str2 != null || (scanHeaders = scanHeaders(str)) == null) ? str2 : (String) scanHeaders.getValue();
        }

        private Map.Entry scanHeaders(String str) {
            String lowerCase = str.toLowerCase();
            for (Map.Entry entry : this.headers.entrySet()) {
                if (((String) entry.getKey()).toLowerCase().equals(lowerCase)) {
                    return entry;
                }
            }
            return null;
        }

        public String cookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return (String) this.cookies.get(str);
        }

        public Map cookies() {
            return this.cookies;
        }

        public boolean hasCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.cookies.containsKey(str);
        }

        public boolean hasHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            return getHeaderCaseInsensitive(str) != null;
        }

        public boolean hasHeaderWithValue(String str, String str2) {
            return hasHeader(str) && header(str).equalsIgnoreCase(str2);
        }

        public String header(String str) {
            Validate.notNull(str, "Header name must not be null");
            return getHeaderCaseInsensitive(str);
        }

        public Map headers() {
            return this.headers;
        }

        public Connection.Base method(Connection.Method method) {
            Validate.notNull(method, "Method must not be null");
            this.method = method;
            return this;
        }

        public Connection.Base removeCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            this.cookies.remove(str);
            return this;
        }

        public Connection.Base removeHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            Map.Entry scanHeaders = scanHeaders(str);
            if (scanHeaders != null) {
                this.headers.remove(scanHeaders.getKey());
            }
            return this;
        }

        public URL url() {
            return this.url;
        }

        public /* synthetic */ Base(1 r1) {
            this();
        }

        public Connection.Base cookie(String str, String str2) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            Validate.notNull(str2, "Cookie value must not be null");
            this.cookies.put(str, str2);
            return this;
        }

        public Connection.Base header(String str, String str2) {
            Validate.notEmpty(str, "Header name must not be empty");
            Validate.notNull(str2, "Header value must not be null");
            removeHeader(str);
            this.headers.put(str, str2);
            return this;
        }

        public Connection.Method method() {
            return this.method;
        }

        public Connection.Base url(URL url) {
            Validate.notNull(url, "URL must not be null");
            this.url = url;
            return this;
        }
    }

    public static class KeyVal implements Connection.KeyVal {
        private String key;
        private InputStream stream;
        private String value;

        private KeyVal() {
        }

        public static KeyVal create(String str, String str2) {
            return new KeyVal().key(str).value(str2);
        }

        public boolean hasInputStream() {
            return this.stream != null;
        }

        public InputStream inputStream() {
            return this.stream;
        }

        public String key() {
            return this.key;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public String value() {
            return this.value;
        }

        public static KeyVal create(String str, String str2, InputStream inputStream) {
            return new KeyVal().key(str).value(str2).inputStream(inputStream);
        }

        public KeyVal inputStream(InputStream inputStream) {
            Validate.notNull(this.value, "Data input stream must not be null");
            this.stream = inputStream;
            return this;
        }

        public KeyVal key(String str) {
            Validate.notEmpty(str, "Data key must not be empty");
            this.key = str;
            return this;
        }

        public KeyVal value(String str) {
            Validate.notNull(str, "Data value must not be null");
            this.value = str;
            return this;
        }
    }

    public static class Request extends Base implements Connection.Request {
        private Collection data;
        private boolean followRedirects;
        private boolean ignoreContentType;
        private boolean ignoreHttpErrors;
        private int maxBodySizeBytes;
        private Parser parser;
        private boolean parserDefined;
        private String postDataCharset;
        private int timeoutMilliseconds;
        private boolean validateTSLCertificates;

        private Request() {
            super(null);
            this.ignoreHttpErrors = false;
            this.ignoreContentType = false;
            this.parserDefined = false;
            this.validateTSLCertificates = true;
            this.postDataCharset = "UTF-8";
            this.timeoutMilliseconds = 3000;
            this.maxBodySizeBytes = 1048576;
            this.followRedirects = true;
            this.data = new ArrayList();
            this.method = Connection.Method.GET;
            this.headers.put("Accept-Encoding", "gzip");
            this.parser = Parser.htmlParser();
        }

        public static /* synthetic */ boolean access$300(Request request) {
            return request.parserDefined;
        }

        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        public Collection data() {
            return this.data;
        }

        public Connection.Request followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        public Connection.Request ignoreContentType(boolean z) {
            this.ignoreContentType = z;
            return this;
        }

        public Connection.Request ignoreHttpErrors(boolean z) {
            this.ignoreHttpErrors = z;
            return this;
        }

        public int maxBodySize() {
            return this.maxBodySizeBytes;
        }

        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        public String postDataCharset() {
            return this.postDataCharset;
        }

        public int timeout() {
            return this.timeoutMilliseconds;
        }

        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        public void validateTLSCertificates(boolean z) {
            this.validateTSLCertificates = z;
        }

        public /* synthetic */ Request(1 r1) {
            this();
        }

        public boolean followRedirects() {
            return this.followRedirects;
        }

        public boolean ignoreContentType() {
            return this.ignoreContentType;
        }

        public boolean ignoreHttpErrors() {
            return this.ignoreHttpErrors;
        }

        public Connection.Request maxBodySize(int i) {
            Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
            this.maxBodySizeBytes = i;
            return this;
        }

        public Request parser(Parser parser) {
            this.parser = parser;
            this.parserDefined = true;
            return this;
        }

        public Connection.Request postDataCharset(String str) {
            Validate.notNull(str, "Charset must not be null");
            if (!Charset.isSupported(str)) {
                throw new IllegalCharsetNameException(str);
            }
            this.postDataCharset = str;
            return this;
        }

        public boolean validateTLSCertificates() {
            return this.validateTSLCertificates;
        }

        public Request data(Connection.KeyVal keyVal) {
            Validate.notNull(keyVal, "Key val must not be null");
            this.data.add(keyVal);
            return this;
        }

        public Parser parser() {
            return this.parser;
        }

        public Request timeout(int i) {
            Validate.isTrue(i >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.timeoutMilliseconds = i;
            return this;
        }
    }

    public static class Response extends Base implements Connection.Response {
        private static final String LOCATION = "Location";
        private static final int MAX_REDIRECTS = 20;
        private static SSLSocketFactory sslSocketFactory;
        private static final Pattern xmlContentTypeRxp = Pattern.compile("(application|text)/\\w*\\+?xml.*");
        private ByteBuffer byteData;
        private String charset;
        private String contentType;
        private boolean executed;
        private int numRedirects;
        private Connection.Request req;
        private int statusCode;
        private String statusMessage;

        public static class 1 implements HostnameVerifier {
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        }

        public static class 2 implements X509TrustManager {
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }

        public Response() {
            super(null);
            this.executed = false;
            this.numRedirects = 0;
        }

        private static HttpURLConnection createConnection(Connection.Request request) throws IOException {
            HttpsURLConnection httpsURLConnection = (HttpURLConnection) request.url().openConnection();
            httpsURLConnection.setRequestMethod(request.method().name());
            httpsURLConnection.setInstanceFollowRedirects(false);
            httpsURLConnection.setConnectTimeout(request.timeout());
            httpsURLConnection.setReadTimeout(request.timeout());
            if ((httpsURLConnection instanceof HttpsURLConnection) && !request.validateTLSCertificates()) {
                initUnSecureTSL();
                HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                httpsURLConnection2.setSSLSocketFactory(sslSocketFactory);
                httpsURLConnection2.setHostnameVerifier(getInsecureVerifier());
            }
            if (request.method().hasBody()) {
                httpsURLConnection.setDoOutput(true);
            }
            if (request.cookies().size() > 0) {
                httpsURLConnection.addRequestProperty("Cookie", getRequestCookieString(request));
            }
            for (Map.Entry entry : request.headers().entrySet()) {
                httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            return httpsURLConnection;
        }

        public static Response execute(Connection.Request request) throws IOException {
            return execute(request, null);
        }

        private static HostnameVerifier getInsecureVerifier() {
            return new 1();
        }

        private static String getRequestCookieString(Connection.Request request) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (Map.Entry entry : request.cookies().entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append("; ");
                }
                sb.append((String) entry.getKey());
                sb.append('=');
                sb.append((String) entry.getValue());
            }
            return sb.toString();
        }

        private static synchronized void initUnSecureTSL() throws IOException {
            synchronized (Response.class) {
                if (sslSocketFactory == null) {
                    TrustManager[] trustManagerArr = {new 2()};
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("SSL");
                        sSLContext.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
                        sslSocketFactory = sSLContext.getSocketFactory();
                    } catch (NoSuchAlgorithmException unused) {
                        throw new IOException("Can't create unsecure trust manager");
                    } catch (KeyManagementException unused2) {
                        throw new IOException("Can't create unsecure trust manager");
                    }
                }
            }
        }

        private static void serialiseRequestUrl(Connection.Request request) throws IOException {
            boolean z;
            URL url = request.url();
            StringBuilder sb = new StringBuilder();
            sb.append(url.getProtocol());
            sb.append("://");
            sb.append(url.getAuthority());
            sb.append(url.getPath());
            sb.append("?");
            if (url.getQuery() != null) {
                sb.append(url.getQuery());
                z = false;
            } else {
                z = true;
            }
            for (Connection.KeyVal keyVal : request.data()) {
                if (z) {
                    z = false;
                } else {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(keyVal.key(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(keyVal.value(), "UTF-8"));
            }
            request.url(new URL(sb.toString()));
            request.data().clear();
        }

        private static String setOutputContentType(Connection.Request request) {
            boolean z;
            Iterator it = request.data().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (((Connection.KeyVal) it.next()).hasInputStream()) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                request.header("Content-Type", "application/x-www-form-urlencoded; charset=" + request.postDataCharset());
                return null;
            }
            String mimeBoundary = DataUtil.mimeBoundary();
            request.header("Content-Type", "multipart/form-data; boundary=" + mimeBoundary);
            return mimeBoundary;
        }

        private void setupFromConnection(HttpURLConnection httpURLConnection, Connection.Response response) throws IOException {
            this.method = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.url = httpURLConnection.getURL();
            this.statusCode = httpURLConnection.getResponseCode();
            this.statusMessage = httpURLConnection.getResponseMessage();
            this.contentType = httpURLConnection.getContentType();
            processResponseHeaders(httpURLConnection.getHeaderFields());
            if (response != null) {
                for (Map.Entry entry : response.cookies().entrySet()) {
                    if (!hasCookie((String) entry.getKey())) {
                        cookie((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
        }

        private static void writePost(Connection.Request request, OutputStream outputStream, String str) throws IOException {
            Collection<Connection.KeyVal> data = request.data();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            if (str != null) {
                for (Connection.KeyVal keyVal : data) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(HttpConnection.access$400(keyVal.key()));
                    bufferedWriter.write("\"");
                    if (keyVal.hasInputStream()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(HttpConnection.access$400(keyVal.value()));
                        bufferedWriter.write("\"\r\nContent-Type: application/octet-stream\r\n\r\n");
                        bufferedWriter.flush();
                        DataUtil.crossStreams(keyVal.inputStream(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(keyVal.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else {
                boolean z = true;
                for (Connection.KeyVal keyVal2 : data) {
                    if (z) {
                        z = false;
                    } else {
                        bufferedWriter.append('&');
                    }
                    bufferedWriter.write(URLEncoder.encode(keyVal2.key(), request.postDataCharset()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(keyVal2.value(), request.postDataCharset()));
                }
            }
            bufferedWriter.close();
        }

        public String body() {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            String str = this.charset;
            if (str == null) {
                str = "UTF-8";
            }
            String charBuffer = Charset.forName(str).decode(this.byteData).toString();
            this.byteData.rewind();
            return charBuffer;
        }

        public byte[] bodyAsBytes() {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            return this.byteData.array();
        }

        public String charset() {
            return this.charset;
        }

        public String contentType() {
            return this.contentType;
        }

        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        public Document parse() throws IOException {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            Document parseByteData = DataUtil.parseByteData(this.byteData, this.charset, this.url.toExternalForm(), this.req.parser());
            this.byteData.rewind();
            this.charset = parseByteData.outputSettings().charset().name();
            return parseByteData;
        }

        public void processResponseHeaders(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str != null) {
                    List<String> list = (List) entry.getValue();
                    if (str.equalsIgnoreCase("Set-Cookie")) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                TokenQueue tokenQueue = new TokenQueue(str2);
                                String trim = tokenQueue.chompTo("=").trim();
                                String trim2 = tokenQueue.consumeTo(";").trim();
                                if (trim.length() > 0) {
                                    cookie(trim, trim2);
                                }
                            }
                        }
                    } else if (!list.isEmpty()) {
                        header(str, (String) list.get(0));
                    }
                }
            }
        }

        public int statusCode() {
            return this.statusCode;
        }

        public String statusMessage() {
            return this.statusMessage;
        }

        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        private Response(Response response) throws IOException {
            super(null);
            this.executed = false;
            this.numRedirects = 0;
            if (response != null) {
                int i = response.numRedirects + 1;
                this.numRedirects = i;
                if (i >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", new Object[]{response.url()}));
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005e A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:16:0x0055, B:18:0x005e, B:19:0x0069, B:21:0x007d, B:23:0x0083, B:25:0x0095, B:27:0x009d, B:29:0x00a6, B:30:0x00aa, B:31:0x00c3, B:33:0x00c9, B:35:0x00df, B:42:0x00f5, B:44:0x00fb, B:46:0x0101, B:48:0x0109, B:51:0x0116, B:52:0x0125, B:54:0x0128, B:56:0x0134, B:58:0x0138, B:60:0x0141, B:61:0x0148, B:76:0x0190, B:78:0x0195, B:84:0x019b, B:86:0x01a0, B:87:0x01a3, B:63:0x01a4, B:91:0x00ef, B:93:0x01b1, B:94:0x01c0), top: B:15:0x0055 }] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x01a4 A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #1 {all -> 0x0066, blocks: (B:16:0x0055, B:18:0x005e, B:19:0x0069, B:21:0x007d, B:23:0x0083, B:25:0x0095, B:27:0x009d, B:29:0x00a6, B:30:0x00aa, B:31:0x00c3, B:33:0x00c9, B:35:0x00df, B:42:0x00f5, B:44:0x00fb, B:46:0x0101, B:48:0x0109, B:51:0x0116, B:52:0x0125, B:54:0x0128, B:56:0x0134, B:58:0x0138, B:60:0x0141, B:61:0x0148, B:76:0x0190, B:78:0x0195, B:84:0x019b, B:86:0x01a0, B:87:0x01a3, B:63:0x01a4, B:91:0x00ef, B:93:0x01b1, B:94:0x01c0), top: B:15:0x0055 }] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static org.jsoup.helper.HttpConnection.Response execute(org.jsoup.Connection.Request r5, org.jsoup.helper.HttpConnection.Response r6) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 453
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.execute(org.jsoup.Connection$Request, org.jsoup.helper.HttpConnection$Response):org.jsoup.helper.HttpConnection$Response");
        }
    }

    private HttpConnection() {
    }

    public static /* synthetic */ String access$200(String str) {
        return encodeUrl(str);
    }

    public static /* synthetic */ String access$400(String str) {
        return encodeMimeName(str);
    }

    public static Connection connect(String str) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(str);
        return httpConnection;
    }

    private static String encodeMimeName(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\"", "%22");
    }

    private static String encodeUrl(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll(" ", "%20");
    }

    public Connection cookie(String str, String str2) {
        this.req.cookie(str, str2);
        return this;
    }

    public Connection cookies(Map map) {
        Validate.notNull(map, "Cookie map must not be null");
        for (Map.Entry entry : map.entrySet()) {
            this.req.cookie((String) entry.getKey(), (String) entry.getValue());
        }
        return this;
    }

    public Connection data(String str, String str2) {
        this.req.data(KeyVal.create(str, str2));
        return this;
    }

    public Connection.Response execute() throws IOException {
        Response execute = Response.execute(this.req);
        this.res = execute;
        return execute;
    }

    public Connection followRedirects(boolean z) {
        this.req.followRedirects(z);
        return this;
    }

    public Document get() throws IOException {
        this.req.method(Connection.Method.GET);
        execute();
        return this.res.parse();
    }

    public Connection header(String str, String str2) {
        this.req.header(str, str2);
        return this;
    }

    public Connection ignoreContentType(boolean z) {
        this.req.ignoreContentType(z);
        return this;
    }

    public Connection ignoreHttpErrors(boolean z) {
        this.req.ignoreHttpErrors(z);
        return this;
    }

    public Connection maxBodySize(int i) {
        this.req.maxBodySize(i);
        return this;
    }

    public Connection method(Connection.Method method) {
        this.req.method(method);
        return this;
    }

    public Connection parser(Parser parser) {
        this.req.parser(parser);
        return this;
    }

    public Document post() throws IOException {
        this.req.method(Connection.Method.POST);
        execute();
        return this.res.parse();
    }

    public Connection postDataCharset(String str) {
        this.req.postDataCharset(str);
        return this;
    }

    public Connection referrer(String str) {
        Validate.notNull(str, "Referrer must not be null");
        this.req.header("Referer", str);
        return this;
    }

    public Connection.Request request() {
        return this.req;
    }

    public Connection.Response response() {
        return this.res;
    }

    public Connection timeout(int i) {
        this.req.timeout(i);
        return this;
    }

    public Connection url(String str) {
        Validate.notEmpty(str, "Must supply a valid URL");
        try {
            this.req.url(new URL(encodeUrl(str)));
            return this;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Malformed URL: " + str, e);
        }
    }

    public Connection userAgent(String str) {
        Validate.notNull(str, "User agent must not be null");
        this.req.header("User-Agent", str);
        return this;
    }

    public Connection validateTLSCertificates(boolean z) {
        this.req.validateTLSCertificates(z);
        return this;
    }

    public static Connection connect(URL url) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(url);
        return httpConnection;
    }

    public Connection data(String str, String str2, InputStream inputStream) {
        this.req.data(KeyVal.create(str, str2, inputStream));
        return this;
    }

    public Connection request(Connection.Request request) {
        this.req = request;
        return this;
    }

    public Connection response(Connection.Response response) {
        this.res = response;
        return this;
    }

    public Connection url(URL url) {
        this.req.url(url);
        return this;
    }

    public Connection data(Collection collection) {
        Validate.notNull(collection, "Data collection must not be null");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.req.data((Connection.KeyVal) it.next());
        }
        return this;
    }

    public Connection data(Map map) {
        Validate.notNull(map, "Data map must not be null");
        for (Map.Entry entry : map.entrySet()) {
            this.req.data(KeyVal.create((String) entry.getKey(), (String) entry.getValue()));
        }
        return this;
    }

    public Connection data(String... strArr) {
        Validate.notNull(strArr, "Data key value pairs must not be null");
        Validate.isTrue(strArr.length % 2 == 0, "Must supply an even number of key value pairs");
        for (int i = 0; i < strArr.length; i += 2) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            Validate.notEmpty(str, "Data key must not be empty");
            Validate.notNull(str2, "Data value must not be null");
            this.req.data(KeyVal.create(str, str2));
        }
        return this;
    }
}
