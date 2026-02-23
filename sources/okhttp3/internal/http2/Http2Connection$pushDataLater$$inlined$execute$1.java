package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.concurrent.Task;
import okio.Buffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http2Connection$pushDataLater$$inlined$execute$1 extends Task {
    final /* synthetic */ Buffer $buffer$inlined;
    final /* synthetic */ int $byteCount$inlined;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ boolean $inFinished$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ int $streamId$inlined;
    final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushDataLater$$inlined$execute$1(String str, boolean z, String str2, boolean z2, Http2Connection http2Connection, int i, Buffer buffer, int i2, boolean z3) {
        super(str2, z2);
        this.$name = str;
        this.$cancelable = z;
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
        this.$buffer$inlined = buffer;
        this.$byteCount$inlined = i2;
        this.$inFinished$inlined = z3;
    }

    public long runOnce() {
        try {
            boolean onData = Http2Connection.access$getPushObserver$p(this.this$0).onData(this.$streamId$inlined, this.$buffer$inlined, this.$byteCount$inlined, this.$inFinished$inlined);
            if (onData) {
                this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
            }
            if (!onData && !this.$inFinished$inlined) {
                return -1L;
            }
            synchronized (this.this$0) {
                Http2Connection.access$getCurrentPushRequests$p(this.this$0).remove(Integer.valueOf(this.$streamId$inlined));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
