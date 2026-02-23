package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bea {
    private final Class a;

    public bea(Class cls) {
        this.a = cls;
    }

    public abstract brs a(brs brsVar) throws GeneralSecurityException;

    public abstract brs b(bpb bpbVar) throws bqw;

    public Map c() throws GeneralSecurityException {
        return Collections.emptyMap();
    }

    public abstract void d(brs brsVar) throws GeneralSecurityException;

    public final Class e() {
        return this.a;
    }
}
