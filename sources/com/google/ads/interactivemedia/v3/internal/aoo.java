package com.google.ads.interactivemedia.v3.internal;

import h4.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aoo extends apj {
    public aoo(anw anwVar, agl aglVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "dJwO6Cl9MRqD0Gc5K3JTdZycyClQqkAPKU0XDLxQQPeGCWqiQha6f2rP1wtqtwx3", "rLNLoOjJQBnuvnCDgD+yaoADKoI2087E89SpHXw4yFg=", aglVar, i, 24, null, null, null);
    }

    private final void c() {
        h4.a g = this.a.g();
        if (g == null) {
            return;
        }
        try {
            a.a b = g.b();
            String d = aoa.d(b.a());
            if (d != null) {
                synchronized (this.g) {
                    this.g.ab(d);
                    this.g.aa(b.b());
                    this.g.aL(aft.f);
                }
            }
        } catch (IOException unused) {
        }
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.a.o()) {
            c();
            return;
        }
        synchronized (this.g) {
            this.g.ab((String) this.d.invoke((Object) null, new Object[]{this.a.b()}));
        }
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        f();
        return null;
    }

    public final void f() throws Exception {
        if (this.a.p()) {
            super.f();
        } else if (this.a.o()) {
            c();
        }
    }
}
