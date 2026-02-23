package okhttp3.internal.ws;

import kotlin.jvm.internal.B;
import kotlin.jvm.internal.z;
import okhttp3.internal.concurrent.Task;
import okio.ByteString;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1 extends Task {
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ B $messageOrClose$inlined;
    final /* synthetic */ String $name;
    final /* synthetic */ ByteString $pong$inlined;
    final /* synthetic */ B $readerToClose$inlined;
    final /* synthetic */ z $receivedCloseCode$inlined;
    final /* synthetic */ B $receivedCloseReason$inlined;
    final /* synthetic */ B $streamsToClose$inlined;
    final /* synthetic */ WebSocketWriter $writer$inlined;
    final /* synthetic */ B $writerToClose$inlined;
    final /* synthetic */ RealWebSocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1(String str, boolean z, String str2, boolean z2, RealWebSocket realWebSocket, WebSocketWriter webSocketWriter, ByteString byteString, B b, z zVar, B b2, B b3, B b4, B b5) {
        super(str2, z2);
        this.$name = str;
        this.$cancelable = z;
        this.this$0 = realWebSocket;
        this.$writer$inlined = webSocketWriter;
        this.$pong$inlined = byteString;
        this.$messageOrClose$inlined = b;
        this.$receivedCloseCode$inlined = zVar;
        this.$receivedCloseReason$inlined = b2;
        this.$streamsToClose$inlined = b3;
        this.$readerToClose$inlined = b4;
        this.$writerToClose$inlined = b5;
    }

    public long runOnce() {
        this.this$0.cancel();
        return -1L;
    }
}
