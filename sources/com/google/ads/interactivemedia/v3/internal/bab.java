package com.google.ads.interactivemedia.v3.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bab {
    private static final Logger a = Logger.getLogger(bab.class.getName());
    private final ConcurrentMap b;

    public bab() {
        this.b = new ConcurrentHashMap();
    }

    private static baa g(beb bebVar) {
        return new azy(bebVar, 0);
    }

    private final synchronized baa h(String str) throws GeneralSecurityException {
        if (!this.b.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (baa) this.b.get(str);
    }

    private final synchronized void i(baa baaVar, boolean z) throws GeneralSecurityException {
        try {
            String f = baaVar.b().f();
            baa baaVar2 = (baa) this.b.get(f);
            if (baaVar2 != null && !baaVar2.c().equals(baaVar.c())) {
                a.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(f));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{f, baaVar2.c().getName(), baaVar.c().getName()}));
            }
            if (z) {
                this.b.put(f, baaVar);
            } else {
                this.b.putIfAbsent(f, baaVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final azv a(String str, Class cls) throws GeneralSecurityException {
        baa h = h(str);
        if (h.e().contains(cls)) {
            return h.a(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(h.c());
        Set<Class> e = h.e();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : e) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", supported primitives: " + sb.toString());
    }

    public final azv b(String str) throws GeneralSecurityException {
        return h(str).b();
    }

    public final synchronized void c(bep bepVar, beb bebVar) throws GeneralSecurityException {
        Class d;
        try {
            int f = bepVar.f();
            int f2 = bebVar.f();
            if (!bch.a(f)) {
                throw new GeneralSecurityException("failed to register key manager " + String.valueOf(bepVar.getClass()) + " as it is not FIPS compatible.");
            }
            if (!bch.a(f2)) {
                throw new GeneralSecurityException("failed to register key manager " + String.valueOf(bebVar.getClass()) + " as it is not FIPS compatible.");
            }
            String d2 = bepVar.d();
            String d3 = bebVar.d();
            if (this.b.containsKey(d2) && ((baa) this.b.get(d2)).d() != null && (d = ((baa) this.b.get(d2)).d()) != null && !d.getName().equals(bebVar.getClass().getName())) {
                a.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type " + d2 + " with inconsistent public key type " + d3);
                throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{bepVar.getClass().getName(), d.getName(), bebVar.getClass().getName()}));
            }
            i(new azz(bepVar, bebVar), true);
            i(g(bebVar), false);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void d(azv azvVar) throws GeneralSecurityException {
        if (!bch.a(bch.a)) {
            throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
        }
        i(new azy(azvVar, 1), false);
    }

    public final synchronized void e(beb bebVar) throws GeneralSecurityException {
        if (!bch.a(bebVar.f())) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(bebVar.getClass()) + " as it is not FIPS compatible.");
        }
        i(g(bebVar), false);
    }

    public final boolean f(String str) {
        return this.b.containsKey(str);
    }

    public bab(bab babVar) {
        this.b = new ConcurrentHashMap(babVar.b);
    }
}
