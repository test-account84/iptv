package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface TrustRootIndex {
    @Nullable
    X509Certificate findByIssuerAndSignature(@NotNull X509Certificate x509Certificate);
}
