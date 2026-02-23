package com.squareup.okhttp;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Cache {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    public class 1 implements InternalCache {
        public 1() {
        }

        public Response get(Request request) throws IOException {
            return Cache.this.get(request);
        }

        public CacheRequest put(Response response) throws IOException {
            return Cache.access$000(Cache.this, response);
        }

        public void remove(Request request) throws IOException {
            Cache.access$100(Cache.this, request);
        }

        public void trackConditionalCacheHit() {
            Cache.access$300(Cache.this);
        }

        public void trackResponse(CacheStrategy cacheStrategy) {
            Cache.access$400(Cache.this, cacheStrategy);
        }

        public void update(Response response, Response response2) throws IOException {
            Cache.access$200(Cache.this, response, response2);
        }
    }

    public class 2 implements Iterator {
        boolean canRemove;
        final Iterator delegate;
        String nextUrl;

        public 2() throws IOException {
            this.delegate = Cache.access$600(Cache.this).snapshots();
        }

        public boolean hasNext() {
            if (this.nextUrl != null) {
                return true;
            }
            this.canRemove = false;
            while (this.delegate.hasNext()) {
                DiskLruCache.Snapshot snapshot = (DiskLruCache.Snapshot) this.delegate.next();
                try {
                    this.nextUrl = Okio.buffer(snapshot.getSource(0)).readUtf8LineStrict();
                    return true;
                } catch (IOException unused) {
                } finally {
                    snapshot.close();
                }
            }
            return false;
        }

        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("remove() before next()");
            }
            this.delegate.remove();
        }

        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.nextUrl;
            this.nextUrl = null;
            this.canRemove = true;
            return str;
        }
    }

    public final class CacheRequestImpl implements CacheRequest {
        private Sink body;
        private Sink cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;

        public class 1 extends ForwardingSink {
            final /* synthetic */ DiskLruCache.Editor val$editor;
            final /* synthetic */ Cache val$this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public 1(Sink sink, Cache cache, DiskLruCache.Editor editor) {
                super(sink);
                this.val$this$0 = cache;
                this.val$editor = editor;
            }

            public void close() throws IOException {
                synchronized (Cache.this) {
                    try {
                        if (CacheRequestImpl.access$700(CacheRequestImpl.this)) {
                            return;
                        }
                        CacheRequestImpl.access$702(CacheRequestImpl.this, true);
                        Cache.access$808(Cache.this);
                        super.close();
                        this.val$editor.commit();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public CacheRequestImpl(DiskLruCache.Editor editor) throws IOException {
            this.editor = editor;
            Sink newSink = editor.newSink(1);
            this.cacheOut = newSink;
            this.body = new 1(newSink, Cache.this, editor);
        }

        public static /* synthetic */ boolean access$700(CacheRequestImpl cacheRequestImpl) {
            return cacheRequestImpl.done;
        }

        public static /* synthetic */ boolean access$702(CacheRequestImpl cacheRequestImpl, boolean z) {
            cacheRequestImpl.done = z;
            return z;
        }

        public void abort() {
            synchronized (Cache.this) {
                try {
                    if (this.done) {
                        return;
                    }
                    this.done = true;
                    Cache.access$908(Cache.this);
                    Util.closeQuietly(this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Sink body() {
            return this.body;
        }
    }

    public static class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public class 1 extends ForwardingSource {
            final /* synthetic */ DiskLruCache.Snapshot val$snapshot;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public 1(Source source, DiskLruCache.Snapshot snapshot) {
                super(source);
                this.val$snapshot = snapshot;
            }

            public void close() throws IOException {
                this.val$snapshot.close();
                super.close();
            }
        }

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.buffer(new 1(snapshot.getSource(1), snapshot));
        }

        public static /* synthetic */ DiskLruCache.Snapshot access$500(CacheResponseBody cacheResponseBody) {
            return cacheResponseBody.snapshot;
        }

        public long contentLength() {
            try {
                String str = this.contentLength;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public BufferedSource source() {
            return this.bodySource;
        }
    }

    public static final class Entry {
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final String url;
        private final Headers varyHeaders;

        public Entry(Response response) {
            this.url = response.request().urlString();
            this.varyHeaders = OkHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List readCertificateList(BufferedSource bufferedSource) throws IOException {
            int access$1000 = Cache.access$1000(bufferedSource);
            if (access$1000 == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(access$1000);
                for (int i = 0; i < access$1000; i++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertList(BufferedSink bufferedSink, List list) throws IOException {
            try {
                bufferedSink.writeDecimalLong(list.size());
                bufferedSink.writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(ByteString.of(((Certificate) list.get(i)).getEncoded()).base64());
                    bufferedSink.writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean matches(Request request, Response response) {
            return this.url.equals(request.urlString()) && this.requestMethod.equals(request.method()) && OkHeaders.varyMatches(response, this.varyHeaders, request);
        }

        public Response response(Request request, DiskLruCache.Snapshot snapshot) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).build();
        }

        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.url);
            buffer.writeByte(10);
            buffer.writeUtf8(this.requestMethod);
            buffer.writeByte(10);
            buffer.writeDecimalLong(this.varyHeaders.size());
            buffer.writeByte(10);
            int size = this.varyHeaders.size();
            for (int i = 0; i < size; i++) {
                buffer.writeUtf8(this.varyHeaders.name(i));
                buffer.writeUtf8(": ");
                buffer.writeUtf8(this.varyHeaders.value(i));
                buffer.writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString());
            buffer.writeByte(10);
            buffer.writeDecimalLong(this.responseHeaders.size());
            buffer.writeByte(10);
            int size2 = this.responseHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                buffer.writeUtf8(this.responseHeaders.name(i2));
                buffer.writeUtf8(": ");
                buffer.writeUtf8(this.responseHeaders.value(i2));
                buffer.writeByte(10);
            }
            if (isHttps()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.handshake.cipherSuite());
                buffer.writeByte(10);
                writeCertList(buffer, this.handshake.peerCertificates());
                writeCertList(buffer, this.handshake.localCertificates());
            }
            buffer.close();
        }

        public Entry(Source source) throws IOException {
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.url = buffer.readUtf8LineStrict();
                this.requestMethod = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int access$1000 = Cache.access$1000(buffer);
                for (int i = 0; i < access$1000; i++) {
                    builder.addLenient(buffer.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int access$10002 = Cache.access$1000(buffer);
                for (int i2 = 0; i2 < access$10002; i2++) {
                    builder2.addLenient(buffer.readUtf8LineStrict());
                }
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                    this.handshake = Handshake.get(buffer.readUtf8LineStrict(), readCertificateList(buffer), readCertificateList(buffer));
                } else {
                    this.handshake = null;
                }
                source.close();
            } catch (Throwable th) {
                source.close();
                throw th;
            }
        }
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    private void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static /* synthetic */ CacheRequest access$000(Cache cache, Response response) throws IOException {
        return cache.put(response);
    }

    public static /* synthetic */ void access$100(Cache cache, Request request) throws IOException {
        cache.remove(request);
    }

    public static /* synthetic */ int access$1000(BufferedSource bufferedSource) throws IOException {
        return readInt(bufferedSource);
    }

    public static /* synthetic */ void access$200(Cache cache, Response response, Response response2) {
        cache.update(response, response2);
    }

    public static /* synthetic */ void access$300(Cache cache) {
        cache.trackConditionalCacheHit();
    }

    public static /* synthetic */ void access$400(Cache cache, CacheStrategy cacheStrategy) {
        cache.trackResponse(cacheStrategy);
    }

    public static /* synthetic */ DiskLruCache access$600(Cache cache) {
        return cache.cache;
    }

    public static /* synthetic */ int access$808(Cache cache) {
        int i = cache.writeSuccessCount;
        cache.writeSuccessCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$908(Cache cache) {
        int i = cache.writeAbortCount;
        cache.writeAbortCount = i + 1;
        return i;
    }

    private CacheRequest put(Response response) throws IOException {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!method.equals("GET") || OkHeaders.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editor = this.cache.edit(urlToKey(response.request()));
            if (editor == null) {
                return null;
            }
            try {
                entry.writeTo(editor);
                return new CacheRequestImpl(editor);
            } catch (IOException unused2) {
                abortQuietly(editor);
                return null;
            }
        } catch (IOException unused3) {
            editor = null;
        }
    }

    private static int readInt(BufferedSource bufferedSource) throws IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    private void remove(Request request) throws IOException {
        this.cache.remove(urlToKey(request));
    }

    private synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    private synchronized void trackResponse(CacheStrategy cacheStrategy) {
        try {
            this.requestCount++;
            if (cacheStrategy.networkRequest != null) {
                this.networkCount++;
            } else if (cacheStrategy.cacheResponse != null) {
                this.hitCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void update(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = CacheResponseBody.access$500((CacheResponseBody) response.body()).edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                    abortQuietly(editor);
                }
            }
        } catch (IOException unused2) {
            editor = null;
        }
    }

    private static String urlToKey(Request request) {
        return Util.md5Hex(request.urlString());
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    public Response get(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(urlToKey(request));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(request, snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                Util.closeQuietly(response.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public File getDirectory() {
        return this.cache.getDirectory();
    }

    public synchronized int getHitCount() {
        return this.hitCount;
    }

    public long getMaxSize() {
        return this.cache.getMaxSize();
    }

    public synchronized int getNetworkCount() {
        return this.networkCount;
    }

    public synchronized int getRequestCount() {
        return this.requestCount;
    }

    public long getSize() throws IOException {
        return this.cache.size();
    }

    public synchronized int getWriteAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int getWriteSuccessCount() {
        return this.writeSuccessCount;
    }

    public void initialize() throws IOException {
        this.cache.initialize();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public Iterator urls() throws IOException {
        return new 2();
    }

    public Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new 1();
        this.cache = DiskLruCache.create(fileSystem, file, 201105, 2, j);
    }
}
