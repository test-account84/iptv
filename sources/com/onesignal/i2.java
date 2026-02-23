package com.onesignal;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class i2 extends SSLSocketFactory {
    public SSLSocketFactory a;

    public i2(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    public final Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
        return socket;
    }

    public Socket createSocket() {
        return a(this.a.createSocket());
    }

    public String[] getDefaultCipherSuites() {
        return this.a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }

    public Socket createSocket(String str, int i) {
        return a(this.a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return a(this.a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return a(this.a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return a(this.a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return a(this.a.createSocket(socket, str, i, z));
    }
}
