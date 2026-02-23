package com.google.ads.interactivemedia.v3.internal;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class awh extends axq {
    boolean a;
    final /* synthetic */ Object b;

    public awh(Object obj) {
        this.b = obj;
    }

    public final boolean hasNext() {
        return !this.a;
    }

    public final Object next() {
        if (this.a) {
            throw new NoSuchElementException();
        }
        this.a = true;
        return this.b;
    }
}
