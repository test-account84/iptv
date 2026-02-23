package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsz implements Iterator {
    final Iterator a;
    final /* synthetic */ bta b;

    public bsz(bta btaVar) {
        this.b = btaVar;
        this.a = bta.a(btaVar).iterator();
    }

    public final boolean hasNext() {
        return this.a.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
