package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.IBinder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class arr {
    private final String a = "com.google.android.gms.ads.adshield.AdShieldCreatorImpl";
    private Object b;

    public abstract Object b(IBinder iBinder);

    public final Object c(Context context) throws arq {
        if (this.b == null) {
            com.google.android.gms.common.internal.r.m(context);
            Context e = w4.m.e(context);
            if (e == null) {
                throw new arq();
            }
            try {
                this.b = b((IBinder) e.getClassLoader().loadClass(this.a).newInstance());
            } catch (InstantiationException e2) {
                throw new arq("Could not instantiate creator.", e2);
            } catch (IllegalAccessException e3) {
                throw new arq("Could not access creator.", e3);
            } catch (ClassNotFoundException e4) {
                throw new arq("Could not load creator class.", e4);
            }
        }
        return this.b;
    }
}
