package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bee extends azu {
    private final beq a;

    public bee(beq beqVar) throws GeneralSecurityException {
        int i = bec.b[beqVar.b().ordinal()];
        this.a = beqVar;
    }

    public final azh a() {
        beq beqVar = this.a;
        return new bed(beqVar.g(), beqVar.c());
    }
}
