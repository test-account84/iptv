package okhttp3;

import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface WebSocket {

    public interface Factory {
        @NotNull
        WebSocket newWebSocket(@NotNull Request request, @NotNull WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i, @Nullable String str);

    long queueSize();

    @NotNull
    Request request();

    boolean send(@NotNull String str);

    boolean send(@NotNull ByteString byteString);
}
