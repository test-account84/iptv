package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okhttp3.internal.authenticator.JavaNetAuthenticator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Authenticator {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final Authenticator NONE = new Companion.AuthenticatorNone();

    @NotNull
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator(null, 1, null);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        public static final class AuthenticatorNone implements Authenticator {
            @Nullable
            public Request authenticate(@Nullable Route route, @NotNull Response response) {
                l.e(response, "response");
                return null;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Nullable
    Request authenticate(@Nullable Route route, @NotNull Response response) throws IOException;
}
