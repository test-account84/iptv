package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aom extends apj {
    private static volatile Long h;
    private static final Object i = new Object();

    public aom(anw anwVar, agl aglVar, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "9MUQl4bkTrG/hbkOaiPEQeZR+Q1g5nerIUIYlLLAX+szyWBOaKlwxYudXHeApTjq", "w0yuMX287JAuExKzMpRTJqrOhPVTMBo6RInylnboEYs=", aglVar, i2, 44, null, null, null);
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        if (h == null) {
            synchronized (i) {
                try {
                    if (h == null) {
                        h = (Long) this.d.invoke((Object) null, (Object[]) null);
                    }
                } finally {
                }
            }
        }
        synchronized (this.g) {
            this.g.X(h.longValue());
        }
    }
}
