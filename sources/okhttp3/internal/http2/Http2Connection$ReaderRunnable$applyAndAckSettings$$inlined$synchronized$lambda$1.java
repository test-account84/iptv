package okhttp3.internal.http2;

import kotlin.jvm.internal.A;
import kotlin.jvm.internal.B;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ boolean $clearPrevious$inlined;
    final /* synthetic */ A $delta$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ B $newPeerSettings$inlined;
    final /* synthetic */ Settings $settings$inlined;
    final /* synthetic */ B $streamsToNotify$inlined;
    final /* synthetic */ Http2Connection.ReaderRunnable this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1(String str, boolean z, String str2, boolean z2, Http2Connection.ReaderRunnable readerRunnable, B b, boolean z3, Settings settings, A a, B b2) {
        super(str2, z2);
        this.$name = str;
        this.$cancelable = z;
        this.this$0 = readerRunnable;
        this.$newPeerSettings$inlined = b;
        this.$clearPrevious$inlined = z3;
        this.$settings$inlined = settings;
        this.$delta$inlined = a;
        this.$streamsToNotify$inlined = b2;
    }

    public long runOnce() {
        this.this$0.this$0.getListener$okhttp().onSettings(this.this$0.this$0, (Settings) this.$newPeerSettings$inlined.a);
        return -1L;
    }
}
