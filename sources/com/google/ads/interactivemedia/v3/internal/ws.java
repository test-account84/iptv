package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.SystemClock;
import java.io.FileNotFoundException;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class ws {
    public static final wt a(Context context, Map map, int i, bn bnVar, boolean z) {
        return new wt(context, map, 2000, bnVar, true);
    }

    public static wu b(we weVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int n = weVar.n();
        int i = 0;
        for (int i2 = 0; i2 < n; i2++) {
            if (weVar.s(i2, elapsedRealtime)) {
                i++;
            }
        }
        return new wu(1, 0, n, i);
    }

    public static final int c(int i) {
        return i == 7 ? 6 : 3;
    }

    public static final wv d(wu wuVar, bdz bdzVar) {
        int i;
        Object obj = bdzVar.a;
        if (!(obj instanceof dq) || ((i = ((dq) obj).c) != 403 && i != 404 && i != 410 && i != 416 && i != 500 && i != 503)) {
            return null;
        }
        if (wuVar.a(1)) {
            return new wv(1, 300000L);
        }
        if (wuVar.a(2)) {
            return new wv(2, 60000L);
        }
        return null;
    }

    public static final long e(bdz bdzVar) {
        Object obj = bdzVar.a;
        if ((obj instanceof as) || (obj instanceof FileNotFoundException) || (obj instanceof dn)) {
            return -9223372036854775807L;
        }
        boolean z = obj instanceof xb;
        if (z) {
            return -9223372036854775807L;
        }
        for (Object obj2 = obj; obj2 != null; obj2 = ((Throwable) obj2).getCause()) {
            if ((obj2 instanceof cz) && ((cz) obj2).a == 2008) {
                return -9223372036854775807L;
            }
        }
        return Math.min((bdzVar.b - 1) * 1000, 5000);
    }

    public static final uh f(uh... uhVarArr) {
        return new sj(uhVarArr);
    }
}
