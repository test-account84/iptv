package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ble extends AbstractSet {
    final /* synthetic */ blj a;

    public ble(blj bljVar) {
        this.a = bljVar;
    }

    public final void clear() {
        this.a.clear();
    }

    public final boolean contains(Object obj) {
        return (obj instanceof Map.Entry) && this.a.b((Map.Entry) obj) != null;
    }

    public final Iterator iterator() {
        return new bld(this);
    }

    public final boolean remove(Object obj) {
        bli b;
        if (!(obj instanceof Map.Entry) || (b = this.a.b((Map.Entry) obj)) == null) {
            return false;
        }
        this.a.e(b, true);
        return true;
    }

    public final int size() {
        return this.a.b;
    }
}
