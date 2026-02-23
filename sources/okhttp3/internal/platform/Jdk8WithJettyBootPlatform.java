package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = new Companion(null);
    private final Class clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class serverProviderClass;

    public static final class AlpnProvider implements InvocationHandler {
        private final List protocols;

        @Nullable
        private String selected;
        private boolean unsupported;

        public AlpnProvider(@NotNull List protocols) {
            l.e(protocols, "protocols");
            this.protocols = protocols;
        }

        @Nullable
        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        @Nullable
        public Object invoke(@NotNull Object proxy, @NotNull Method method, @Nullable Object[] objArr) throws Throwable {
            l.e(proxy, "proxy");
            l.e(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class returnType = method.getReturnType();
            if (l.a(name, "supports") && l.a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (l.a(name, "unsupported") && l.a(Void.TYPE, returnType)) {
                this.unsupported = true;
                return null;
            }
            if (l.a(name, "protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if ((l.a(name, "selectProtocol") || l.a(name, "select")) && l.a(String.class, returnType) && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            Object obj2 = list.get(i);
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            String str = (String) obj2;
                            if (!this.protocols.contains(str)) {
                                if (i == size) {
                                    break;
                                }
                                i++;
                            } else {
                                this.selected = str;
                                return str;
                            }
                        }
                    }
                    String str2 = (String) this.protocols.get(0);
                    this.selected = str2;
                    return str2;
                }
            }
            if ((!l.a(name, "protocolSelected") && !l.a(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj3 = objArr[0];
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.selected = (String) obj3;
            return null;
        }

        public final void setSelected(@Nullable String str) {
            this.selected = str;
        }

        public final void setUnsupported(boolean z) {
            this.unsupported = z;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Platform buildIfSupported() {
            String jvmVersion = System.getProperty("java.specification.version", "unknown");
            try {
                l.d(jvmVersion, "jvmVersion");
                if (Integer.parseInt(jvmVersion) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, (ClassLoader) null);
                Class cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, (ClassLoader) null);
                Class clientProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, (ClassLoader) null);
                Class serverProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, (ClassLoader) null);
                Method putMethod = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
                Method getMethod = cls.getMethod("get", new Class[]{SSLSocket.class});
                Method removeMethod = cls.getMethod("remove", new Class[]{SSLSocket.class});
                l.d(putMethod, "putMethod");
                l.d(getMethod, "getMethod");
                l.d(removeMethod, "removeMethod");
                l.d(clientProviderClass, "clientProviderClass");
                l.d(serverProviderClass, "serverProviderClass");
                return new Jdk8WithJettyBootPlatform(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public Jdk8WithJettyBootPlatform(@NotNull Method putMethod, @NotNull Method getMethod, @NotNull Method removeMethod, @NotNull Class clientProviderClass, @NotNull Class serverProviderClass) {
        l.e(putMethod, "putMethod");
        l.e(getMethod, "getMethod");
        l.e(removeMethod, "removeMethod");
        l.e(clientProviderClass, "clientProviderClass");
        l.e(serverProviderClass, "serverProviderClass");
        this.putMethod = putMethod;
        this.getMethod = getMethod;
        this.removeMethod = removeMethod;
        this.clientProviderClass = clientProviderClass;
        this.serverProviderClass = serverProviderClass;
    }

    public void afterHandshake(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        try {
            this.removeMethod.invoke((Object) null, new Object[]{sslSocket});
        } catch (InvocationTargetException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List protocols) {
        l.e(sslSocket, "sslSocket");
        l.e(protocols, "protocols");
        try {
            this.putMethod.invoke((Object) null, new Object[]{sslSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(Platform.Companion.alpnProtocolNames(protocols)))});
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke((Object) null, new Object[]{sslSocket}));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
            if (!alpnProvider.getUnsupported() && alpnProvider.getSelected() == null) {
                Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (alpnProvider.getUnsupported()) {
                return null;
            }
            return alpnProvider.getSelected();
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
