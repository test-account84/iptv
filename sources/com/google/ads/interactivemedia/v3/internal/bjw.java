package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bjw extends bjy implements Iterable {
    private final List a = new ArrayList();

    public final void a(bjy bjyVar) {
        this.a.add(bjyVar);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof bjw) && ((bjw) obj).a.equals(this.a);
        }
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final Iterator iterator() {
        return this.a.iterator();
    }
}
