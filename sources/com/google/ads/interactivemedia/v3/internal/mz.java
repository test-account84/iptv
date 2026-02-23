package com.google.ads.interactivemedia.v3.internal;

import java.util.HashMap;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class mz {
    private final HashMap a = new HashMap();
    private UUID b = i.d;
    private od e = og.a;
    private final ws f = new ws();
    private int[] c = new int[0];
    private final long d = 300000;

    public final nj a(oj ojVar) {
        return new nj(this.b, this.e, ojVar, this.a, this.c, this.f, 300000L, null, null, null);
    }

    public final void b(int... iArr) {
        for (int i : iArr) {
            boolean z = true;
            if (i != 2 && i != 1) {
                z = false;
            }
            af.u(z);
        }
        this.c = (int[]) iArr.clone();
    }

    public final void c(UUID uuid, od odVar) {
        af.s(uuid);
        this.b = uuid;
        this.e = odVar;
    }
}
