package com.onesignal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class C0 {
    public static final Object b = new Object();
    public B0 a;

    public B0 a(M1 m1, q1 q1Var, P0 p0, l1 l1Var, Q7.a aVar) {
        if (this.a == null) {
            synchronized (b) {
                try {
                    if (this.a == null) {
                        this.a = new B0(m1, q1Var, p0, l1Var, aVar);
                    }
                } finally {
                }
            }
        }
        return this.a;
    }
}
