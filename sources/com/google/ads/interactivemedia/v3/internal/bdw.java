package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bdw {
    final /* synthetic */ bdv a;
    private final bjj b;
    private final Class c;

    public /* synthetic */ bdw(bjj bjjVar, Class cls) {
        this.b = bjjVar;
        this.c = cls;
    }

    public static bdw a(bdv bdvVar, bjj bjjVar, Class cls) {
        return new bdw(bjjVar, cls, bdvVar);
    }

    public final bjj b() {
        return this.b;
    }

    public final Class c() {
        return this.c;
    }

    public final azu d(bes besVar, bap bapVar) throws GeneralSecurityException {
        return this.a.a(besVar, bapVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bdw(bjj bjjVar, Class cls, bdv bdvVar) {
        this(bjjVar, cls);
        this.a = bdvVar;
    }
}
