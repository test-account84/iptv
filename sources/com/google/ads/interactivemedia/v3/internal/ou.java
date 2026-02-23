package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ou extends vm {
    private int d;

    public ou(bf bfVar, int[] iArr) {
        super(bfVar, iArr);
        this.d = m(bfVar.b(iArr[0]));
    }

    public final int a() {
        return this.d;
    }

    public final int b() {
        return 0;
    }

    public final void c() {
    }

    public final void d(long j, long j2, List list, vg[] vgVarArr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (s(this.d, elapsedRealtime)) {
            int i = this.b;
            do {
                i--;
                if (i < 0) {
                    throw new IllegalStateException();
                }
            } while (s(i, elapsedRealtime));
            this.d = i;
        }
    }
}
