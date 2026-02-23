package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class ave extends AbstractSet {
    final avf b;

    public ave(avf avfVar) {
        this.b = avfVar;
    }

    public abstract Object a(int i);

    public final void clear() {
        this.b.clear();
    }

    public final Iterator iterator() {
        return new avd(this);
    }

    public final int size() {
        return this.b.c;
    }
}
