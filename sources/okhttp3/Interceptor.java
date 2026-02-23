package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Interceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    public interface Chain {
        @NotNull
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        @NotNull
        Response proceed(@NotNull Request request) throws IOException;

        int readTimeoutMillis();

        @NotNull
        Request request();

        @NotNull
        Chain withConnectTimeout(int i, @NotNull TimeUnit timeUnit);

        @NotNull
        Chain withReadTimeout(int i, @NotNull TimeUnit timeUnit);

        @NotNull
        Chain withWriteTimeout(int i, @NotNull TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final Interceptor invoke(@NotNull l block) {
            kotlin.jvm.internal.l.e(block, "block");
            return new Interceptor$Companion$invoke$1(block);
        }
    }

    @NotNull
    Response intercept(@NotNull Chain chain) throws IOException;
}
