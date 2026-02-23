package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class avy extends avo {
    final /* synthetic */ avu a;

    public avy(avu avuVar) {
        this.a = avuVar;
    }

    public final boolean f() {
        return true;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return new AbstractMap.SimpleImmutableEntry(awb.q(this.a.a).d.get(i), awb.k(this.a.a).get(i));
    }

    public final int size() {
        return this.a.a.size();
    }
}
