package okio;

import java.util.zip.Inflater;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class -InflaterSourceExtensions {
    @NotNull
    public static final InflaterSource inflate(@NotNull Source inflate, @NotNull Inflater inflater) {
        l.e(inflate, "$this$inflate");
        l.e(inflater, "inflater");
        return new InflaterSource(inflate, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source inflate, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        l.e(inflate, "$this$inflate");
        l.e(inflater, "inflater");
        return new InflaterSource(inflate, inflater);
    }
}
