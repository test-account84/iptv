package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class c extends ScheduledThreadPoolExecutor {

    public static final class b {
        public static final c a = new c(null);

        public static /* synthetic */ c a() {
            return a;
        }
    }

    public c() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }

    public static c a() {
        return b.a();
    }

    public /* synthetic */ c(a aVar) {
        this();
    }
}
