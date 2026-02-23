package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.l;
import okhttp3.internal.platform.android.SocketAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class DeferredSocketAdapter implements SocketAdapter {
    private SocketAdapter delegate;
    private final Factory socketAdapterFactory;

    public interface Factory {
        @NotNull
        SocketAdapter create(@NotNull SSLSocket sSLSocket);

        boolean matchesSocket(@NotNull SSLSocket sSLSocket);
    }

    public DeferredSocketAdapter(@NotNull Factory socketAdapterFactory) {
        l.e(socketAdapterFactory, "socketAdapterFactory");
        this.socketAdapterFactory = socketAdapterFactory;
    }

    private final synchronized SocketAdapter getDelegate(SSLSocket sSLSocket) {
        try {
            if (this.delegate == null && this.socketAdapterFactory.matchesSocket(sSLSocket)) {
                this.delegate = this.socketAdapterFactory.create(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.delegate;
    }

    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List protocols) {
        l.e(sslSocket, "sslSocket");
        l.e(protocols, "protocols");
        SocketAdapter delegate = getDelegate(sslSocket);
        if (delegate != null) {
            delegate.configureTlsExtensions(sslSocket, str, protocols);
        }
    }

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        SocketAdapter delegate = getDelegate(sslSocket);
        if (delegate != null) {
            return delegate.getSelectedProtocol(sslSocket);
        }
        return null;
    }

    public boolean isSupported() {
        return true;
    }

    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return this.socketAdapterFactory.matchesSocket(sslSocket);
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
