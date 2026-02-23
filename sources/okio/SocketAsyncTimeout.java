package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class SocketAsyncTimeout extends AsyncTimeout {
    private final Socket socket;

    public SocketAsyncTimeout(@NotNull Socket socket) {
        l.e(socket, "socket");
        this.socket = socket;
    }

    @NotNull
    public IOException newTimeoutException(@Nullable IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    public void timedOut() {
        Logger access$getLogger$p;
        Level level;
        StringBuilder sb;
        try {
            this.socket.close();
        } catch (AssertionError e) {
            e = e;
            if (!Okio.isAndroidGetsocknameError(e)) {
                throw e;
            }
            access$getLogger$p = Okio__JvmOkioKt.access$getLogger$p();
            level = Level.WARNING;
            sb = new StringBuilder();
            sb.append("Failed to close timed out socket ");
            sb.append(this.socket);
            access$getLogger$p.log(level, sb.toString(), e);
        } catch (Exception e2) {
            e = e2;
            access$getLogger$p = Okio__JvmOkioKt.access$getLogger$p();
            level = Level.WARNING;
            sb = new StringBuilder();
            sb.append("Failed to close timed out socket ");
            sb.append(this.socket);
            access$getLogger$p.log(level, sb.toString(), e);
        }
    }
}
