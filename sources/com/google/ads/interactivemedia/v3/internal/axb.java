package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class axb extends avx {
    private final transient avs a;
    private final transient Object[] b;
    private final transient int c;

    public axb(avs avsVar, Object[] objArr, int i) {
        this.a = avsVar;
        this.b = objArr;
        this.c = i;
    }

    public static /* synthetic */ int j(axb axbVar) {
        return axbVar.c;
    }

    public static /* synthetic */ Object[] o(axb axbVar) {
        return axbVar.b;
    }

    public final int a(Object[] objArr, int i) {
        return d().a(objArr, i);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.a.get(key))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final axq iterator() {
        return d().listIterator();
    }

    public final boolean f() {
        return true;
    }

    public final avo i() {
        return new axa(this);
    }

    public final int size() {
        return this.c;
    }
}
