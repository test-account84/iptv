package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aon extends apj {
    private final long h;

    public aon(anw anwVar, agl aglVar, long j, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "THnQW94FsCDUSM+XeJNpgUTCgMolxy7rl1LeD10r6fuFhGDZDxfkCa3f3R02TTfn", "RukHQ2QyoItYcCVOmbl/vMdZ4cajSx2BB5kPudfplwo=", aglVar, i, 25, null, null, null);
        this.h = j;
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.d.invoke((Object) null, (Object[]) null)).longValue();
        synchronized (this.g) {
            try {
                this.g.ac(longValue);
                long j = this.h;
                if (j != 0) {
                    this.g.aD(longValue - j);
                    this.g.aE(this.h);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
