package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.logging.Log;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class LoggingManagedHttpClientConnection extends DefaultManagedHttpClientConnection {
    private final Log headerlog;
    private final Log log;
    private final Wire wire;

    public LoggingManagedHttpClientConnection(String str, Log log, Log log2, Log log3, int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory httpMessageWriterFactory, HttpMessageParserFactory httpMessageParserFactory) {
        super(str, i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2, httpMessageWriterFactory, httpMessageParserFactory);
        this.log = log;
        this.headerlog = log2;
        this.wire = new Wire(log3, str);
    }

    public void close() throws IOException {
        if (super.isOpen()) {
            if (this.log.isDebugEnabled()) {
                this.log.debug(getId() + ": Close connection");
            }
            super.close();
        }
    }

    public InputStream getSocketInputStream(Socket socket) throws IOException {
        InputStream socketInputStream = super.getSocketInputStream(socket);
        return this.wire.enabled() ? new LoggingInputStream(socketInputStream, this.wire) : socketInputStream;
    }

    public OutputStream getSocketOutputStream(Socket socket) throws IOException {
        OutputStream socketOutputStream = super.getSocketOutputStream(socket);
        return this.wire.enabled() ? new LoggingOutputStream(socketOutputStream, this.wire) : socketOutputStream;
    }

    public void onRequestSubmitted(HttpRequest httpRequest) {
        if (httpRequest == null || !this.headerlog.isDebugEnabled()) {
            return;
        }
        this.headerlog.debug(getId() + " >> " + httpRequest.getRequestLine().toString());
        for (Header header : httpRequest.getAllHeaders()) {
            this.headerlog.debug(getId() + " >> " + header.toString());
        }
    }

    public void onResponseReceived(HttpResponse httpResponse) {
        if (httpResponse == null || !this.headerlog.isDebugEnabled()) {
            return;
        }
        this.headerlog.debug(getId() + " << " + httpResponse.getStatusLine().toString());
        for (Header header : httpResponse.getAllHeaders()) {
            this.headerlog.debug(getId() + " << " + header.toString());
        }
    }

    public void setSocketTimeout(int i) {
        if (this.log.isDebugEnabled()) {
            this.log.debug(getId() + ": set socket timeout to " + i);
        }
        super.setSocketTimeout(i);
    }

    public void shutdown() throws IOException {
        if (this.log.isDebugEnabled()) {
            this.log.debug(getId() + ": Shutdown connection");
        }
        super.shutdown();
    }
}
