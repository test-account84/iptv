package w1;

import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class b {
    public static final a a = new a(b.CACHE_ONLY);
    public static final c b = new c(b.NETWORK_ONLY, 0, null, false);
    public static final a c = new a(b.CACHE_FIRST);
    public static final a d = new a(b.NETWORK_FIRST);

    public static final class a extends c {
        public a(b bVar) {
            super(bVar, 0L, null, false);
        }
    }

    public enum b {
        CACHE_ONLY,
        NETWORK_ONLY,
        CACHE_FIRST,
        NETWORK_FIRST
    }

    public static class c {
        public final b a;
        public final long b;
        public final TimeUnit c;
        public final boolean d;

        public c(b bVar, long j, TimeUnit timeUnit, boolean z) {
            this.a = bVar;
            this.b = j;
            this.c = timeUnit;
            this.d = z;
        }

        public long a() {
            TimeUnit timeUnit = this.c;
            if (timeUnit == null) {
                return 0L;
            }
            return timeUnit.toMillis(this.b);
        }
    }
}
