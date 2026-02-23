package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apf extends apj {
    public apf(anw anwVar, agl aglVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "n8eevinWOirOSPZe75LOlEw/rjd2yNw2EibrKlsvfLNOq/qV6IorYV+yJwJVSrU8", "z60w6+pWlGB4RCxkD/LDTBZ25WofjghjXXagNVA9cCM=", aglVar, i, 48, null, null, null);
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        agl aglVar;
        int i;
        this.g.aP(agh.c);
        boolean booleanValue = ((Boolean) this.d.invoke((Object) null, new Object[]{this.a.b()})).booleanValue();
        synchronized (this.g) {
            try {
                if (booleanValue) {
                    aglVar = this.g;
                    i = agh.b;
                } else {
                    aglVar = this.g;
                    i = agh.a;
                }
                aglVar.aP(i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
