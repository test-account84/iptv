package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class beb {
    private final Class a;
    private final Map b;
    private final Class c;

    @SafeVarargs
    public beb(Class cls, beo... beoVarArr) {
        this.a = cls;
        HashMap hashMap = new HashMap();
        for (int i = 0; i <= 0; i++) {
            beo beoVar = beoVarArr[i];
            if (hashMap.containsKey(beoVar.b())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(beoVar.b().getCanonicalName())));
            }
            hashMap.put(beoVar.b(), beoVar);
        }
        this.c = beoVarArr[0].b();
        this.b = Collections.unmodifiableMap(hashMap);
    }

    public bea a() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract bhq b();

    public abstract brs c(bpb bpbVar) throws bqw;

    public abstract String d();

    public abstract void e(brs brsVar) throws GeneralSecurityException;

    public int f() {
        return bch.a;
    }

    public final Class i() {
        return this.c;
    }

    public final Class j() {
        return this.a;
    }

    public final Object k(brs brsVar, Class cls) throws GeneralSecurityException {
        beo beoVar = (beo) this.b.get(cls);
        if (beoVar != null) {
            return beoVar.a(brsVar);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public final Set l() {
        return this.b.keySet();
    }
}
