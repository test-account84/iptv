package com.google.ads.interactivemedia.v3.internal;

import android.view.View;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class agq {
    public static agq f(ly lyVar, agr agrVar) {
        if (ago.c()) {
            return new agt(lyVar, agrVar, null, null);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }

    public abstract void a(View view, agv agvVar, String str);

    public abstract void b();

    public abstract void c(View view);

    public abstract void d();

    public abstract void e();
}
