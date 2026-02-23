package okio;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Timeout$Companion$NONE$1 extends Timeout {
    @NotNull
    public Timeout deadlineNanoTime(long j) {
        return this;
    }

    public void throwIfReached() {
    }

    @NotNull
    public Timeout timeout(long j, @NotNull TimeUnit unit) {
        l.e(unit, "unit");
        return this;
    }
}
