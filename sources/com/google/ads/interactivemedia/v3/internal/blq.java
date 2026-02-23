package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class blq extends blt {
    final /* synthetic */ Method a;
    final /* synthetic */ int b;

    public blq(Method method, int i) {
        this.a = method;
        this.b = i;
    }

    public final Object a(Class cls) throws Exception {
        blt.b(cls);
        return this.a.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.b)});
    }
}
