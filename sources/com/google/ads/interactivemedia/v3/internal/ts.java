package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ts implements uf {
    final /* synthetic */ tv a;
    private final int b;

    public ts(tv tvVar, int i) {
        this.a = tvVar;
        this.b = i;
    }

    public static /* bridge */ /* synthetic */ int c(ts tsVar) {
        return tsVar.b;
    }

    public final int a(go goVar, ef efVar, int i) {
        return this.a.g(this.b, goVar, efVar, i);
    }

    public final int b(long j) {
        return this.a.j(this.b, j);
    }

    public final void d() throws IOException {
        this.a.G(this.b);
    }

    public final boolean g() {
        return this.a.J(this.b);
    }
}
