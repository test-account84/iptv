package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class avb extends ave {
    final /* synthetic */ avf a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public avb(avf avfVar) {
        super(avfVar);
        this.a = avfVar;
    }

    public final Object a(int i) {
        return this.a.a[i];
    }

    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    public final boolean remove(Object obj) {
        int F = axo.F(obj);
        int d = this.a.d(obj, F);
        if (d == -1) {
            return false;
        }
        this.a.j(d, F);
        return true;
    }
}
