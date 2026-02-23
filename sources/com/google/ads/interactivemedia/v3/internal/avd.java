package com.google.ads.interactivemedia.v3.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class avd implements Iterator {
    final /* synthetic */ ave a;
    private int b;
    private int c = -1;
    private int d;
    private int e;

    public avd(ave aveVar) {
        this.a = aveVar;
        this.b = avf.a(aveVar.b);
        avf avfVar = aveVar.b;
        this.d = avfVar.d;
        this.e = avfVar.c;
    }

    private final void a() {
        if (this.a.b.d != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean hasNext() {
        a();
        return this.b != -2 && this.e > 0;
    }

    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object a = this.a.a(this.b);
        this.c = this.b;
        this.b = avf.l(this.a.b)[this.b];
        this.e--;
        return a;
    }

    public final void remove() {
        a();
        axo.J(this.c != -1);
        avf avfVar = this.a.b;
        int i = this.c;
        avfVar.j(i, axo.F(avfVar.a[i]));
        int i2 = this.b;
        avf avfVar2 = this.a.b;
        if (i2 == avfVar2.c) {
            this.b = this.c;
        }
        this.c = -1;
        this.d = avfVar2.d;
    }
}
