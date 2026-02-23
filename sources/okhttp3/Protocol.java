package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final Companion Companion = new Companion(null);
    private final String protocol;

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Protocol get(@NotNull String protocol) throws IOException {
            l.e(protocol, "protocol");
            Protocol protocol2 = Protocol.HTTP_1_0;
            if (!l.a(protocol, Protocol.access$getProtocol$p(protocol2))) {
                protocol2 = Protocol.HTTP_1_1;
                if (!l.a(protocol, Protocol.access$getProtocol$p(protocol2))) {
                    protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!l.a(protocol, Protocol.access$getProtocol$p(protocol2))) {
                        protocol2 = Protocol.HTTP_2;
                        if (!l.a(protocol, Protocol.access$getProtocol$p(protocol2))) {
                            protocol2 = Protocol.SPDY_3;
                            if (!l.a(protocol, Protocol.access$getProtocol$p(protocol2))) {
                                protocol2 = Protocol.QUIC;
                                if (!l.a(protocol, Protocol.access$getProtocol$p(protocol2))) {
                                    throw new IOException("Unexpected protocol: " + protocol);
                                }
                            }
                        }
                    }
                }
            }
            return protocol2;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    public static final /* synthetic */ String access$getProtocol$p(Protocol protocol) {
        return protocol.protocol;
    }

    @NotNull
    public static final Protocol get(@NotNull String str) throws IOException {
        return Companion.get(str);
    }

    @NotNull
    public String toString() {
        return this.protocol;
    }
}
