package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aos extends apj {
    private static volatile Long h;
    private static final Object i = new Object();

    public aos(anw anwVar, agl aglVar, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "BL1uRQDu2iGGdqxtPT0UZ/lh1a1ebdj6ce5dHzXL9Xdh/V7EjoG/mOlN+ePhmCVj", "VbWvt5u3iV1e6mTKIEv50y8+Z2ekDgVJovyXyxeSHYc=", aglVar, i2, 22, null, null, null);
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
            this.g.ah(h.longValue());
        }
    }
}
