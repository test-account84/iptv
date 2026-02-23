package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.l;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import org.bouncycastle.jsse.BCSSLSocket;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class BouncyCastleSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    @NotNull
    public SocketAdapter create(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return new BouncyCastleSocketAdapter();
    }

    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return BouncyCastlePlatform.Companion.isSupported() && (sslSocket instanceof BCSSLSocket);
    }
}
