package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import org.conscrypt.Conscrypt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ConscryptSocketAdapter implements SocketAdapter {
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final DeferredSocketAdapter.Factory factory = new ConscryptSocketAdapter$Companion$factory$1();

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final DeferredSocketAdapter.Factory getFactory() {
            return ConscryptSocketAdapter.access$getFactory$cp();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final /* synthetic */ DeferredSocketAdapter.Factory access$getFactory$cp() {
        return factory;
    }

    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List protocols) {
        l.e(sslSocket, "sslSocket");
        l.e(protocols, "protocols");
        if (matchesSocket(sslSocket)) {
            Conscrypt.setUseSessionTickets(sslSocket, true);
            Object[] array = Platform.Companion.alpnProtocolNames(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
        }
    }

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        if (matchesSocket(sslSocket)) {
            return Conscrypt.getApplicationProtocol(sslSocket);
        }
        return null;
    }

    public boolean isSupported() {
        return ConscryptPlatform.Companion.isSupported();
    }

    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket);
    }

    public boolean matchesSocketFactory(@NotNull SSLSocketFactory sslSocketFactory) {
        l.e(sslSocketFactory, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, sslSocketFactory);
    }

    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        l.e(sslSocketFactory, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.trustManager(this, sslSocketFactory);
    }
}
