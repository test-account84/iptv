package okhttp3.internal.http2;

import okhttp3.internal.concurrent.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http2Connection$$special$$inlined$schedule$1 extends Task {
    final /* synthetic */ String $name;
    final /* synthetic */ long $pingIntervalNanos$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$$special$$inlined$schedule$1(String str, String str2, Http2Connection http2Connection, long j) {
        super(str2, false, 2, null);
        this.$name = str;
        this.this$0 = http2Connection;
        this.$pingIntervalNanos$inlined = j;
    }

    public long runOnce() {
        boolean z;
        synchronized (this.this$0) {
            if (Http2Connection.access$getIntervalPongsReceived$p(this.this$0) < Http2Connection.access$getIntervalPingsSent$p(this.this$0)) {
                z = true;
            } else {
                Http2Connection http2Connection = this.this$0;
                Http2Connection.access$setIntervalPingsSent$p(http2Connection, Http2Connection.access$getIntervalPingsSent$p(http2Connection) + 1);
                z = false;
            }
        }
        Http2Connection http2Connection2 = this.this$0;
        if (z) {
            Http2Connection.access$failConnection(http2Connection2, null);
            return -1L;
        }
        http2Connection2.writePing(false, 1, 0);
        return this.$pingIntervalNanos$inlined;
    }
}
