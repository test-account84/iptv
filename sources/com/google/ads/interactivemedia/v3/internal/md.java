package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class md extends me {
    private final mb a;
    private final mm f;

    public md(s sVar, List list, mj mjVar, List list2, List list3, List list4) {
        super(sVar, list, mjVar, list2);
        Uri.parse(((lt) list.get(0)).a);
        long j = mjVar.b;
        mb mbVar = j <= 0 ? null : new mb(null, mjVar.a, j);
        this.a = mbVar;
        this.f = mbVar == null ? new mm(new mb(null, 0L, -1L)) : null;
    }

    public final li k() {
        return this.f;
    }

    public final mb l() {
        return this.a;
    }

    public final void m() {
    }
}
