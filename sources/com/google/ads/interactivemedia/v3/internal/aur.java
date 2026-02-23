package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aur extends aut {
    public static final aut f(int i) {
        return i < 0 ? aut.g() : i > 0 ? aut.h() : aut.i();
    }

    public final int a() {
        return 0;
    }

    public final aut b(int i, int i2) {
        return f(i < i2 ? -1 : i > i2 ? 1 : 0);
    }

    public final aut c(Object obj, Object obj2, Comparator comparator) {
        return f(comparator.compare(obj, obj2));
    }

    public final aut d(boolean z, boolean z2) {
        return f(axy.d(z, z2));
    }

    public final aut e(boolean z, boolean z2) {
        return f(axy.d(z2, z));
    }
}
