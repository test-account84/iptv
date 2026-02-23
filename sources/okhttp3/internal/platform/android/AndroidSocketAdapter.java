package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class AndroidSocketAdapter implements SocketAdapter {
    public static final Companion Companion;

    @NotNull
    private static final DeferredSocketAdapter.Factory playProviderFactory;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class sslSocketClass;

    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ AndroidSocketAdapter access$build(Companion companion, Class cls) {
            return companion.build(cls);
        }

        private final AndroidSocketAdapter build(Class cls) {
            Class cls2 = cls;
            while (cls2 != null && (!l.a(cls2.getSimpleName(), "OpenSSLSocketImpl"))) {
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            l.b(cls2);
            return new AndroidSocketAdapter(cls2);
        }

        @NotNull
        public final DeferredSocketAdapter.Factory factory(@NotNull String packageName) {
            l.e(packageName, "packageName");
            return new AndroidSocketAdapter$Companion$factory$1(packageName);
        }

        @NotNull
        public final DeferredSocketAdapter.Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.access$getPlayProviderFactory$cp();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        playProviderFactory = companion.factory("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter(@NotNull Class sslSocketClass) {
        l.e(sslSocketClass, "sslSocketClass");
        this.sslSocketClass = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", new Class[]{Boolean.TYPE});
        l.d(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = sslSocketClass.getMethod("setHostname", new Class[]{String.class});
        this.getAlpnSelectedProtocol = sslSocketClass.getMethod("getAlpnSelectedProtocol", (Class[]) null);
        this.setAlpnProtocols = sslSocketClass.getMethod("setAlpnProtocols", new Class[]{byte[].class});
    }

    public static final /* synthetic */ DeferredSocketAdapter.Factory access$getPlayProviderFactory$cp() {
        return playProviderFactory;
    }

    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List protocols) {
        l.e(sslSocket, "sslSocket");
        l.e(protocols, "protocols");
        if (matchesSocket(sslSocket)) {
            try {
                this.setUseSessionTickets.invoke(sslSocket, new Object[]{Boolean.TRUE});
                if (str != null) {
                    this.setHostname.invoke(sslSocket, new Object[]{str});
                }
                this.setAlpnProtocols.invoke(sslSocket, new Object[]{Platform.Companion.concatLengthPrefixed(protocols)});
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        if (!matchesSocket(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.getAlpnSelectedProtocol.invoke(sslSocket, (Object[]) null);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            l.d(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError(e2);
        } catch (NullPointerException e3) {
            if (l.a(e3.getMessage(), "ssl == null")) {
                return null;
            }
            throw e3;
        }
    }

    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return this.sslSocketClass.isInstance(sslSocket);
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
