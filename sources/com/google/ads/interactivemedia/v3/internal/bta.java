package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bta extends AbstractList implements RandomAccess, bre {
    private final bre a;

    public bta(bre breVar) {
        this.a = breVar;
    }

    public static /* bridge */ /* synthetic */ bre a(bta btaVar) {
        return btaVar.a;
    }

    public final bre e() {
        return this;
    }

    public final Object f(int i) {
        return this.a.f(i);
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((brd) this.a).get(i);
    }

    public final List h() {
        return this.a.h();
    }

    public final void i(bpb bpbVar) {
        throw new UnsupportedOperationException();
    }

    public final Iterator iterator() {
        return new bsz(this);
    }

    public final ListIterator listIterator(int i) {
        return new bsy(this, i);
    }

    public final int size() {
        return this.a.size();
    }
}
