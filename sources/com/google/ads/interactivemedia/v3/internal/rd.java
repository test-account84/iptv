package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class rd {
    public final rh a;
    public final MediaFormat b;
    public final s c;
    public final Surface d;
    public final MediaCrypto e;

    private rd(rh rhVar, MediaFormat mediaFormat, s sVar, Surface surface, MediaCrypto mediaCrypto) {
        this.a = rhVar;
        this.b = mediaFormat;
        this.c = sVar;
        this.d = surface;
        this.e = mediaCrypto;
    }

    public static rd a(rh rhVar, MediaFormat mediaFormat, s sVar, MediaCrypto mediaCrypto) {
        return new rd(rhVar, mediaFormat, sVar, null, mediaCrypto);
    }

    public static rd b(rh rhVar, MediaFormat mediaFormat, s sVar, Surface surface, MediaCrypto mediaCrypto) {
        return new rd(rhVar, mediaFormat, sVar, surface, mediaCrypto);
    }
}
