package org.apache.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpMessage;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ChunkedOutputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.ContentLengthOutputStream;
import org.apache.http.impl.io.EmptyInputStream;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.impl.io.IdentityInputStream;
import org.apache.http.impl.io.IdentityOutputStream;
import org.apache.http.impl.io.SessionInputBufferImpl;
import org.apache.http.impl.io.SessionOutputBufferImpl;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.NetUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BHttpConnectionBase implements HttpConnection, HttpInetConnection {
    private final HttpConnectionMetricsImpl connMetrics;
    private final SessionInputBufferImpl inbuffer;
    private final ContentLengthStrategy incomingContentStrategy;
    private final MessageConstraints messageConstraints;
    private final SessionOutputBufferImpl outbuffer;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final AtomicReference socketHolder;

    public BHttpConnectionBase(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2) {
        Args.positive(i, "Buffer size");
        HttpTransportMetricsImpl httpTransportMetricsImpl = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl httpTransportMetricsImpl2 = new HttpTransportMetricsImpl();
        this.inbuffer = new SessionInputBufferImpl(httpTransportMetricsImpl, i, -1, messageConstraints != null ? messageConstraints : MessageConstraints.DEFAULT, charsetDecoder);
        this.outbuffer = new SessionOutputBufferImpl(httpTransportMetricsImpl2, i, i2, charsetEncoder);
        this.messageConstraints = messageConstraints;
        this.connMetrics = new HttpConnectionMetricsImpl(httpTransportMetricsImpl, httpTransportMetricsImpl2);
        this.incomingContentStrategy = contentLengthStrategy != null ? contentLengthStrategy : LaxContentLengthStrategy.INSTANCE;
        this.outgoingContentStrategy = contentLengthStrategy2 != null ? contentLengthStrategy2 : StrictContentLengthStrategy.INSTANCE;
        this.socketHolder = new AtomicReference();
    }

    private int fillInputBuffer(int i) throws IOException {
        Socket socket = (Socket) this.socketHolder.get();
        int soTimeout = socket.getSoTimeout();
        try {
            socket.setSoTimeout(i);
            return this.inbuffer.fillBuffer();
        } finally {
            socket.setSoTimeout(soTimeout);
        }
    }

    public boolean awaitInput(int i) throws IOException {
        if (this.inbuffer.hasBufferedData()) {
            return true;
        }
        fillInputBuffer(i);
        return this.inbuffer.hasBufferedData();
    }

    public void bind(Socket socket) throws IOException {
        Args.notNull(socket, "Socket");
        this.socketHolder.set(socket);
        this.inbuffer.bind(null);
        this.outbuffer.bind(null);
    }

    public void close() throws IOException {
        Socket socket = (Socket) this.socketHolder.getAndSet((Object) null);
        if (socket != null) {
            try {
                this.inbuffer.clear();
                this.outbuffer.flush();
                try {
                    try {
                        socket.shutdownOutput();
                    } catch (UnsupportedOperationException | IOException unused) {
                    }
                } catch (IOException unused2) {
                }
                socket.shutdownInput();
            } finally {
                socket.close();
            }
        }
    }

    public InputStream createInputStream(long j, SessionInputBuffer sessionInputBuffer) {
        return j == -2 ? new ChunkedInputStream(sessionInputBuffer, this.messageConstraints) : j == -1 ? new IdentityInputStream(sessionInputBuffer) : j == 0 ? EmptyInputStream.INSTANCE : new ContentLengthInputStream(sessionInputBuffer, j);
    }

    public OutputStream createOutputStream(long j, SessionOutputBuffer sessionOutputBuffer) {
        return j == -2 ? new ChunkedOutputStream(2048, sessionOutputBuffer) : j == -1 ? new IdentityOutputStream(sessionOutputBuffer) : new ContentLengthOutputStream(sessionOutputBuffer, j);
    }

    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    public void ensureOpen() throws IOException {
        Socket socket = (Socket) this.socketHolder.get();
        if (socket == null) {
            throw new ConnectionClosedException("Connection is closed");
        }
        if (!this.inbuffer.isBound()) {
            this.inbuffer.bind(getSocketInputStream(socket));
        }
        if (this.outbuffer.isBound()) {
            return;
        }
        this.outbuffer.bind(getSocketOutputStream(socket));
    }

    public InetAddress getLocalAddress() {
        Socket socket = (Socket) this.socketHolder.get();
        if (socket != null) {
            return socket.getLocalAddress();
        }
        return null;
    }

    public int getLocalPort() {
        Socket socket = (Socket) this.socketHolder.get();
        if (socket != null) {
            return socket.getLocalPort();
        }
        return -1;
    }

    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    public InetAddress getRemoteAddress() {
        Socket socket = (Socket) this.socketHolder.get();
        if (socket != null) {
            return socket.getInetAddress();
        }
        return null;
    }

    public int getRemotePort() {
        Socket socket = (Socket) this.socketHolder.get();
        if (socket != null) {
            return socket.getPort();
        }
        return -1;
    }

    public SessionInputBuffer getSessionInputBuffer() {
        return this.inbuffer;
    }

    public SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    public Socket getSocket() {
        return (Socket) this.socketHolder.get();
    }

    public InputStream getSocketInputStream(Socket socket) throws IOException {
        return socket.getInputStream();
    }

    public OutputStream getSocketOutputStream(Socket socket) throws IOException {
        return socket.getOutputStream();
    }

    public int getSocketTimeout() {
        Socket socket = (Socket) this.socketHolder.get();
        if (socket != null) {
            try {
                return socket.getSoTimeout();
            } catch (SocketException unused) {
            }
        }
        return -1;
    }

    public void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    public void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    public boolean isOpen() {
        return this.socketHolder.get() != null;
    }

    public boolean isStale() {
        if (!isOpen()) {
            return true;
        }
        try {
            return fillInputBuffer(1) < 0;
        } catch (SocketTimeoutException unused) {
            return false;
        } catch (IOException unused2) {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.http.HttpEntity prepareInput(org.apache.http.HttpMessage r10) throws org.apache.http.HttpException {
        /*
            r9 = this;
            org.apache.http.entity.BasicHttpEntity r0 = new org.apache.http.entity.BasicHttpEntity
            r0.<init>()
            org.apache.http.entity.ContentLengthStrategy r1 = r9.incomingContentStrategy
            long r1 = r1.determineLength(r10)
            org.apache.http.impl.io.SessionInputBufferImpl r3 = r9.inbuffer
            java.io.InputStream r3 = r9.createInputStream(r1, r3)
            r4 = -2
            r6 = -1
            int r8 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r8 != 0) goto L24
            r1 = 1
            r0.setChunked(r1)
        L1d:
            r0.setContentLength(r6)
        L20:
            r0.setContent(r3)
            goto L31
        L24:
            r4 = 0
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            r0.setChunked(r4)
            if (r5 != 0) goto L2d
            goto L1d
        L2d:
            r0.setContentLength(r1)
            goto L20
        L31:
            java.lang.String r1 = "Content-Type"
            org.apache.http.Header r1 = r10.getFirstHeader(r1)
            if (r1 == 0) goto L3c
            r0.setContentType(r1)
        L3c:
            java.lang.String r1 = "Content-Encoding"
            org.apache.http.Header r10 = r10.getFirstHeader(r1)
            if (r10 == 0) goto L47
            r0.setContentEncoding(r10)
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.BHttpConnectionBase.prepareInput(org.apache.http.HttpMessage):org.apache.http.HttpEntity");
    }

    public OutputStream prepareOutput(HttpMessage httpMessage) throws HttpException {
        return createOutputStream(this.outgoingContentStrategy.determineLength(httpMessage), this.outbuffer);
    }

    public void setSocketTimeout(int i) {
        Socket socket = (Socket) this.socketHolder.get();
        if (socket != null) {
            try {
                socket.setSoTimeout(i);
            } catch (SocketException unused) {
            }
        }
    }

    public void shutdown() throws IOException {
        Socket socket = (Socket) this.socketHolder.getAndSet((Object) null);
        if (socket != null) {
            try {
                socket.setSoLinger(true, 0);
            } catch (IOException unused) {
            } catch (Throwable th) {
                socket.close();
                throw th;
            }
            socket.close();
        }
    }

    public String toString() {
        Socket socket = (Socket) this.socketHolder.get();
        if (socket == null) {
            return "[Not bound]";
        }
        StringBuilder sb = new StringBuilder();
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        SocketAddress localSocketAddress = socket.getLocalSocketAddress();
        if (remoteSocketAddress != null && localSocketAddress != null) {
            NetUtils.formatAddress(sb, localSocketAddress);
            sb.append("<->");
            NetUtils.formatAddress(sb, remoteSocketAddress);
        }
        return sb.toString();
    }
}
