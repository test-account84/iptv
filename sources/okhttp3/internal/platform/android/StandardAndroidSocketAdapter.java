package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    public static final Companion Companion = new Companion(null);
    private final Class paramClass;
    private final Class sslSocketFactoryClass;

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(str);
        }

        @Nullable
        public final SocketAdapter buildIfSupported(@NotNull String packageName) {
            l.e(packageName, "packageName");
            try {
                Class cls = Class.forName(packageName + ".OpenSSLSocketImpl");
                Class cls2 = Class.forName(packageName + ".OpenSSLSocketFactoryImpl");
                Class paramsClass = Class.forName(packageName + ".SSLParametersImpl");
                l.d(paramsClass, "paramsClass");
                return new StandardAndroidSocketAdapter(cls, cls2, paramsClass);
            } catch (Exception e) {
                Platform.Companion.get().log("unable to load android socket classes", 5, e);
                return null;
            }
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardAndroidSocketAdapter(@NotNull Class sslSocketClass, @NotNull Class sslSocketFactoryClass, @NotNull Class paramClass) {
        super(sslSocketClass);
        l.e(sslSocketClass, "sslSocketClass");
        l.e(sslSocketFactoryClass, "sslSocketFactoryClass");
        l.e(paramClass, "paramClass");
        this.sslSocketFactoryClass = sslSocketFactoryClass;
        this.paramClass = paramClass;
    }

    public boolean matchesSocketFactory(@NotNull SSLSocketFactory sslSocketFactory) {
        l.e(sslSocketFactory, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sslSocketFactory);
    }

    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        l.e(sslSocketFactory, "sslSocketFactory");
        Object readFieldOrNull = Util.readFieldOrNull(sslSocketFactory, this.paramClass, "sslParameters");
        l.b(readFieldOrNull);
        X509TrustManager x509TrustManager = (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
    }
}
