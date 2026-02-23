package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class biv {
    public static final biv a;
    public static final biv b;
    public static final biv c;
    public static final biv d;
    public static final biv e;
    private static final Logger f = Logger.getLogger(biv.class.getName());
    private static final List g;
    private static final boolean h;
    private final bix i;

    static {
        if (bci.b()) {
            g = b("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt");
            h = false;
        } else {
            g = bjh.f() ? b("GmsCore_OpenSSL", "AndroidOpenSSL") : new ArrayList();
            h = true;
        }
        a = new biv(new biw(1));
        b = new biv(new biw(4));
        c = new biv(new biw(0));
        d = new biv(new biw(3));
        e = new biv(new biw(2));
    }

    public biv(bix bixVar) {
        this.i = bixVar;
    }

    public static List b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                f.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
            }
        }
        return arrayList;
    }

    public final Object a(String str) throws GeneralSecurityException {
        Iterator it = g.iterator();
        Throwable th = null;
        while (it.hasNext()) {
            try {
                return this.i.a(str, (Provider) it.next());
            } catch (Exception e2) {
                if (th == null) {
                    th = e2;
                }
            }
        }
        if (h) {
            return this.i.a(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", th);
    }
}
