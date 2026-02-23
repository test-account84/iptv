package okhttp3;

import kotlin.jvm.internal.l;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class WebSocketListener {
    public void onClosed(@NotNull WebSocket webSocket, int i, @NotNull String reason) {
        l.e(webSocket, "webSocket");
        l.e(reason, "reason");
    }

    public void onClosing(@NotNull WebSocket webSocket, int i, @NotNull String reason) {
        l.e(webSocket, "webSocket");
        l.e(reason, "reason");
    }

    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
        l.e(webSocket, "webSocket");
        l.e(t, "t");
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        l.e(webSocket, "webSocket");
        l.e(text, "text");
    }

    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        l.e(webSocket, "webSocket");
        l.e(response, "response");
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
        l.e(webSocket, "webSocket");
        l.e(bytes, "bytes");
    }
}
