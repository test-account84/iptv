package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aul extends AbstractCollection {
    final /* synthetic */ aum a;

    public aul(aum aumVar) {
        this.a = aumVar;
    }

    public final void clear() {
        this.a.o();
    }

    public final boolean contains(Object obj) {
        Iterator it = this.a.w().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final Iterator iterator() {
        return this.a.f();
    }

    public final int size() {
        return this.a.d();
    }
}
