package okhttp3.internal.platform.android;

import E8.n;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.l;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class AndroidSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    final /* synthetic */ String $packageName;

    public AndroidSocketAdapter$Companion$factory$1(String str) {
        this.$packageName = str;
    }

    @NotNull
    public SocketAdapter create(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        return AndroidSocketAdapter.Companion.access$build(AndroidSocketAdapter.Companion, sslSocket.getClass());
    }

    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        l.e(sslSocket, "sslSocket");
        String name = sslSocket.getClass().getName();
        l.d(name, "sslSocket.javaClass.name");
        return n.B(name, this.$packageName + '.', false, 2, null);
    }
}
