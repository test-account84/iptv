package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class axa extends avo {
    final /* synthetic */ axb a;

    public axa(axb axbVar) {
        this.a = axbVar;
    }

    public final boolean f() {
        return true;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        atp.j(i, axb.j(this.a));
        axb axbVar = this.a;
        int i2 = i + i;
        Object obj = axb.o(axbVar)[i2];
        obj.getClass();
        Object obj2 = axb.o(axbVar)[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return axb.j(this.a);
    }
}
