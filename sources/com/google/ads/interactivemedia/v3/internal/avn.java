package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class avn extends avo {
    final transient int a;
    final transient int b;
    final /* synthetic */ avo c;

    public avn(avo avoVar, int i, int i2) {
        this.c = avoVar;
        this.a = i;
        this.b = i2;
    }

    public final int b() {
        return this.c.c() + this.a + this.b;
    }

    public final int c() {
        return this.c.c() + this.a;
    }

    public final boolean f() {
        return true;
    }

    public final Object[] g() {
        return this.c.g();
    }

    public final Object get(int i) {
        atp.j(i, this.b);
        return this.c.get(i + this.a);
    }

    public final avo i(int i, int i2) {
        atp.h(i, i2, this.b);
        avo avoVar = this.c;
        int i3 = this.a;
        return avoVar.i(i + i3, i2 + i3);
    }

    public final int size() {
        return this.b;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return i(i, i2);
    }
}
