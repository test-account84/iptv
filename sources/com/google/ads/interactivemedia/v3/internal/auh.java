package com.google.ads.interactivemedia.v3.internal;

import java.util.ListIterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class auh extends auf implements ListIterator {
    final /* synthetic */ aui d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public auh(aui auiVar) {
        super(auiVar);
        this.d = auiVar;
    }

    private final ListIterator b() {
        a();
        return this.a;
    }

    public final void add(Object obj) {
        boolean isEmpty = this.d.isEmpty();
        b().add(obj);
        auj.q(this.d.f);
        if (isEmpty) {
            this.d.a();
        }
    }

    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    public final int nextIndex() {
        return b().nextIndex();
    }

    public final Object previous() {
        return b().previous();
    }

    public final int previousIndex() {
        return b().previousIndex();
    }

    public final void set(Object obj) {
        b().set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public auh(aui auiVar, int i) {
        super(auiVar, auiVar.d().listIterator(i));
        this.d = auiVar;
    }
}
