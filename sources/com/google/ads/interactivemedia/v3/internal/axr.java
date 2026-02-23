package com.google.ads.interactivemedia.v3.internal;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class axr extends axq implements ListIterator {
    private final int a;
    private int b;
    private final avo c;

    public axr() {
    }

    public final Object a(int i) {
        return this.c.get(i);
    }

    @Deprecated
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.b < this.a;
    }

    public final boolean hasPrevious() {
        return this.b > 0;
    }

    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.b = i + 1;
        return a(i);
    }

    public final int nextIndex() {
        return this.b;
    }

    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        return a(i);
    }

    public final int previousIndex() {
        return this.b - 1;
    }

    @Deprecated
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public axr(int i, int i2) {
        this();
        atp.m(i2, i);
        this.a = i;
        this.b = i2;
    }

    public axr(avo avoVar, int i) {
        this(avoVar.size(), i);
        this.c = avoVar;
    }
}
