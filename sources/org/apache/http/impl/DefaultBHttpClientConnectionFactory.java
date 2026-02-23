package org.apache.http.impl;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DefaultBHttpClientConnectionFactory implements HttpConnectionFactory {
    public static final DefaultBHttpClientConnectionFactory INSTANCE = new DefaultBHttpClientConnectionFactory();
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageWriterFactory requestWriterFactory;
    private final HttpMessageParserFactory responseParserFactory;

    public DefaultBHttpClientConnectionFactory() {
        this(null, null, null, null, null);
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig connectionConfig) {
        this(connectionConfig, null, null, null, null);
    }

    public DefaultBHttpClientConnection createConnection(Socket socket) throws IOException {
        DefaultBHttpClientConnection defaultBHttpClientConnection = new DefaultBHttpClientConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestWriterFactory, this.responseParserFactory);
        defaultBHttpClientConnection.bind(socket);
        return defaultBHttpClientConnection;
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig connectionConfig, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory httpMessageWriterFactory, HttpMessageParserFactory httpMessageParserFactory) {
        this.cconfig = connectionConfig == null ? ConnectionConfig.DEFAULT : connectionConfig;
        this.incomingContentStrategy = contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2;
        this.requestWriterFactory = httpMessageWriterFactory;
        this.responseParserFactory = httpMessageParserFactory;
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig connectionConfig, HttpMessageWriterFactory httpMessageWriterFactory, HttpMessageParserFactory httpMessageParserFactory) {
        this(connectionConfig, null, null, httpMessageWriterFactory, httpMessageParserFactory);
    }
}
