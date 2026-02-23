package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class azx implements azv {
    private final beb a;
    private final Class b;

    public azx(beb bebVar, Class cls) {
        if (!bebVar.l().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{bebVar.toString(), cls.getName()}));
        }
        this.a = bebVar;
        this.b = cls;
    }

    private final azw g() {
        return new azw(this.a.a());
    }

    private final Object h(brs brsVar) throws GeneralSecurityException {
        if (Void.class.equals(this.b)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.a.e(brsVar);
        return this.a.k(brsVar, this.b);
    }

    public final bhr a(bpb bpbVar) throws GeneralSecurityException {
        try {
            brs a = g().a(bpbVar);
            bif j = bhr.j();
            j.q(f());
            j.r(a.au());
            j.p(this.a.b());
            return (bhr) j.aY();
        } catch (bqw e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    public final brs b(bpb bpbVar) throws GeneralSecurityException {
        try {
            return g().a(bpbVar);
        } catch (bqw e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(this.a.a().e().getName()), e);
        }
    }

    public final Class c() {
        return this.b;
    }

    public final Object d(bpb bpbVar) throws GeneralSecurityException {
        try {
            return h(this.a.c(bpbVar));
        } catch (bqw e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(this.a.j().getName()), e);
        }
    }

    public final Object e(brs brsVar) throws GeneralSecurityException {
        String concat = "Expected proto of type ".concat(this.a.j().getName());
        if (this.a.j().isInstance(brsVar)) {
            return h(brsVar);
        }
        throw new GeneralSecurityException(concat);
    }

    public final String f() {
        return this.a.d();
    }

    public azx(bep bepVar, Class cls) {
        this((beb) bepVar, cls);
    }
}
