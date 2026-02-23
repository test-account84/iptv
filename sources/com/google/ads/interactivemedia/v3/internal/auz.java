package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class auz extends AbstractMap implements Serializable, aun {
    private final avf a;
    private transient Set b;

    public auz(avf avfVar) {
        this.a = avfVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        avf.n(this.a, this);
    }

    public final void clear() {
        this.a.clear();
    }

    public final boolean containsKey(Object obj) {
        return this.a.containsValue(obj);
    }

    public final boolean containsValue(Object obj) {
        return this.a.containsKey(obj);
    }

    public final Set entrySet() {
        Set set = this.b;
        if (set != null) {
            return set;
        }
        ava avaVar = new ava(this.a);
        this.b = avaVar;
        return avaVar;
    }

    public final Object get(Object obj) {
        avf avfVar = this.a;
        int e = avfVar.e(obj);
        if (e == -1) {
            return null;
        }
        return avfVar.a[e];
    }

    public final Set keySet() {
        return this.a.h();
    }

    public final Object put(Object obj, Object obj2) {
        return this.a.q(obj, obj2);
    }

    public final Object remove(Object obj) {
        avf avfVar = this.a;
        int F = axo.F(obj);
        int f = avfVar.f(obj, F);
        if (f == -1) {
            return null;
        }
        Object obj2 = avfVar.a[f];
        avfVar.k(f, F);
        return obj2;
    }

    public final int size() {
        return this.a.c;
    }

    public final /* bridge */ /* synthetic */ Collection values() {
        return this.a.keySet();
    }
}
