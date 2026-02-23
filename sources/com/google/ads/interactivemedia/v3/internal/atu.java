package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class atu extends awm {
    final /* synthetic */ atw a;

    public atu(atw atwVar) {
        this.a = atwVar;
    }

    public final Map a() {
        return this.a;
    }

    public final boolean contains(Object obj) {
        return axo.H(this.a.a.entrySet(), obj);
    }

    public final Iterator iterator() {
        return new atv(this.a);
    }

    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        entry.getClass();
        auj.n(this.a.b, entry.getKey());
        return true;
    }
}
