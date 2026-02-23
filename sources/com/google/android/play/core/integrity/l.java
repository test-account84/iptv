package com.google.android.play.core.integrity;

import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class l {
    private static j a;

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (l.class) {
            try {
                if (a == null) {
                    h hVar = new h(null);
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    hVar.a(context);
                    a = hVar.b();
                }
                jVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }
}
