package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class av {
    private final p a = new p();

    public final aw a() {
        return new aw(this.a.a());
    }

    public final void b(int i) {
        this.a.b(i);
    }

    public final void c(aw awVar) {
        p pVar = this.a;
        q a = aw.a(awVar);
        for (int i = 0; i < a.b(); i++) {
            pVar.b(a.a(i));
        }
    }

    public final void d(int... iArr) {
        p pVar = this.a;
        for (int i = 0; i < 21; i++) {
            pVar.b(iArr[i]);
        }
    }

    public final void e(int i, boolean z) {
        p pVar = this.a;
        if (z) {
            pVar.b(i);
        }
    }
}
