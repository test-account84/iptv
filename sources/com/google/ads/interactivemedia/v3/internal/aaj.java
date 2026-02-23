package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class aaj {
    public final ao a(ef efVar) {
        ByteBuffer byteBuffer = efVar.b;
        af.s(byteBuffer);
        boolean z = false;
        if (byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            z = true;
        }
        af.u(z);
        if (efVar.f()) {
            return null;
        }
        return b(byteBuffer);
    }

    public abstract ao b(ByteBuffer byteBuffer);
}
