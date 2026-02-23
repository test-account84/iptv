package okhttp3.internal.platform.android;

import android.net.ssl.SSLSockets;
import javax.net.ssl.SSLSocket;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class b {
    public static /* bridge */ /* synthetic */ boolean a(SSLSocket sSLSocket) {
        return SSLSockets.isSupportedSocket(sSLSocket);
    }
}
