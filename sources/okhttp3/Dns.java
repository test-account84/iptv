package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import l8.h;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Dns {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final Dns SYSTEM = new Companion.DnsSystem();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        public static final class DnsSystem implements Dns {
            @NotNull
            public List lookup(@NotNull String hostname) {
                l.e(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    l.d(allByName, "InetAddress.getAllByName(hostname)");
                    return h.T(allByName);
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + hostname);
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @NotNull
    List lookup(@NotNull String str) throws UnknownHostException;
}
