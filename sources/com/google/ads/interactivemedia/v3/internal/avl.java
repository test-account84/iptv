package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class avl extends avo {
    private final transient avo a;

    public avl(avo avoVar) {
        this.a = avoVar;
    }

    private final int u(int i) {
        return (size() - 1) - i;
    }

    private final int v(int i) {
        return size() - i;
    }

    public final boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    public final boolean f() {
        return this.a.f();
    }

    public final Object get(int i) {
        atp.j(i, size());
        return this.a.get(u(i));
    }

    public final avo h() {
        return this.a;
    }

    public final avo i(int i, int i2) {
        atp.h(i, i2, size());
        return this.a.i(v(i2), v(i)).h();
    }

    public final int indexOf(Object obj) {
        int lastIndexOf = this.a.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return u(lastIndexOf);
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        int indexOf = this.a.indexOf(obj);
        if (indexOf >= 0) {
            return u(indexOf);
        }
        return -1;
    }

    public final int size() {
        return this.a.size();
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return i(i, i2);
    }
}
