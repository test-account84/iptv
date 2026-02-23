package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class axm extends avx {
    final transient Object a;

    public axm(Object obj) {
        atp.k(obj);
        this.a = obj;
    }

    public final int a(Object[] objArr, int i) {
        objArr[i] = this.a;
        return i + 1;
    }

    public final boolean contains(Object obj) {
        return this.a.equals(obj);
    }

    public final avo d() {
        return avo.p(this.a);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final axq iterator() {
        return new awh(this.a);
    }

    public final boolean f() {
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        return '[' + this.a.toString() + ']';
    }
}
