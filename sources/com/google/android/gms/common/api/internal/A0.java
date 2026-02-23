package com.google.android.gms.common.api.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a0 {
    public final Z a;

    public a0(Z z) {
        this.a = z;
    }

    public abstract void a();

    public final void b(c0 c0Var) {
        c0.h(c0Var).lock();
        try {
            if (c0.g(c0Var) == this.a) {
                a();
            }
        } finally {
            c0.h(c0Var).unlock();
        }
    }
}
