package okhttp3.internal.connection;

import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RealConnection$newWebSocketStreams$1 extends RealWebSocket.Streams {
    final /* synthetic */ Exchange $exchange;
    final /* synthetic */ BufferedSink $sink;
    final /* synthetic */ BufferedSource $source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealConnection$newWebSocketStreams$1(Exchange exchange, BufferedSource bufferedSource, BufferedSink bufferedSink, boolean z, BufferedSource bufferedSource2, BufferedSink bufferedSink2) {
        super(z, bufferedSource2, bufferedSink2);
        this.$exchange = exchange;
        this.$source = bufferedSource;
        this.$sink = bufferedSink;
    }

    public void close() {
        this.$exchange.bodyComplete(-1L, true, true, null);
    }
}
