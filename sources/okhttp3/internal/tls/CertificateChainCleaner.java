package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class CertificateChainCleaner {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final CertificateChainCleaner get(@NotNull X509TrustManager trustManager) {
            l.e(trustManager, "trustManager");
            return Platform.Companion.get().buildCertificateChainCleaner(trustManager);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @NotNull
        public final CertificateChainCleaner get(@NotNull X509Certificate... caCerts) {
            l.e(caCerts, "caCerts");
            return new BasicCertificateChainCleaner(new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(caCerts, caCerts.length)));
        }
    }

    @NotNull
    public abstract List clean(@NotNull List list, @NotNull String str) throws SSLPeerUnverifiedException;
}
