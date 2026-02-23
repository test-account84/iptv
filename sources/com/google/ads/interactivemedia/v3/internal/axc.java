package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class axc extends avx {
    private final transient avs a;
    private final transient avo b;

    public axc(avs avsVar, avo avoVar) {
        this.a = avsVar;
        this.b = avoVar;
    }

    public final int a(Object[] objArr, int i) {
        return this.b.a(objArr, i);
    }

    public final boolean contains(Object obj) {
        return this.a.get(obj) != null;
    }

    public final avo d() {
        return this.b;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final axq iterator() {
        return this.b.listIterator();
    }

    public final boolean f() {
        return true;
    }

    public final int size() {
        return this.a.size();
    }
}
