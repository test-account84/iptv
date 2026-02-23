package okhttp3;

import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Interceptor$Companion$invoke$1 implements Interceptor {
    final /* synthetic */ l $block;

    public Interceptor$Companion$invoke$1(l lVar) {
        this.$block = lVar;
    }

    @NotNull
    public final Response intercept(@NotNull Interceptor.Chain it) {
        kotlin.jvm.internal.l.e(it, "it");
        return (Response) this.$block.invoke(it);
    }
}
