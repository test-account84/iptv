package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.l;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import org.conscrypt.Conscrypt;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ConscryptSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    @NotNull
    public SocketAdapter create(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return new ConscryptSocketAdapter();
    }

    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return ConscryptPlatform.Companion.isSupported() && Conscrypt.isConscrypt(sslSocket);
    }
}
