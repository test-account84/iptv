package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnd extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        String h = bohVar.h();
        try {
            return UUID.fromString(h);
        } catch (IllegalArgumentException e) {
            throw new bkf("Failed parsing '" + h + "' as UUID; at path " + bohVar.f(), e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        UUID uuid = (UUID) obj;
        bojVar.l(uuid == null ? null : uuid.toString());
    }
}
