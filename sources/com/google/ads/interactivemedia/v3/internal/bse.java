package com.google.ads.interactivemedia.v3.internal;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bse extends bou {
    final bsg a;
    box b = b();
    final /* synthetic */ bsh c;

    public bse(bsh bshVar) {
        this.c = bshVar;
        this.a = new bsg(bshVar);
    }

    private final box b() {
        bsg bsgVar = this.a;
        if (bsgVar.hasNext()) {
            return bsgVar.a().iterator();
        }
        return null;
    }

    public final byte a() {
        box boxVar = this.b;
        if (boxVar == null) {
            throw new NoSuchElementException();
        }
        byte a = boxVar.a();
        if (!this.b.hasNext()) {
            this.b = b();
        }
        return a;
    }

    public final boolean hasNext() {
        return this.b != null;
    }
}
