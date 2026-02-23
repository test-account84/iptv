package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ka {
    private ui c;
    private iy b = iy.a;
    final jz a = jz.a;

    public static /* bridge */ /* synthetic */ iy a(ka kaVar) {
        return kaVar.b;
    }

    public static /* bridge */ /* synthetic */ ui d(ka kaVar) {
        return kaVar.c;
    }

    public final kh b() {
        if (this.c == null) {
            this.c = new ui(new jb[0]);
        }
        return new kh(this);
    }

    public final void c(iy iyVar) {
        af.s(iyVar);
        this.b = iyVar;
    }

    public final void e(ui uiVar) {
        this.c = uiVar;
    }
}
