package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class aum implements awq {
    private transient Set a;
    private transient Collection b;
    private transient Map c;

    public abstract Collection e();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof awq) {
            return w().equals(((awq) obj).w());
        }
        return false;
    }

    public Iterator f() {
        throw null;
    }

    public final int hashCode() {
        return w().hashCode();
    }

    public abstract Map j();

    public abstract Set l();

    public final String toString() {
        return w().toString();
    }

    public void u(Object obj, Object obj2) {
        throw null;
    }

    public final Collection v() {
        Collection collection = this.b;
        if (collection != null) {
            return collection;
        }
        Collection e = e();
        this.b = e;
        return e;
    }

    public final Map w() {
        Map map = this.c;
        if (map != null) {
            return map;
        }
        Map j = j();
        this.c = j;
        return j;
    }

    public final Set x() {
        Set set = this.a;
        if (set != null) {
            return set;
        }
        Set l = l();
        this.a = l;
        return l;
    }
}
