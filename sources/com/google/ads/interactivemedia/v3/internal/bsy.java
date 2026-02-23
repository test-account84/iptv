package com.google.ads.interactivemedia.v3.internal;

import java.util.ListIterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsy implements ListIterator {
    final ListIterator a;
    final /* synthetic */ int b;
    final /* synthetic */ bta c;

    public bsy(bta btaVar, int i) {
        this.c = btaVar;
        this.b = i;
        this.a = bta.a(btaVar).listIterator(i);
    }

    public final /* bridge */ /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.a.hasPrevious();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.a.next();
    }

    public final int nextIndex() {
        return this.a.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.a.previous();
    }

    public final int previousIndex() {
        return this.a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* bridge */ /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
