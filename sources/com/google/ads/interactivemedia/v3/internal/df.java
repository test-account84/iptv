package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class df implements cx {
    private final Context a;
    private final cx b;

    public df(Context context, cx cxVar) {
        this.a = context.getApplicationContext();
        this.b = cxVar;
    }

    public final de a() {
        return new de(this.a, ((dg) this.b).a());
    }
}
