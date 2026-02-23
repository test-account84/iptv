package com.google.ads.interactivemedia.v3.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bao {
    private static final Logger a = Logger.getLogger(bao.class.getName());
    private static final AtomicReference b = new AtomicReference(new bab());
    private static final ConcurrentMap c = new ConcurrentHashMap();
    private static final ConcurrentMap d = new ConcurrentHashMap();
    private static final ConcurrentMap e = new ConcurrentHashMap();
    private static final ConcurrentMap f = new ConcurrentHashMap();
    private static final ConcurrentMap g = new ConcurrentHashMap();

    private bao() {
    }

    @Deprecated
    public static azp a(String str) throws GeneralSecurityException {
        String valueOf;
        String str2;
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        ConcurrentMap concurrentMap = e;
        Locale locale = Locale.US;
        azp azpVar = (azp) concurrentMap.get(str.toLowerCase(locale));
        if (azpVar != null) {
            return azpVar;
        }
        String format = String.format("no catalogue found for %s. ", new Object[]{str});
        if (str.toLowerCase(locale).startsWith("tinkaead")) {
            format = format.concat("Maybe call AeadConfig.register().");
        }
        if (str.toLowerCase(locale).startsWith("tinkdeterministicaead")) {
            valueOf = String.valueOf(format);
            str2 = "Maybe call DeterministicAeadConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tinkstreamingaead")) {
            valueOf = String.valueOf(format);
            str2 = "Maybe call StreamingAeadConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tinkhybriddecrypt") || str.toLowerCase(locale).startsWith("tinkhybridencrypt")) {
            valueOf = String.valueOf(format);
            str2 = "Maybe call HybridConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tinkmac")) {
            valueOf = String.valueOf(format);
            str2 = "Maybe call MacConfig.register().";
        } else {
            if (!str.toLowerCase(locale).startsWith("tinkpublickeysign") && !str.toLowerCase(locale).startsWith("tinkpublickeyverify")) {
                if (str.toLowerCase(locale).startsWith("tink")) {
                    valueOf = String.valueOf(format);
                    str2 = "Maybe call TinkConfig.register().";
                }
                throw new GeneralSecurityException(format);
            }
            valueOf = String.valueOf(format);
            str2 = "Maybe call SignatureConfig.register().";
        }
        format = valueOf.concat(str2);
        throw new GeneralSecurityException(format);
    }

    public static azv b(String str) throws GeneralSecurityException {
        return ((bab) b.get()).b(str);
    }

    public static synchronized brs c(bht bhtVar) throws GeneralSecurityException {
        brs b2;
        synchronized (bao.class) {
            azv b3 = b(bhtVar.e());
            if (!((Boolean) d.get(bhtVar.e())).booleanValue()) {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(bhtVar.e())));
            }
            b2 = b3.b(bhtVar.d());
        }
        return b2;
    }

    public static Class d(Class cls) {
        bam bamVar = (bam) f.get(cls);
        if (bamVar == null) {
            return null;
        }
        return bamVar.a();
    }

    public static Object e(bhr bhrVar, Class cls) throws GeneralSecurityException {
        return f(bhrVar.e(), bhrVar.d(), cls);
    }

    public static Object f(String str, bpb bpbVar, Class cls) throws GeneralSecurityException {
        return ((bab) b.get()).a(str, cls).d(bpbVar);
    }

    public static Object g(String str, brs brsVar, Class cls) throws GeneralSecurityException {
        return ((bab) b.get()).a(str, cls).e(brsVar);
    }

    public static Object h(String str, byte[] bArr, Class cls) throws GeneralSecurityException {
        return f(str, bpb.t(bArr), cls);
    }

    public static Object i(bal balVar, Class cls) throws GeneralSecurityException {
        bam bamVar = (bam) f.get(cls);
        if (bamVar == null) {
            throw new GeneralSecurityException("No wrapper found for ".concat(balVar.c().getName()));
        }
        if (bamVar.a().equals(balVar.c())) {
            return bamVar.c(balVar);
        }
        throw new GeneralSecurityException("Wrong input primitive class, expected " + bamVar.a().toString() + ", got " + balVar.c().toString());
    }

    public static synchronized Map j() {
        Map unmodifiableMap;
        synchronized (bao.class) {
            unmodifiableMap = Collections.unmodifiableMap(g);
        }
        return unmodifiableMap;
    }

    public static synchronized void k(azv azvVar, boolean z) throws GeneralSecurityException {
        synchronized (bao.class) {
            if (azvVar == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            AtomicReference atomicReference = b;
            bab babVar = new bab((bab) atomicReference.get());
            babVar.d(azvVar);
            if (!bch.a(bch.a)) {
                throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
            }
            String f2 = azvVar.f();
            p(f2, Collections.emptyMap(), z);
            d.put(f2, Boolean.valueOf(z));
            atomicReference.set(babVar);
        }
    }

    public static synchronized void l(bam bamVar) throws GeneralSecurityException {
        synchronized (bao.class) {
            try {
                if (bamVar == null) {
                    throw new IllegalArgumentException("wrapper must be non-null");
                }
                Class b2 = bamVar.b();
                ConcurrentMap concurrentMap = f;
                if (concurrentMap.containsKey(b2)) {
                    bam bamVar2 = (bam) concurrentMap.get(b2);
                    if (!bamVar.getClass().getName().equals(bamVar2.getClass().getName())) {
                        a.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", "Attempted overwrite of a registered PrimitiveWrapper for type ".concat(b2.toString()));
                        throw new GeneralSecurityException(String.format("PrimitiveWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{b2.getName(), bamVar2.getClass().getName(), bamVar.getClass().getName()}));
                    }
                }
                concurrentMap.put(b2, bamVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void m(bht bhtVar) throws GeneralSecurityException {
        synchronized (bao.class) {
            azv b2 = b(bhtVar.e());
            if (!((Boolean) d.get(bhtVar.e())).booleanValue()) {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(bhtVar.e())));
            }
            b2.a(bhtVar.d());
        }
    }

    public static synchronized void n(bep bepVar, beb bebVar) throws GeneralSecurityException {
        synchronized (bao.class) {
            try {
                AtomicReference atomicReference = b;
                bab babVar = new bab((bab) atomicReference.get());
                babVar.c(bepVar, bebVar);
                String d2 = bepVar.d();
                String d3 = bebVar.d();
                p(d2, bepVar.a().c(), true);
                p(d3, Collections.emptyMap(), false);
                if (!((bab) atomicReference.get()).f(d2)) {
                    c.put(d2, r(bepVar));
                    q(bepVar.d(), bepVar.a().c());
                }
                ConcurrentMap concurrentMap = d;
                concurrentMap.put(d2, Boolean.TRUE);
                concurrentMap.put(d3, Boolean.FALSE);
                atomicReference.set(babVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void o(beb bebVar) throws GeneralSecurityException {
        synchronized (bao.class) {
            try {
                AtomicReference atomicReference = b;
                bab babVar = new bab((bab) atomicReference.get());
                babVar.e(bebVar);
                String d2 = bebVar.d();
                p(d2, bebVar.a().c(), true);
                if (!((bab) atomicReference.get()).f(d2)) {
                    c.put(d2, r(bebVar));
                    q(d2, bebVar.a().c());
                }
                d.put(d2, Boolean.TRUE);
                atomicReference.set(babVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static synchronized void p(String str, Map map, boolean z) throws GeneralSecurityException {
        synchronized (bao.class) {
            if (z) {
                try {
                    ConcurrentMap concurrentMap = d;
                    if (concurrentMap.containsKey(str) && !((Boolean) concurrentMap.get(str)).booleanValue()) {
                        throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
                    }
                    if (((bab) b.get()).f(str)) {
                        for (Map.Entry entry : map.entrySet()) {
                            if (!g.containsKey(entry.getKey())) {
                                throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                            }
                        }
                    } else {
                        for (Map.Entry entry2 : map.entrySet()) {
                            if (g.containsKey(entry2.getKey())) {
                                throw new GeneralSecurityException("Attempted overwrite of a registered key template ".concat(String.valueOf((String) entry2.getKey())));
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.ads.interactivemedia.v3.internal.brs, java.lang.Object] */
    private static void q(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            g.put((String) entry.getKey(), oq.i(str, ((bdz) entry.getValue()).a.av(), ((bdz) entry.getValue()).b));
        }
    }

    private static ban r(beb bebVar) {
        return new ban();
    }
}
