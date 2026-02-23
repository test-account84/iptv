package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class brl implements bsj {
    private static final brq a = new brj(0);
    private final brq b;

    public brl() {
        brq brqVar;
        brj c = brj.c();
        try {
            brqVar = (brq) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            brqVar = a;
        }
        brk brkVar = new brk(c, brqVar);
        bqu.j(brkVar, "messageInfoFactory");
        this.b = brkVar;
    }

    private static boolean b(brp brpVar) {
        return brpVar.c() == 1;
    }

    public final bsi a(Class cls) {
        bsr a2;
        brh e;
        bto U;
        bsr bsrVar;
        bsr a3;
        bto T;
        bsr a4;
        bsk.p(cls);
        brp a5 = this.b.a(cls);
        boolean b = a5.b();
        boolean isAssignableFrom = bqn.class.isAssignableFrom(cls);
        if (b) {
            if (isAssignableFrom) {
                T = bsk.V();
                a4 = bqc.b();
            } else {
                T = bsk.T();
                a4 = bqc.a();
            }
            return brw.c(T, a4, a5.a());
        }
        if (isAssignableFrom) {
            boolean b2 = b(a5);
            a2 = bry.b();
            e = brh.f();
            U = bsk.V();
            bsrVar = b2 ? bqc.b() : null;
            a3 = bro.b();
        } else {
            boolean b3 = b(a5);
            a2 = bry.a();
            e = brh.e();
            if (b3) {
                U = bsk.T();
                bsrVar = bqc.a();
            } else {
                U = bsk.U();
                bsrVar = null;
            }
            a3 = bro.a();
        }
        return brv.n(a5, a2, e, U, bsrVar, a3);
    }
}
