package okhttp3.internal.ws;

import kotlin.jvm.internal.l;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class WebSocketProtocol {

    @NotNull
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    @NotNull
    public final String acceptHeader(@NotNull String key) {
        l.e(key, "key");
        return ByteString.Companion.encodeUtf8(key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
    }

    @Nullable
    public final String closeCodeExceptionMessage(int i) {
        StringBuilder sb;
        if (i < 1000 || i >= 5000) {
            sb = new StringBuilder();
            sb.append("Code must be in range [1000,5000): ");
            sb.append(i);
        } else {
            if ((1004 > i || 1006 < i) && (1015 > i || 2999 < i)) {
                return null;
            }
            sb = new StringBuilder();
            sb.append("Code ");
            sb.append(i);
            sb.append(" is reserved and may not be used.");
        }
        return sb.toString();
    }

    public final void toggleMask(@NotNull Buffer.UnsafeCursor cursor, @NotNull byte[] key) {
        l.e(cursor, "cursor");
        l.e(key, "key");
        int length = key.length;
        int i = 0;
        do {
            byte[] bArr = cursor.data;
            int i2 = cursor.start;
            int i3 = cursor.end;
            if (bArr != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr[i2] = (byte) (bArr[i2] ^ key[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
        } while (cursor.next() != -1);
    }

    public final void validateCloseCode(int i) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i);
        if (closeCodeExceptionMessage == null) {
            return;
        }
        l.b(closeCodeExceptionMessage);
        throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
    }
}
