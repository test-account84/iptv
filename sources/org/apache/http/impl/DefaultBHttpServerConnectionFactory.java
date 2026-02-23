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
public class DefaultBHttpServerConnectionFactory implements HttpConnectionFactory {
    public static final DefaultBHttpServerConnectionFactory INSTANCE = new DefaultBHttpServerConnectionFactory();
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageParserFactory requestParserFactory;
    private final HttpMessageWriterFactory responseWriterFactory;

    public DefaultBHttpServerConnectionFactory() {
        this(null, null, null, null, null);
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig) {
        this(connectionConfig, null, null, null, null);
    }

    public DefaultBHttpServerConnection createConnection(Socket socket) throws IOException {
        DefaultBHttpServerConnection defaultBHttpServerConnection = new DefaultBHttpServerConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestParserFactory, this.responseWriterFactory);
        defaultBHttpServerConnection.bind(socket);
        return defaultBHttpServerConnection;
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageParserFactory httpMessageParserFactory, HttpMessageWriterFactory httpMessageWriterFactory) {
        this.cconfig = connectionConfig == null ? ConnectionConfig.DEFAULT : connectionConfig;
        this.incomingContentStrategy = contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2;
        this.requestParserFactory = httpMessageParserFactory;
        this.responseWriterFactory = httpMessageWriterFactory;
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig, HttpMessageParserFactory httpMessageParserFactory, HttpMessageWriterFactory httpMessageWriterFactory) {
        this(connectionConfig, null, null, httpMessageParserFactory, httpMessageWriterFactory);
    }
}
