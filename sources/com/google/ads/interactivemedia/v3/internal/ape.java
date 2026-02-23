package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ape extends apj {
    private static volatile Long h;
    private static final Object i = new Object();

    public ape(anw anwVar, agl aglVar, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "EggzVxU0lX/1UlHAeEGUyUm45SOmio09y9T4hm0PM9xyGW0Fa8XV6zB35QkAF1yq", "13swnHoz78V4UQSpBM2KHvpNNnXpuWx8GAjTYu5TVQw=", aglVar, i2, 33, null, null, null);
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
            this.g.aF(h.longValue());
        }
    }
}
