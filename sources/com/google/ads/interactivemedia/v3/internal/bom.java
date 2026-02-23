package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bom implements brr {
    /* renamed from: aQ, reason: merged with bridge method [inline-methods] */
    public abstract bom clone();

    public abstract bom aR(bon bonVar);

    public final /* bridge */ /* synthetic */ brr aS(brs brsVar) {
        if (ba().getClass().isInstance(brsVar)) {
            return aR((bon) brsVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public /* bridge */ /* synthetic */ void aT(bpg bpgVar, bqb bqbVar) throws IOException {
        throw null;
    }

    public void aU(byte[] bArr, int i, bqb bqbVar) throws bqw {
        throw null;
    }
}
