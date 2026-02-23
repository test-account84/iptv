package com.google.ads.interactivemedia.v3.internal;

import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class oc implements ea {
    public static final boolean a;
    public final UUID b;
    public final byte[] c;
    public final boolean d;

    static {
        boolean z = false;
        if ("Amazon".equals(cq.c)) {
            String str = cq.d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z = true;
            }
        }
        a = z;
    }

    public oc(UUID uuid, byte[] bArr, boolean z) {
        this.b = uuid;
        this.c = bArr;
        this.d = z;
    }
}
