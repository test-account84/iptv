package com.google.ads.interactivemedia.v3.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class blh implements Iterator {
    bli a;
    bli b = null;
    int c;
    final /* synthetic */ blj d;

    public blh(blj bljVar) {
        this.d = bljVar;
        this.a = bljVar.d.d;
        this.c = bljVar.c;
    }

    public final bli a() {
        bli bliVar = this.a;
        blj bljVar = this.d;
        if (bliVar == bljVar.d) {
            throw new NoSuchElementException();
        }
        if (bljVar.c != this.c) {
            throw new ConcurrentModificationException();
        }
        this.a = bliVar.d;
        this.b = bliVar;
        return bliVar;
    }

    public final boolean hasNext() {
        return this.a != this.d.d;
    }

    public final void remove() {
        bli bliVar = this.b;
        if (bliVar == null) {
            throw new IllegalStateException();
        }
        this.d.e(bliVar, true);
        this.b = null;
        this.c = this.d.c;
    }
}
