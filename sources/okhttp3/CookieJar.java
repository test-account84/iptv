package okhttp3;

import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import l8.k;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface CookieJar {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        public static final class NoCookies implements CookieJar {
            @NotNull
            public List loadForRequest(@NotNull HttpUrl url) {
                l.e(url, "url");
                return k.f();
            }

            public void saveFromResponse(@NotNull HttpUrl url, @NotNull List cookies) {
                l.e(url, "url");
                l.e(cookies, "cookies");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @NotNull
    List loadForRequest(@NotNull HttpUrl httpUrl);

    void saveFromResponse(@NotNull HttpUrl httpUrl, @NotNull List list);
}
