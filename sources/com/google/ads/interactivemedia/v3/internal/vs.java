package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class vs implements Comparable {
    private final boolean a;
    private final boolean b;

    public vs(s sVar, int i) {
        this.a = 1 == (sVar.d & 1);
        this.b = wd.j(i, false);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(vs vsVar) {
        return aut.j().d(this.b, vsVar.b).d(this.a, vsVar.a).a();
    }
}
