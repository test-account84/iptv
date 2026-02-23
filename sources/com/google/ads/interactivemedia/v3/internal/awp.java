package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class awp extends AbstractMap {
    private transient Set a;
    private transient Set b;
    private transient Collection c;

    public abstract Set b();

    public final Set entrySet() {
        Set set = this.a;
        if (set != null) {
            return set;
        }
        Set b = b();
        this.a = b;
        return b;
    }

    public Set g() {
        return new awn(this);
    }

    public Set keySet() {
        Set set = this.b;
        if (set != null) {
            return set;
        }
        Set g = g();
        this.b = g;
        return g;
    }

    public final Collection values() {
        Collection collection = this.c;
        if (collection != null) {
            return collection;
        }
        awo awoVar = new awo(this);
        this.c = awoVar;
        return awoVar;
    }
}
