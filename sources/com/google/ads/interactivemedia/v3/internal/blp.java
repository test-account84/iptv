package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class blp extends blt {
    final /* synthetic */ Method a;
    final /* synthetic */ Object b;

    public blp(Method method, Object obj) {
        this.a = method;
        this.b = obj;
    }

    public final Object a(Class cls) throws Exception {
        blt.b(cls);
        return this.a.invoke(this.b, new Object[]{cls});
    }
}
