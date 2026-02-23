package okhttp3;

import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class OkHttpClient$Builder$addNetworkInterceptor$2 implements Interceptor {
    final /* synthetic */ l $block;

    public OkHttpClient$Builder$addNetworkInterceptor$2(l lVar) {
        this.$block = lVar;
    }

    @NotNull
    public final Response intercept(@NotNull Interceptor.Chain chain) {
        kotlin.jvm.internal.l.e(chain, "chain");
        return (Response) this.$block.invoke(chain);
    }
}
