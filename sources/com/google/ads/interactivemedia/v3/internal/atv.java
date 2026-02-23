package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class atv implements Iterator {
    final Iterator a;
    Collection b;
    final /* synthetic */ atw c;

    public atv(atw atwVar) {
        this.c = atwVar;
        this.a = atwVar.a.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.a.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.a.next();
        this.b = (Collection) entry.getValue();
        return this.c.a(entry);
    }

    public final void remove() {
        atp.i(this.b != null, "no calls to next() since the last call to remove()");
        this.a.remove();
        auj.t(this.c.b, this.b.size());
        this.b.clear();
        this.b = null;
    }
}
