package okhttp3.internal.ws;

import okhttp3.internal.concurrent.Task;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1 extends Task {
    final /* synthetic */ WebSocketExtensions $extensions$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ String $name$inlined;
    final /* synthetic */ long $pingIntervalNanos$inlined;
    final /* synthetic */ RealWebSocket.Streams $streams$inlined;
    final /* synthetic */ RealWebSocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1(String str, String str2, long j, RealWebSocket realWebSocket, String str3, RealWebSocket.Streams streams, WebSocketExtensions webSocketExtensions) {
        super(str2, false, 2, null);
        this.$name = str;
        this.$pingIntervalNanos$inlined = j;
        this.this$0 = realWebSocket;
        this.$name$inlined = str3;
        this.$streams$inlined = streams;
        this.$extensions$inlined = webSocketExtensions;
    }

    public long runOnce() {
        this.this$0.writePingFrame$okhttp();
        return this.$pingIntervalNanos$inlined;
    }
}
