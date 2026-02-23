package com.squareup.okhttp.internal;

import android.util.Log;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.tls.AndroidTrustRootIndex;
import com.squareup.okhttp.internal.tls.RealTrustRootIndex;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Platform {
    private static final Platform PLATFORM = findPlatform();

    public static class Android extends Platform {
        private static final int MAX_LOG_LENGTH = 4000;
        private final OptionalMethod getAlpnSelectedProtocol;
        private final OptionalMethod setAlpnProtocols;
        private final OptionalMethod setHostname;
        private final OptionalMethod setUseSessionTickets;
        private final Class sslParametersClass;
        private final Method trafficStatsTagSocket;
        private final Method trafficStatsUntagSocket;

        public Android(Class cls, OptionalMethod optionalMethod, OptionalMethod optionalMethod2, Method method, Method method2, OptionalMethod optionalMethod3, OptionalMethod optionalMethod4) {
            this.sslParametersClass = cls;
            this.setUseSessionTickets = optionalMethod;
            this.setHostname = optionalMethod2;
            this.trafficStatsTagSocket = method;
            this.trafficStatsUntagSocket = method2;
            this.getAlpnSelectedProtocol = optionalMethod3;
            this.setAlpnProtocols = optionalMethod4;
        }

        public void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
            if (str != null) {
                this.setUseSessionTickets.invokeOptionalWithoutCheckedException(sSLSocket, Boolean.TRUE);
                this.setHostname.invokeOptionalWithoutCheckedException(sSLSocket, str);
            }
            OptionalMethod optionalMethod = this.setAlpnProtocols;
            if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket)) {
                return;
            }
            this.setAlpnProtocols.invokeWithoutCheckedException(sSLSocket, Platform.concatLengthPrefixed(list));
        }

        public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (SecurityException e) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e);
                throw iOException;
            } catch (AssertionError e2) {
                if (!Util.isAndroidGetsocknameError(e2)) {
                    throw e2;
                }
                throw new IOException(e2);
            }
        }

        public String getSelectedProtocol(SSLSocket sSLSocket) {
            byte[] bArr;
            OptionalMethod optionalMethod = this.getAlpnSelectedProtocol;
            if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket) || (bArr = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, Util.UTF_8);
        }

        public void log(String str) {
            int min;
            int length = str.length();
            int i = 0;
            while (i < length) {
                int indexOf = str.indexOf(10, i);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i + 4000);
                    Log.d("OkHttp", str.substring(i, min));
                    if (min >= indexOf) {
                        break;
                    } else {
                        i = min;
                    }
                }
                i = min + 1;
            }
        }

        public void tagSocket(Socket socket) throws SocketException {
            Method method = this.trafficStatsTagSocket;
            if (method == null) {
                return;
            }
            try {
                method.invoke((Object) null, new Object[]{socket});
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }

        public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
            Object readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, this.sslParametersClass, "sslParameters");
            if (readFieldOrNull == null) {
                try {
                    readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
                } catch (ClassNotFoundException unused) {
                    return null;
                }
            }
            X509TrustManager x509TrustManager = (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "x509TrustManager");
            return x509TrustManager != null ? x509TrustManager : (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
        }

        public TrustRootIndex trustRootIndex(X509TrustManager x509TrustManager) {
            TrustRootIndex trustRootIndex = AndroidTrustRootIndex.get(x509TrustManager);
            return trustRootIndex != null ? trustRootIndex : super.trustRootIndex(x509TrustManager);
        }

        public void untagSocket(Socket socket) throws SocketException {
            Method method = this.trafficStatsUntagSocket;
            if (method == null) {
                return;
            }
            try {
                method.invoke((Object) null, new Object[]{socket});
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static class JdkPlatform extends Platform {
        private final Class sslContextClass;

        public JdkPlatform(Class cls) {
            this.sslContextClass = cls;
        }

        public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
            Object readFieldOrNull = Platform.readFieldOrNull(sSLSocketFactory, this.sslContextClass, "context");
            if (readFieldOrNull == null) {
                return null;
            }
            return (X509TrustManager) Platform.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
        }
    }

    public static class JdkWithJettyBootPlatform extends JdkPlatform {
        private final Class clientProviderClass;
        private final Method getMethod;
        private final Method putMethod;
        private final Method removeMethod;
        private final Class serverProviderClass;

        public JdkWithJettyBootPlatform(Class cls, Method method, Method method2, Method method3, Class cls2, Class cls3) {
            super(cls);
            this.putMethod = method;
            this.getMethod = method2;
            this.removeMethod = method3;
            this.clientProviderClass = cls2;
            this.serverProviderClass = cls3;
        }

        public void afterHandshake(SSLSocket sSLSocket) {
            try {
                this.removeMethod.invoke((Object) null, new Object[]{sSLSocket});
            } catch (IllegalAccessException | InvocationTargetException unused) {
                throw new AssertionError();
            }
        }

        public void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = (Protocol) list.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                this.putMethod.invoke((Object) null, new Object[]{sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new JettyNegoProvider(arrayList))});
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        public String getSelectedProtocol(SSLSocket sSLSocket) {
            try {
                JettyNegoProvider jettyNegoProvider = (JettyNegoProvider) Proxy.getInvocationHandler(this.getMethod.invoke((Object) null, new Object[]{sSLSocket}));
                if (!JettyNegoProvider.access$000(jettyNegoProvider) && JettyNegoProvider.access$100(jettyNegoProvider) == null) {
                    Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (JettyNegoProvider.access$000(jettyNegoProvider)) {
                    return null;
                }
                return JettyNegoProvider.access$100(jettyNegoProvider);
            } catch (InvocationTargetException | IllegalAccessException unused) {
                throw new AssertionError();
            }
        }
    }

    public static class JettyNegoProvider implements InvocationHandler {
        private final List protocols;
        private String selected;
        private boolean unsupported;

        public JettyNegoProvider(List list) {
            this.protocols = list;
        }

        public static /* synthetic */ boolean access$000(JettyNegoProvider jettyNegoProvider) {
            return jettyNegoProvider.unsupported;
        }

        public static /* synthetic */ String access$100(JettyNegoProvider jettyNegoProvider) {
            return jettyNegoProvider.selected;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object obj2;
            String name = method.getName();
            Class returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.unsupported = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj3 = objArr[0];
                if (obj3 instanceof List) {
                    List list = (List) obj3;
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            obj2 = this.protocols.get(0);
                            break;
                        }
                        if (this.protocols.contains(list.get(i))) {
                            obj2 = list.get(i);
                            break;
                        }
                        i++;
                    }
                    String str = (String) obj2;
                    this.selected = str;
                    return str;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.selected = (String) objArr[0];
            return null;
        }
    }

    public static byte[] concatLengthPrefixed(List list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    private static Platform findPlatform() {
        Class cls;
        Method method;
        OptionalMethod optionalMethod;
        Method method2;
        try {
            try {
                try {
                    cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
                }
                Class cls2 = cls;
                OptionalMethod optionalMethod2 = null;
                OptionalMethod optionalMethod3 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
                OptionalMethod optionalMethod4 = new OptionalMethod(null, "setHostname", String.class);
                try {
                    Class cls3 = Class.forName("android.net.TrafficStats");
                    method2 = cls3.getMethod("tagSocket", new Class[]{Socket.class});
                    try {
                        method = cls3.getMethod("untagSocket", new Class[]{Socket.class});
                        try {
                            Class.forName("android.net.Network");
                            optionalMethod = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                            try {
                                optionalMethod2 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                            }
                        } catch (ClassNotFoundException | NoSuchMethodException unused3) {
                            optionalMethod = null;
                        }
                    } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                        method = null;
                        optionalMethod = null;
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    method = null;
                    optionalMethod = null;
                    method2 = null;
                }
                return new Android(cls2, optionalMethod3, optionalMethod4, method2, method, optionalMethod, optionalMethod2);
            } catch (ClassNotFoundException unused6) {
                return new Platform();
            }
        } catch (ClassNotFoundException unused7) {
            Class cls4 = Class.forName("sun.security.ssl.SSLContextImpl");
            try {
                Class cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                Class cls6 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                return new JdkWithJettyBootPlatform(cls4, cls5.getMethod("put", new Class[]{SSLSocket.class, cls6}), cls5.getMethod("get", new Class[]{SSLSocket.class}), cls5.getMethod("remove", new Class[]{SSLSocket.class}), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
            } catch (ClassNotFoundException | NoSuchMethodException unused8) {
                return new JdkPlatform(cls4);
            }
        }
    }

    public static Platform get() {
        return PLATFORM;
    }

    public static Object readFieldOrNull(Object obj, Class cls, String str) {
        Object readFieldOrNull;
        for (Class cls2 = obj.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 != null && cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (NoSuchFieldException unused) {
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        if (str.equals("delegate") || (readFieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return readFieldOrNull(readFieldOrNull, cls, str);
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public void log(String str) {
        System.out.println(str);
    }

    public void logW(String str) {
        System.out.println(str);
    }

    public void tagSocket(Socket socket) throws SocketException {
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return null;
    }

    public TrustRootIndex trustRootIndex(X509TrustManager x509TrustManager) {
        return new RealTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void untagSocket(Socket socket) throws SocketException {
    }
}
