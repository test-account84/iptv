package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aou extends apj {
    private final anh h;
    private final long i;
    private final long j;

    public aou(anw anwVar, agl aglVar, int i, anh anhVar, long j, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "uXer3UA11jv0SZxM8rEYS7HzXCd8ucSITS/VghhemVPtPpwzWKxJYN2vUPP5dw9E", "hs3/rpu0ZtoaPE+A6aRGA1SNmSKC7zzkLMT9t285eJ8=", aglVar, i, 11, null, null, null);
        this.h = anhVar;
        this.i = j;
        this.j = j2;
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        anh anhVar = this.h;
        if (anhVar != null) {
            anf anfVar = new anf((String) this.d.invoke((Object) null, new Object[]{anhVar.b(), Long.valueOf(this.i), Long.valueOf(this.j)}));
            synchronized (this.g) {
                try {
                    this.g.ai(anfVar.a.longValue());
                    if (anfVar.b.longValue() >= 0) {
                        this.g.aA(anfVar.b.longValue());
                    }
                    if (anfVar.c.longValue() >= 0) {
                        this.g.O(anfVar.c.longValue());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
