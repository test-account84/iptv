package org.apache.http.impl.conn;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.config.MessageConstraints;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.protocol.HttpContext;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DefaultManagedHttpClientConnection extends DefaultBHttpClientConnection implements ManagedHttpClientConnection, HttpContext {
    private final Map attributes;
    private final String id;
    private volatile boolean shutdown;

    public DefaultManagedHttpClientConnection(String str, int i) {
        this(str, i, i, null, null, null, null, null, null, null);
    }

    public void bind(Socket socket) throws IOException {
        if (this.shutdown) {
            socket.close();
            throw new InterruptedIOException("Connection already shutdown");
        }
        super.bind(socket);
    }

    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    public String getId() {
        return this.id;
    }

    public SSLSession getSSLSession() {
        SSLSocket socket = super.getSocket();
        if (socket instanceof SSLSocket) {
            return socket.getSession();
        }
        return null;
    }

    public Socket getSocket() {
        return super.getSocket();
    }

    public Object removeAttribute(String str) {
        return this.attributes.remove(str);
    }

    public void setAttribute(String str, Object obj) {
        this.attributes.put(str, obj);
    }

    public void shutdown() throws IOException {
        this.shutdown = true;
        super.shutdown();
    }

    public DefaultManagedHttpClientConnection(String str, int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory httpMessageWriterFactory, HttpMessageParserFactory httpMessageParserFactory) {
        super(i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2, httpMessageWriterFactory, httpMessageParserFactory);
        this.id = str;
        this.attributes = new ConcurrentHashMap();
    }
}
