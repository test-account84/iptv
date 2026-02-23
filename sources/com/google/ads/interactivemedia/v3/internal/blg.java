package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class blg extends AbstractSet {
    final /* synthetic */ blj a;

    public blg(blj bljVar) {
        this.a = bljVar;
    }

    public final void clear() {
        this.a.clear();
    }

    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    public final Iterator iterator() {
        return new blf(this);
    }

    public final boolean remove(Object obj) {
        return this.a.d(obj) != null;
    }

    public final int size() {
        return this.a.b;
    }
}
