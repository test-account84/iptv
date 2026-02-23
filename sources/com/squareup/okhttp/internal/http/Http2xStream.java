package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedStream;
import com.squareup.okhttp.internal.framed.Header;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http2xStream implements HttpStream {
    private static final ByteString CONNECTION;
    private static final ByteString ENCODING;
    private static final ByteString HOST;
    private static final List HTTP_2_SKIPPED_REQUEST_HEADERS;
    private static final List HTTP_2_SKIPPED_RESPONSE_HEADERS;
    private static final ByteString KEEP_ALIVE;
    private static final ByteString PROXY_CONNECTION;
    private static final List SPDY_3_SKIPPED_REQUEST_HEADERS;
    private static final List SPDY_3_SKIPPED_RESPONSE_HEADERS;
    private static final ByteString TE;
    private static final ByteString TRANSFER_ENCODING;
    private static final ByteString UPGRADE;
    private final FramedConnection framedConnection;
    private HttpEngine httpEngine;
    private FramedStream stream;
    private final StreamAllocation streamAllocation;

    public class StreamFinishingSource extends ForwardingSource {
        public StreamFinishingSource(Source source) {
            super(source);
        }

        public void close() throws IOException {
            Http2xStream.access$000(Http2xStream.this).streamFinished(Http2xStream.this);
            super.close();
        }
    }

    static {
        ByteString encodeUtf8 = ByteString.encodeUtf8("connection");
        CONNECTION = encodeUtf8;
        ByteString encodeUtf82 = ByteString.encodeUtf8("host");
        HOST = encodeUtf82;
        ByteString encodeUtf83 = ByteString.encodeUtf8("keep-alive");
        KEEP_ALIVE = encodeUtf83;
        ByteString encodeUtf84 = ByteString.encodeUtf8("proxy-connection");
        PROXY_CONNECTION = encodeUtf84;
        ByteString encodeUtf85 = ByteString.encodeUtf8("transfer-encoding");
        TRANSFER_ENCODING = encodeUtf85;
        ByteString encodeUtf86 = ByteString.encodeUtf8("te");
        TE = encodeUtf86;
        ByteString encodeUtf87 = ByteString.encodeUtf8("encoding");
        ENCODING = encodeUtf87;
        ByteString encodeUtf88 = ByteString.encodeUtf8("upgrade");
        UPGRADE = encodeUtf88;
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.TARGET_AUTHORITY;
        ByteString byteString5 = Header.TARGET_HOST;
        ByteString byteString6 = Header.VERSION;
        SPDY_3_SKIPPED_REQUEST_HEADERS = Util.immutableList(encodeUtf8, encodeUtf82, encodeUtf83, encodeUtf84, encodeUtf85, byteString, byteString2, byteString3, byteString4, byteString5, byteString6);
        SPDY_3_SKIPPED_RESPONSE_HEADERS = Util.immutableList(encodeUtf8, encodeUtf82, encodeUtf83, encodeUtf84, encodeUtf85);
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(encodeUtf8, encodeUtf82, encodeUtf83, encodeUtf84, encodeUtf86, encodeUtf85, encodeUtf87, encodeUtf88, byteString, byteString2, byteString3, byteString4, byteString5, byteString6);
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(encodeUtf8, encodeUtf82, encodeUtf83, encodeUtf84, encodeUtf86, encodeUtf85, encodeUtf87, encodeUtf88);
    }

    public Http2xStream(StreamAllocation streamAllocation, FramedConnection framedConnection) {
        this.streamAllocation = streamAllocation;
        this.framedConnection = framedConnection;
    }

    public static /* synthetic */ StreamAllocation access$000(Http2xStream http2xStream) {
        return http2xStream.streamAllocation;
    }

    public static List http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.httpUrl())));
        arrayList.add(new Header(Header.TARGET_AUTHORITY, Util.hostHeader(request.httpUrl())));
        arrayList.add(new Header(Header.TARGET_SCHEME, request.httpUrl().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8)) {
                arrayList.add(new Header(encodeUtf8, headers.value(i)));
            }
        }
        return arrayList;
    }

    private static String joinOnNull(String str, String str2) {
        return str + (char) 0 + str2;
    }

    public static Response.Builder readHttp2HeadersList(List list) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        String str = null;
        for (int i = 0; i < size; i++) {
            ByteString byteString = ((Header) list.get(i)).name;
            String utf8 = ((Header) list.get(i)).value.utf8();
            if (byteString.equals(Header.RESPONSE_STATUS)) {
                str = utf8;
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
                builder.add(byteString.utf8(), utf8);
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StatusLine parse = StatusLine.parse("HTTP/1.1 " + str);
        return new Response.Builder().protocol(Protocol.HTTP_2).code(parse.code).message(parse.message).headers(builder.build());
    }

    public static Response.Builder readSpdy3HeadersList(List list) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        String str = null;
        String str2 = "HTTP/1.1";
        for (int i = 0; i < size; i++) {
            ByteString byteString = ((Header) list.get(i)).name;
            String utf8 = ((Header) list.get(i)).value.utf8();
            int i2 = 0;
            while (i2 < utf8.length()) {
                int indexOf = utf8.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = utf8.length();
                }
                String substring = utf8.substring(i2, indexOf);
                if (byteString.equals(Header.RESPONSE_STATUS)) {
                    str = substring;
                } else if (byteString.equals(Header.VERSION)) {
                    str2 = substring;
                } else if (!SPDY_3_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
                    builder.add(byteString.utf8(), substring);
                }
                i2 = indexOf + 1;
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StatusLine parse = StatusLine.parse(str2 + " " + str);
        return new Response.Builder().protocol(Protocol.SPDY_3).code(parse.code).message(parse.message).headers(builder.build());
    }

    public static List spdy3HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 5);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.httpUrl())));
        arrayList.add(new Header(Header.VERSION, "HTTP/1.1"));
        arrayList.add(new Header(Header.TARGET_HOST, Util.hostHeader(request.httpUrl())));
        arrayList.add(new Header(Header.TARGET_SCHEME, request.httpUrl().scheme()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!SPDY_3_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8)) {
                String value = headers.value(i);
                if (linkedHashSet.add(encodeUtf8)) {
                    arrayList.add(new Header(encodeUtf8, value));
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        if (((Header) arrayList.get(i2)).name.equals(encodeUtf8)) {
                            arrayList.set(i2, new Header(encodeUtf8, joinOnNull(((Header) arrayList.get(i2)).value.utf8(), value)));
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return arrayList;
    }

    public void cancel() {
        FramedStream framedStream = this.stream;
        if (framedStream != null) {
            framedStream.closeLater(ErrorCode.CANCEL);
        }
    }

    public Sink createRequestBody(Request request, long j) throws IOException {
        return this.stream.getSink();
    }

    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), Okio.buffer(new StreamFinishingSource(this.stream.getSource())));
    }

    public Response.Builder readResponseHeaders() throws IOException {
        return this.framedConnection.getProtocol() == Protocol.HTTP_2 ? readHttp2HeadersList(this.stream.getResponseHeaders()) : readSpdy3HeadersList(this.stream.getResponseHeaders());
    }

    public void setHttpEngine(HttpEngine httpEngine) {
        this.httpEngine = httpEngine;
    }

    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        retryableSink.writeToSocket(this.stream.getSink());
    }

    public void writeRequestHeaders(Request request) throws IOException {
        if (this.stream != null) {
            return;
        }
        this.httpEngine.writingRequestHeaders();
        FramedStream newStream = this.framedConnection.newStream(this.framedConnection.getProtocol() == Protocol.HTTP_2 ? http2HeadersList(request) : spdy3HeadersList(request), this.httpEngine.permitsRequestBody(request), true);
        this.stream = newStream;
        Timeout readTimeout = newStream.readTimeout();
        long readTimeout2 = this.httpEngine.client.getReadTimeout();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        readTimeout.timeout(readTimeout2, timeUnit);
        this.stream.writeTimeout().timeout(this.httpEngine.client.getWriteTimeout(), timeUnit);
    }
}
