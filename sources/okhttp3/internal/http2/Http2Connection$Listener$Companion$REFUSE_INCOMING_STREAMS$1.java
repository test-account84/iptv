package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.jvm.internal.l;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1 extends Http2Connection.Listener {
    public void onStream(@NotNull Http2Stream stream) throws IOException {
        l.e(stream, "stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }
}
