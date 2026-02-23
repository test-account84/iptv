package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aux extends auk {
    final avf a;
    final Object b;
    int c;

    public aux(avf avfVar, int i) {
        this.a = avfVar;
        this.b = avfVar.b[i];
        this.c = i;
    }

    private final void a() {
        int i = this.c;
        if (i != -1) {
            avf avfVar = this.a;
            if (i <= avfVar.c && com.google.ads.interactivemedia.v3.impl.data.k.c(this.b, avfVar.b[i])) {
                return;
            }
        }
        this.c = this.a.e(this.b);
    }

    public final Object getKey() {
        return this.b;
    }

    public final Object getValue() {
        a();
        int i = this.c;
        if (i == -1) {
            return null;
        }
        return this.a.a[i];
    }

    public final Object setValue(Object obj) {
        a();
        int i = this.c;
        if (i == -1) {
            this.a.q(this.b, obj);
            return null;
        }
        Object obj2 = this.a.a[i];
        if (com.google.ads.interactivemedia.v3.impl.data.k.c(obj2, obj)) {
            return obj;
        }
        avf.o(this.a, this.c, obj);
        return obj2;
    }
}
