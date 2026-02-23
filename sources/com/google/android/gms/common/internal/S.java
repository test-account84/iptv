package com.google.android.gms.common.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s {
    public static s b;
    public static final t c = new t(0, false, false, 0, 0);
    public t a;

    public static synchronized s b() {
        s sVar;
        synchronized (s.class) {
            try {
                if (b == null) {
                    b = new s();
                }
                sVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    public t a() {
        return this.a;
    }

    public final synchronized void c(t tVar) {
        if (tVar == null) {
            this.a = c;
            return;
        }
        t tVar2 = this.a;
        if (tVar2 == null || tVar2.L() < tVar.L()) {
            this.a = tVar;
        }
    }
}
