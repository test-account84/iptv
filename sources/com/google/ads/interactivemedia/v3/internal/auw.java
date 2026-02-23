package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class auw extends auk {
    final Object a;
    int b;
    final /* synthetic */ avf c;

    public auw(avf avfVar, int i) {
        this.c = avfVar;
        this.a = avfVar.a[i];
        this.b = i;
    }

    public final void a() {
        int i = this.b;
        if (i != -1) {
            avf avfVar = this.c;
            if (i <= avfVar.c && com.google.ads.interactivemedia.v3.impl.data.k.c(avfVar.a[i], this.a)) {
                return;
            }
        }
        this.b = this.c.c(this.a);
    }

    public final Object getKey() {
        return this.a;
    }

    public final Object getValue() {
        a();
        int i = this.b;
        if (i == -1) {
            return null;
        }
        return this.c.b[i];
    }

    public final Object setValue(Object obj) {
        a();
        int i = this.b;
        if (i == -1) {
            this.c.put(this.a, obj);
            return null;
        }
        Object obj2 = this.c.b[i];
        if (com.google.ads.interactivemedia.v3.impl.data.k.c(obj2, obj)) {
            return obj;
        }
        avf.m(this.c, this.b, obj);
        return obj2;
    }
}
