package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class apj implements Callable {
    protected final anw a;
    protected final String b;
    protected final String c;
    protected Method d;
    protected final int e;
    protected final int f;
    protected final agl g;

    public apj(anw anwVar, String str, String str2, agl aglVar, int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.a = anwVar;
        this.b = str;
        this.c = str2;
        this.g = aglVar;
        this.e = i;
        this.f = i2;
    }

    public abstract void a() throws IllegalAccessException, InvocationTargetException;

    public /* bridge */ /* synthetic */ Object call() throws Exception {
        f();
        return null;
    }

    public void f() throws Exception {
        int i;
        try {
            long nanoTime = System.nanoTime();
            Method i2 = this.a.i(this.b, this.c);
            this.d = i2;
            if (i2 == null) {
                return;
            }
            a();
            amu d = this.a.d();
            if (d == null || (i = this.e) == Integer.MIN_VALUE) {
                return;
            }
            d.c(this.f, i, (System.nanoTime() - nanoTime) / 1000, null, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
