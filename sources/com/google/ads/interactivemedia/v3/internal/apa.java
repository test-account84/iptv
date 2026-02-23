package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apa extends apj {
    private final boolean h;

    public apa(anw anwVar, agl aglVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "UdRLZDfL4bVVU0VX3qg8hi1McU3FMuLhNf0tRNLophcguwloVZffIAQP6VRf+/uk", "yXOhM6UEm+Qz/JUey2l1+qI404D+W2SeSSnUBSRl6qI=", aglVar, i, 61, null, null, null);
        this.h = anwVar.q();
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.d.invoke((Object) null, new Object[]{this.a.b(), Boolean.valueOf(this.h)})).longValue();
        synchronized (this.g) {
            this.g.ao(longValue);
        }
    }
}
