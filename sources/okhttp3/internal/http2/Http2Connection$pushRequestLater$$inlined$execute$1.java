package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.concurrent.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http2Connection$pushRequestLater$$inlined$execute$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ String $name;
    final /* synthetic */ List $requestHeaders$inlined;
    final /* synthetic */ int $streamId$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushRequestLater$$inlined$execute$1(String str, boolean z, String str2, boolean z2, Http2Connection http2Connection, int i, List list) {
        super(str2, z2);
        this.$name = str;
        this.$cancelable = z;
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
        this.$requestHeaders$inlined = list;
    }

    public long runOnce() {
        if (!Http2Connection.access$getPushObserver$p(this.this$0).onRequest(this.$streamId$inlined, this.$requestHeaders$inlined)) {
            return -1L;
        }
        try {
            this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
            synchronized (this.this$0) {
                Http2Connection.access$getCurrentPushRequests$p(this.this$0).remove(Integer.valueOf(this.$streamId$inlined));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
