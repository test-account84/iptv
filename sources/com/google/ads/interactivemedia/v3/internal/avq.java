package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class avq {
    Object[] a;
    int b;
    avp c;

    public avq() {
        this(4);
    }

    private final void e(int i) {
        int i2 = i + i;
        Object[] objArr = this.a;
        int length = objArr.length;
        if (i2 > length) {
            this.a = Arrays.copyOf(objArr, avh.e(length, i2));
        }
    }

    public avq a(Object obj, Object obj2) {
        e(this.b + 1);
        axo.I(obj, obj2);
        Object[] objArr = this.a;
        int i = this.b;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.b = i + 1;
        return this;
    }

    public avs b() {
        avp avpVar = this.c;
        if (avpVar != null) {
            throw avpVar.a();
        }
        axe k = axe.k(this.b, this.a, this);
        avp avpVar2 = this.c;
        if (avpVar2 == null) {
            return k;
        }
        throw avpVar2.a();
    }

    public void c(Map.Entry entry) {
        a(entry.getKey(), entry.getValue());
    }

    public final void d(Iterable iterable) {
        if (iterable instanceof Collection) {
            e(this.b + iterable.size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            c((Map.Entry) it.next());
        }
    }

    public avq(int i) {
        this.a = new Object[i + i];
        this.b = 0;
    }
}
