package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractSet;
import java.util.Collection;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class axl extends AbstractSet {
    public boolean removeAll(Collection collection) {
        return axo.h(this, collection);
    }

    public boolean retainAll(Collection collection) {
        atp.k(collection);
        return super.retainAll(collection);
    }
}
