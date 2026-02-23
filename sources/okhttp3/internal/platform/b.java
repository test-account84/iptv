package okhttp3.internal.platform;

import javax.net.ssl.SSLParameters;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class b {
    public static /* bridge */ /* synthetic */ void a(SSLParameters sSLParameters, String[] strArr) {
        sSLParameters.setApplicationProtocols(strArr);
    }
}
