package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class avg extends avh {
    Object[] a;
    int b;
    boolean c;

    public avg() {
        axo.K(4, "initialCapacity");
        this.a = new Object[4];
        this.b = 0;
    }

    private final void f(int i) {
        Object[] objArr = this.a;
        int length = objArr.length;
        if (length < i) {
            this.a = Arrays.copyOf(objArr, avh.e(length, i));
        } else if (!this.c) {
            return;
        } else {
            this.a = (Object[]) objArr.clone();
        }
        this.c = false;
    }

    public final void a(Object obj) {
        atp.k(obj);
        f(this.b + 1);
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = obj;
    }

    public /* bridge */ /* synthetic */ void b(Object obj) {
        throw null;
    }

    public final void c(Object... objArr) {
        int length = objArr.length;
        axo.l(objArr, length);
        f(this.b + length);
        System.arraycopy(objArr, 0, this.a, this.b, length);
        this.b += length;
    }

    public final void d(Iterable iterable) {
        if (iterable instanceof Collection) {
            f(this.b + iterable.size());
            if (iterable instanceof avi) {
                this.b = ((avi) iterable).a(this.a, this.b);
                return;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }
}
