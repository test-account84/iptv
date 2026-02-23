package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnl extends bkl {
    final /* synthetic */ Class a;
    final /* synthetic */ bnm b;

    public bnl(bnm bnmVar, Class cls) {
        this.b = bnmVar;
        this.a = cls;
    }

    public final Object read(boh bohVar) throws IOException {
        Object read = this.b.b.read(bohVar);
        if (read == null || this.a.isInstance(read)) {
            return read;
        }
        throw new bkf("Expected a " + this.a.getName() + " but was " + read.getClass().getName() + "; at path " + bohVar.f());
    }

    public final void write(boj bojVar, Object obj) throws IOException {
        this.b.b.write(bojVar, obj);
    }
}
