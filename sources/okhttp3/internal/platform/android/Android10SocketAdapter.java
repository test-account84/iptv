package okhttp3.internal.platform.android;

import android.annotation.SuppressLint;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressSignatureCheck
@SuppressLint({"NewApi"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Android10SocketAdapter implements SocketAdapter {
    public static final Companion Companion = new Companion(null);

    @SuppressSignatureCheck
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final SocketAdapter buildIfSupported() {
            if (isSupported()) {
                return new Android10SocketAdapter();
            }
            return null;
        }

        public final boolean isSupported() {
            return Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @SuppressLint({"NewApi"})
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List protocols) {
        l.e(sslSocket, "sslSocket");
        l.e(protocols, "protocols");
        try {
            a.a(sslSocket, true);
            SSLParameters sslParameters = sslSocket.getSSLParameters();
            l.d(sslParameters, "sslParameters");
            Object[] array = Platform.Companion.alpnProtocolNames(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            okhttp3.internal.platform.b.a(sslParameters, (String[]) array);
            sslSocket.setSSLParameters(sslParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }

    @SuppressLint({"NewApi"})
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        String a = c.a(sslSocket);
        if (a == null || (a.hashCode() == 0 && a.equals(""))) {
            return null;
        }
        return a;
    }

    public boolean isSupported() {
        return Companion.isSupported();
    }

    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return b.a(sslSocket);
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
