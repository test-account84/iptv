package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class aui extends aug implements List {
    final /* synthetic */ auj f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aui(auj aujVar, Object obj, List list, aug augVar) {
        super(aujVar, obj, list, augVar);
        this.f = aujVar;
    }

    public final void add(int i, Object obj) {
        b();
        boolean isEmpty = this.b.isEmpty();
        d().add(i, obj);
        auj.q(this.f);
        if (isEmpty) {
            a();
        }
    }

    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = d().addAll(i, collection);
        if (!addAll) {
            return addAll;
        }
        auj.s(this.f, this.b.size() - size);
        if (size != 0) {
            return addAll;
        }
        a();
        return true;
    }

    public final List d() {
        return this.b;
    }

    public final Object get(int i) {
        b();
        return d().get(i);
    }

    public final int indexOf(Object obj) {
        b();
        return d().indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        b();
        return d().lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        b();
        return new auh(this);
    }

    public final Object remove(int i) {
        b();
        Object remove = d().remove(i);
        auj.r(this.f);
        c();
        return remove;
    }

    public final Object set(int i, Object obj) {
        b();
        return d().set(i, obj);
    }

    public final List subList(int i, int i2) {
        b();
        auj aujVar = this.f;
        Object obj = this.a;
        List subList = d().subList(i, i2);
        aug augVar = this.c;
        if (augVar == null) {
            augVar = this;
        }
        return aujVar.g(obj, subList, augVar);
    }

    public final ListIterator listIterator(int i) {
        b();
        return new auh(this, i);
    }
}
