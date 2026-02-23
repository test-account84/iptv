package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ahb {

    @SuppressLint({"StaticFieldLeak"})
    private static final ahb a = new ahb();
    private Context b;

    private ahb() {
    }

    public static ahb b() {
        return a;
    }

    public final Context a() {
        return this.b;
    }

    public final void c(Context context) {
        this.b = context != null ? context.getApplicationContext() : null;
    }
}
