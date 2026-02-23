package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class awn extends axl {
    final Map d;

    public awn(Map map) {
        atp.k(map);
        this.d = map;
    }

    public void clear() {
        this.d.clear();
    }

    public final boolean contains(Object obj) {
        return this.d.containsKey(obj);
    }

    public final boolean isEmpty() {
        return this.d.isEmpty();
    }

    public Iterator iterator() {
        return new awk(this.d.entrySet().iterator());
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.d.remove(obj);
        return true;
    }

    public final int size() {
        return this.d.size();
    }
}
