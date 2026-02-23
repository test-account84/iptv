package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aow extends apj {
    private static volatile String h;
    private static final Object i = new Object();

    public aow(anw anwVar, agl aglVar, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "azGRTaieBebLUCBtXxWiGC8ntdSjezuXnKrD7NOMrfVnrrLI+ziOvss+bqlk4xLN", "0tQXY1xo2ukrM9W+s0u6j2Mh+vSCsclEF17Hl/ROszM=", aglVar, i2, 1, null, null, null);
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        this.g.ak("E");
        if (h == null) {
            synchronized (i) {
                try {
                    if (h == null) {
                        h = (String) this.d.invoke((Object) null, (Object[]) null);
                    }
                } finally {
                }
            }
        }
        synchronized (this.g) {
            this.g.ak(h);
        }
    }
}
