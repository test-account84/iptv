package G8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class l0 {
    public static final kotlinx.coroutines.internal.y a = new kotlinx.coroutines.internal.y("REMOVED_TASK");
    public static final kotlinx.coroutines.internal.y b = new kotlinx.coroutines.internal.y("CLOSED_EMPTY");

    public static final /* synthetic */ kotlinx.coroutines.internal.y a() {
        return b;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.y b() {
        return a;
    }

    public static final long c(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}
