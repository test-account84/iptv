package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class sl extends eg {
    private final int b;
    private final int c;
    private final int[] d;
    private final int[] e;
    private final be[] f;
    private final Object[] g;
    private final HashMap h;

    public sl(Collection collection, ui uiVar) {
        super(uiVar);
        int size = collection.size();
        this.d = new int[size];
        this.e = new int[size];
        this.f = new be[size];
        this.g = new Object[size];
        this.h = new HashMap();
        Iterator it = collection.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            sn snVar = (sn) it.next();
            be[] beVarArr = this.f;
            be k = snVar.a.k();
            beVarArr[i3] = k;
            this.e[i3] = i;
            this.d[i3] = i2;
            i += k.c();
            i2 += this.f[i3].b();
            Object[] objArr = this.g;
            Object obj = snVar.b;
            objArr[i3] = obj;
            this.h.put(obj, Integer.valueOf(i3));
            i3++;
        }
        this.b = i;
        this.c = i2;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.b;
    }

    public final int r(Object obj) {
        Integer num = (Integer) this.h.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public final int s(int i) {
        return cq.b(this.d, i + 1, false, false);
    }

    public final int t(int i) {
        return cq.b(this.e, i + 1, false, false);
    }

    public final int u(int i) {
        return this.d[i];
    }

    public final int v(int i) {
        return this.e[i];
    }

    public final be w(int i) {
        return this.f[i];
    }

    public final Object z(int i) {
        return this.g[i];
    }
}
