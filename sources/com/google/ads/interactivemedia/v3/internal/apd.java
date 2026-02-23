package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apd extends apj {
    private final aod h;
    private long i;

    public apd(anw anwVar, agl aglVar, int i, aod aodVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "yXY8/mGMSUXAD/doic4NhOcSiaIXIqWtQGozx2RibPkZkGDEn3zdgJKu8ncuIp2B", "lomf+VO0Ecj7WivSbw6aVWdgbo/lmDysFNgyXwY+gTY=", aglVar, i, 53, null, null, null);
        this.h = aodVar;
        if (aodVar != null) {
            this.i = aodVar.a();
        }
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.h != null) {
            this.g.az(((Long) this.d.invoke((Object) null, new Object[]{Long.valueOf(this.i)})).longValue());
        }
    }
}
