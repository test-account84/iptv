package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class avc extends ave {
    final /* synthetic */ avf a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public avc(avf avfVar) {
        super(avfVar);
        this.a = avfVar;
    }

    public final Object a(int i) {
        return this.a.b[i];
    }

    public final boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    public final boolean remove(Object obj) {
        int F = axo.F(obj);
        int f = this.a.f(obj, F);
        if (f == -1) {
            return false;
        }
        this.a.k(f, F);
        return true;
    }
}
