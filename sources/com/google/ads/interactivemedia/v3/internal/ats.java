package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ats extends axq {
    final /* synthetic */ Iterator a;
    final /* synthetic */ atm b;
    private Object c;
    private int d;

    public ats() {
        this.d = 2;
    }

    public final Object a() {
        while (this.a.hasNext()) {
            Object next = this.a.next();
            if (this.b.a(next)) {
                return next;
            }
        }
        b();
        return null;
    }

    public final void b() {
        this.d = 3;
    }

    public final boolean hasNext() {
        int i = this.d;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            return true;
        }
        if (i2 != 2) {
            this.d = 4;
            this.c = a();
            if (this.d != 3) {
                this.d = 1;
                return true;
            }
        }
        return false;
    }

    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.d = 2;
        Object obj = this.c;
        this.c = null;
        return obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ats(Iterator it, atm atmVar) {
        this();
        this.a = it;
        this.b = atmVar;
    }
}
