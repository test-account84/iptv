package t6;

import F8.a;
import android.os.SystemClock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x implements y {
    public static final a a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public long a() {
        a.a aVar = F8.a.c;
        return F8.c.p(SystemClock.elapsedRealtime(), F8.d.MILLISECONDS);
    }

    public long b() {
        return System.currentTimeMillis() * 1000;
    }
}
