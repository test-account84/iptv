package okhttp3.internal.http2;

import okhttp3.internal.concurrent.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http2Connection$sendDegradedPingLater$$inlined$execute$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ String $name;
    final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$sendDegradedPingLater$$inlined$execute$1(String str, boolean z, String str2, boolean z2, Http2Connection http2Connection) {
        super(str2, z2);
        this.$name = str;
        this.$cancelable = z;
        this.this$0 = http2Connection;
    }

    public long runOnce() {
        this.this$0.writePing(false, 2, 0);
        return -1L;
    }
}
