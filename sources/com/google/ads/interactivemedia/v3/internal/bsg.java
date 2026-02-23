package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsg implements Iterator {
    private final ArrayDeque a;
    private boy b;

    public /* synthetic */ bsg(bpb bpbVar) {
        boy boyVar;
        if (bpbVar instanceof bsh) {
            bsh bshVar = (bsh) bpbVar;
            ArrayDeque arrayDeque = new ArrayDeque(bshVar.f());
            this.a = arrayDeque;
            arrayDeque.push(bshVar);
            boyVar = b(bsh.g(bshVar));
        } else {
            this.a = null;
            boyVar = (boy) bpbVar;
        }
        this.b = boyVar;
    }

    private final boy b(bpb bpbVar) {
        while (bpbVar instanceof bsh) {
            bsh bshVar = (bsh) bpbVar;
            this.a.push(bshVar);
            bpbVar = bsh.g(bshVar);
        }
        return (boy) bpbVar;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final boy next() {
        boy boyVar;
        boy boyVar2 = this.b;
        if (boyVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.a;
            boyVar = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            boyVar = b(bsh.D((bsh) this.a.pop()));
        } while (boyVar.A());
        this.b = boyVar;
        return boyVar2;
    }

    public final boolean hasNext() {
        return this.b != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
