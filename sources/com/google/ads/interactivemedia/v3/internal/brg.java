package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class brg extends brh {
    private brg() {
    }

    public static bqt a(Object obj, long j) {
        return (bqt) btf.h(obj, j);
    }

    public final List b(Object obj, long j) {
        bqt a = a(obj, j);
        if (a.c()) {
            return a;
        }
        int size = a.size();
        bqt d = a.d(size == 0 ? 10 : size + size);
        btf.w(obj, j, d);
        return d;
    }

    public final void c(Object obj, long j) {
        a(obj, j).b();
    }

    public final void d(Object obj, Object obj2, long j) {
        bqt a = a(obj, j);
        bqt a2 = a(obj2, j);
        int size = a.size();
        int size2 = a2.size();
        if (size > 0 && size2 > 0) {
            if (!a.c()) {
                a = a.d(size2 + size);
            }
            a.addAll(a2);
        }
        if (size > 0) {
            a2 = a;
        }
        btf.w(obj, j, a2);
    }

    public /* synthetic */ brg(byte[] bArr) {
    }
}
