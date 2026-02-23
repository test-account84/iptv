package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Bundle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class asx {
    private static final HashMap a = new HashMap();
    private final Context b;
    private final asy c;
    private final aru d;
    private final arl e;
    private asp f;
    private final Object g = new Object();

    public asx(Context context, asy asyVar, aru aruVar, arl arlVar) {
        this.b = context;
        this.c = asyVar;
        this.d = aruVar;
        this.e = arlVar;
    }

    private static long d(long j) {
        return System.currentTimeMillis() - j;
    }

    private final synchronized Class e(asq asqVar) throws asw {
        try {
            String k = asqVar.a().k();
            HashMap hashMap = a;
            Class cls = (Class) hashMap.get(k);
            if (cls != null) {
                return cls;
            }
            try {
                if (!this.e.a(asqVar.c())) {
                    throw new asw(2026, "VM did not pass signature verification");
                }
                try {
                    File b = asqVar.b();
                    if (!b.exists()) {
                        b.mkdirs();
                    }
                    Class loadClass = new DexClassLoader(asqVar.c().getAbsolutePath(), b.getAbsolutePath(), (String) null, this.b.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    hashMap.put(k, loadClass);
                    return loadClass;
                } catch (SecurityException e) {
                    e = e;
                    throw new asw(2008, (Throwable) e);
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    throw new asw(2008, (Throwable) e);
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    throw new asw(2008, (Throwable) e);
                }
            } catch (GeneralSecurityException e4) {
                throw new asw(2026, (Throwable) e4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final arx a() {
        asp aspVar;
        synchronized (this.g) {
            aspVar = this.f;
        }
        return aspVar;
    }

    public final asq b() {
        synchronized (this.g) {
            try {
                asp aspVar = this.f;
                if (aspVar == null) {
                    return null;
                }
                return aspVar.f();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(asq asqVar) {
        int i;
        Exception exc;
        aru aruVar;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                asp aspVar = new asp(e(asqVar).getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.b, "msa-r", asqVar.e(), null, new Bundle(), 2}), asqVar, this.c, this.d);
                if (!aspVar.h()) {
                    throw new asw(4000, "init failed");
                }
                int e = aspVar.e();
                if (e != 0) {
                    throw new asw(4001, "ci: " + e);
                }
                synchronized (this.g) {
                    asp aspVar2 = this.f;
                    if (aspVar2 != null) {
                        try {
                            aspVar2.g();
                        } catch (asw e2) {
                            this.d.c(e2.a(), -1L, e2);
                        }
                        this.f = aspVar;
                    } else {
                        this.f = aspVar;
                    }
                }
                this.d.d(3000, d(currentTimeMillis));
                return true;
            } catch (Exception e3) {
                throw new asw(2004, (Throwable) e3);
            }
        } catch (asw e4) {
            aru aruVar2 = this.d;
            i = e4.a();
            aruVar = aruVar2;
            exc = e4;
            aruVar.c(i, d(currentTimeMillis), exc);
            return false;
        } catch (Exception e5) {
            i = 4010;
            aruVar = this.d;
            exc = e5;
            aruVar.c(i, d(currentTimeMillis), exc);
            return false;
        }
    }
}
