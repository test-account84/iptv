package com.google.ads.interactivemedia.v3.internal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class api {
    private final anw a;
    private final String b;
    private final String c;
    private final Class[] e;
    private volatile Method d = null;
    private final CountDownLatch f = new CountDownLatch(1);

    public api(anw anwVar, String str, String str2, Class... clsArr) {
        this.a = anwVar;
        this.b = str;
        this.c = str2;
        this.e = clsArr;
        anwVar.j().submit(new aph(this));
    }

    public static /* bridge */ /* synthetic */ void b(api apiVar) {
        try {
            try {
                anw anwVar = apiVar.a;
                Class loadClass = anwVar.h().loadClass(apiVar.c(anwVar.r(), apiVar.b));
                if (loadClass != null) {
                    apiVar.d = loadClass.getMethod(apiVar.c(apiVar.a.r(), apiVar.c), apiVar.e);
                    Method method = apiVar.d;
                }
            } finally {
                apiVar.f.countDown();
            }
        } catch (ani | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        }
    }

    private final String c(byte[] bArr, String str) throws ani, UnsupportedEncodingException {
        return new String(this.a.e().b(bArr, str), "UTF-8");
    }

    public final Method a() {
        if (this.d != null) {
            return this.d;
        }
        try {
            if (this.f.await(2L, TimeUnit.SECONDS)) {
                return this.d;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
