package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.l;
import okhttp3.ConnectionSpec;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ConnectionSpecSelector {
    private final List connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(@NotNull List connectionSpecs) {
        l.e(connectionSpecs, "connectionSpecs");
        this.connectionSpecs = connectionSpecs;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int size = this.connectionSpecs.size();
        for (int i = this.nextModeIndex; i < size; i++) {
            if (((ConnectionSpec) this.connectionSpecs.get(i)).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final ConnectionSpec configureSecureSocket(@NotNull SSLSocket sslSocket) throws IOException {
        ConnectionSpec connectionSpec;
        l.e(sslSocket, "sslSocket");
        int i = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = (ConnectionSpec) this.connectionSpecs.get(i);
            i++;
            if (connectionSpec.isCompatible(sslSocket)) {
                this.nextModeIndex = i;
                break;
            }
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sslSocket);
            connectionSpec.apply$okhttp(sslSocket, this.isFallback);
            return connectionSpec;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isFallback);
        sb.append(',');
        sb.append(" modes=");
        sb.append(this.connectionSpecs);
        sb.append(',');
        sb.append(" supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        l.b(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        l.d(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean connectionFailed(@NotNull IOException e) {
        l.e(e, "e");
        this.isFallback = true;
        return (!this.isFallbackPossible || (e instanceof ProtocolException) || (e instanceof InterruptedIOException) || ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException) || !(e instanceof SSLException)) ? false : true;
    }
}
