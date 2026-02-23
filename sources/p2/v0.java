package P2;

import android.media.metrics.LogSessionId;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v0 {
    public static final v0 b;
    public final a a;

    public static final class a {
        public static final a b = new a(com.google.ads.interactivemedia.v3.internal.X.a());
        public final LogSessionId a;

        public a(LogSessionId logSessionId) {
            this.a = logSessionId;
        }
    }

    static {
        b = d4.k0.a < 31 ? new v0() : new v0(a.b);
    }

    public v0() {
        this((a) null);
        d4.a.g(d4.k0.a < 31);
    }

    public LogSessionId a() {
        return ((a) d4.a.e(this.a)).a;
    }

    public v0(a aVar) {
        this.a = aVar;
    }

    public v0(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }
}
